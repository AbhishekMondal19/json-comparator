package com.test.json.compare.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.test.json.compare.app.model.BaseContent;
import com.test.json.compare.app.model.BaseContentDO;
import com.test.json.compare.app.repository.JSONCrudRepo;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.rowset.serial.SerialClob;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.*;

@RestController
public class JSONCompareController {
    private static Logger LOGGER = LoggerFactory.getLogger(JSONCompareController.class);

    @Autowired
    private JSONCrudRepo jsonCrudRepo;

    @PostMapping("/json")
    public ResponseEntity<String> saveJsonData(@RequestBody BaseContent baseContent) throws SQLException, JsonProcessingException {
        BaseContentDO baseContentDO = new BaseContentDO();
        LOGGER.debug("Base Content : {} ", baseContent.toString());
        ObjectMapper mapper = new ObjectMapper();
        String jsonInputStr = mapper.writeValueAsString(baseContent);
        LOGGER.debug("Json Input String : {} ", jsonInputStr);
        Clob myClob = new SerialClob(jsonInputStr.toCharArray());
        baseContentDO.setJsonData(myClob);
        jsonCrudRepo.save(baseContentDO);
        LOGGER.debug("Data inserted successfully");
        return new ResponseEntity<String>("Success", HttpStatus.CREATED);
    }

    @GetMapping("/jsondata/{baseJsonID}")
    public String fetchJsonDetails(@PathVariable("baseJsonID") Integer baseJsonID) throws SQLException, IOException {
        LOGGER.info("Base Json ID : {} ", baseJsonID);

        StringBuffer response = new StringBuffer();
        Optional<BaseContentDO> optional = jsonCrudRepo.findById(baseJsonID);
        if (optional.isPresent()) {
            LOGGER.debug("Response from DB :: {} ", optional.get());
            Clob clob = optional.get().getJsonData();
            Reader r = clob.getCharacterStream();
            int ch;
            while ((ch = r.read()) != -1) {
                response.append("" + (char) ch);
            }
            response.replace(0, 11, "");
            System.out.println("Contents: " + response.toString());
        }
        return response.toString();
    }

    @PutMapping("/jsondata/{baseJsonID}")
    public String updateJsonDetails(@PathVariable("baseJsonID") Integer baseJsonID, @RequestBody BaseContent baseContent) throws SQLException {
        LOGGER.info("Base Json ID : {} ", baseJsonID);
        String response = "Update Successful";
        Optional<BaseContentDO> optional = jsonCrudRepo.findById(baseJsonID);
        if (optional.isPresent()) {
            try {
                BaseContentDO baseContentDO = new BaseContentDO();
                LOGGER.debug("Base Content : {} ", baseContent.toString());
                Clob myClob = new SerialClob(baseContent.toString().toCharArray());
                baseContentDO.setBaseJsonID(baseJsonID);
                baseContentDO.setJsonData(myClob);
                jsonCrudRepo.save(baseContentDO);
            } catch (Exception ex) {
                LOGGER.error("Error occured during update : {} ", ex.getCause());
                response = "Update Failed";
            }
        }

        return response;
    }

    @DeleteMapping("/jsondata/{baseJsonID}")
    public String updateJsonDetails(@PathVariable("baseJsonID") Integer baseJsonID) {
        LOGGER.info("Base Json ID : {} ", baseJsonID);
        String response = "Delete Successful";
        Optional<BaseContentDO> optional = jsonCrudRepo.findById(baseJsonID);
        if (optional.isPresent()) {
            try {
                jsonCrudRepo.deleteById(baseJsonID);
            } catch (Exception ex) {
                LOGGER.error("Error occured during delete : {} ", ex.getCause());
                response = "Deletion Failed";
            }
        }
        return response;
    }

    @PostMapping("compare-json/{baseJsonID}")
    public String compareJSONContents(@PathVariable("baseJsonID") Integer baseJsonID, @RequestBody BaseContent baseContent) {
        LOGGER.debug("Input Content : {} ", baseContent.toString());
        StringBuffer response = new StringBuffer();
        Optional<BaseContentDO> optional = jsonCrudRepo.findById(baseJsonID);
        if (optional.isPresent()) {
            try {
                Clob clob = optional.get().getJsonData();
                Reader r = clob.getCharacterStream();
                int ch;
                while ((ch = r.read()) != -1) {
                    response.append("" + (char) ch);
                }
                //response.replace(0, 11, "");
                String dbJsonStr = response.toString();
                LOGGER.debug("Contents from DB :  {}"  ,dbJsonStr);
                ObjectMapper mapper = new ObjectMapper();
                String jsonInputStr = mapper.writeValueAsString(baseContent);
                LOGGER.debug("Json Input String : {} ", jsonInputStr);

                Gson gson = new Gson();
                Type mapType = new TypeToken<Map<String, Object>>(){}.getType();
                Map<String, Object> firstMap = gson.fromJson(dbJsonStr, mapType);
                Map<String, Object> secondMap = gson.fromJson(jsonInputStr, mapType);
                LOGGER.debug(" Diff :: {}" ,Maps.difference(firstMap, secondMap));

            } catch (Exception ex) {
                LOGGER.error("Error occurred while camparing two JSON data :: {}", ex.getCause());
            }
        }

        return response.toString();
    }

    public static Object jsonsEqual(Object obj1, Object obj2) throws JSONException {
        JSONObject diff = new JSONObject();

        JSONObject jsonObj1 = (JSONObject) obj1;

        JSONObject jsonObj2 = (JSONObject) obj2;

        List<String> names = new ArrayList(Arrays.asList(JSONObject.getNames(jsonObj1)));
        List<String> names2 = new ArrayList(Arrays.asList(JSONObject.getNames(jsonObj2)));
        if (!names.containsAll(names2) && names2.removeAll(names)) {
            for (String fieldName : names2) {
                if (jsonObj1.has(fieldName))
                    diff.put(fieldName, jsonObj1.get(fieldName));
                else if (jsonObj2.has(fieldName))
                    diff.put(fieldName, jsonObj2.get(fieldName));
            }
            names2 = Arrays.asList(JSONObject.getNames(jsonObj2));
        }

        if (names.containsAll(names2)) {
            for (String fieldName : names) {
                Object obj1FieldValue = jsonObj1.get(fieldName);
                Object obj2FieldValue = jsonObj2.get(fieldName);
                Object obj = jsonsEqual(obj1FieldValue, obj2FieldValue);
                if (obj != null && !checkObjectIsEmpty(obj))
                    diff.put(fieldName, obj);
            }
        }
        return diff;
    }

    private static boolean checkObjectIsEmpty(Object obj) {
        if (obj == null)
            return true;
        String objData = obj.toString();
        if (objData.length() == 0)
            return true;
        if (objData.equalsIgnoreCase("{}"))
            return true;
        return false;
    }
}

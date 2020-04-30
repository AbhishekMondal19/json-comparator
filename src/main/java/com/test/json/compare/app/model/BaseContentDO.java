package com.test.json.compare.app.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Clob;

@Entity
@Data
@Table(name = "input_data")
public class BaseContentDO implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -2762479334258915073L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer baseJsonID;

    private Clob jsonData;

    public Integer getBaseJsonID() {
        return baseJsonID;
    }

    public void setBaseJsonID(Integer baseJsonID) {
        this.baseJsonID = baseJsonID;
    }

    public Clob getJsonData() {
        return jsonData;
    }

    public void setJsonData(Clob jsonData) {
        this.jsonData = jsonData;
    }

    @Override
    public String toString() {
        return "InputData [baseJsonID=" + baseJsonID + ", jsonData=" + jsonData + "]";
    }
}

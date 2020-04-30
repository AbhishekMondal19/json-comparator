
package com.test.json.compare.app.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dataTypeDefnId",
    "name",
    "parameterDefns"
})
public class DataTypeDefn__ {

    @JsonProperty("dataTypeDefnId")
    private String dataTypeDefnId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("parameterDefns")
    private List<Object> parameterDefns = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("dataTypeDefnId")
    public String getDataTypeDefnId() {
        return dataTypeDefnId;
    }

    @JsonProperty("dataTypeDefnId")
    public void setDataTypeDefnId(String dataTypeDefnId) {
        this.dataTypeDefnId = dataTypeDefnId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("parameterDefns")
    public List<Object> getParameterDefns() {
        return parameterDefns;
    }

    @JsonProperty("parameterDefns")
    public void setParameterDefns(List<Object> parameterDefns) {
        this.parameterDefns = parameterDefns;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "DataTypeDefn__{" +
                "dataTypeDefnId='" + dataTypeDefnId + '\'' +
                ", name='" + name + '\'' +
                ", parameterDefns=" + parameterDefns +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}

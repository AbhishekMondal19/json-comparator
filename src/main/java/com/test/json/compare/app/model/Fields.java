
package com.test.json.compare.app.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "deptDivId",
    "deptId",
    "divId",
    "name"
})
public class Fields {

    @JsonProperty("deptDivId")
    private DeptDivId deptDivId;
    @JsonProperty("deptId")
    private DeptId deptId;
    @JsonProperty("divId")
    private DivId divId;
    @JsonProperty("name")
    private Name name;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("deptDivId")
    public DeptDivId getDeptDivId() {
        return deptDivId;
    }

    @JsonProperty("deptDivId")
    public void setDeptDivId(DeptDivId deptDivId) {
        this.deptDivId = deptDivId;
    }

    @JsonProperty("deptId")
    public DeptId getDeptId() {
        return deptId;
    }

    @JsonProperty("deptId")
    public void setDeptId(DeptId deptId) {
        this.deptId = deptId;
    }

    @JsonProperty("divId")
    public DivId getDivId() {
        return divId;
    }

    @JsonProperty("divId")
    public void setDivId(DivId divId) {
        this.divId = divId;
    }

    @JsonProperty("name")
    public Name getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(Name name) {
        this.name = name;
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
        return "Fields{" +
                "deptDivId=" + deptDivId +
                ", deptId=" + deptId +
                ", divId=" + divId +
                ", name=" + name +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}

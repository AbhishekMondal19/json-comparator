
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
    "apiConnectionDefnId",
    "apiPath",
    "name",
    "label",
    "description",
    "version",
    "activeFlag",
    "type",
    "tenantId",
    "apiHeaders",
    "apiConnectionDefn",
    "baseMasterDataDefnId",
    "objectDefn",
    "fields"
})
public class Content {

    @JsonProperty("apiConnectionDefnId")
    private Object apiConnectionDefnId;
    @JsonProperty("apiPath")
    private Object apiPath;
    @JsonProperty("name")
    private String name;
    @JsonProperty("label")
    private String label;
    @JsonProperty("description")
    private String description;
    @JsonProperty("version")
    private Integer version;
    @JsonProperty("activeFlag")
    private Boolean activeFlag;
    @JsonProperty("type")
    private String type;
    @JsonProperty("tenantId")
    private String tenantId;
    @JsonProperty("apiHeaders")
    private ApiHeaders apiHeaders;
    @JsonProperty("apiConnectionDefn")
    private Object apiConnectionDefn;
    @JsonProperty("baseMasterDataDefnId")
    private Object baseMasterDataDefnId;
    @JsonProperty("objectDefn")
    private Object objectDefn;
    @JsonProperty("fields")
    private Fields fields;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("apiConnectionDefnId")
    public Object getApiConnectionDefnId() {
        return apiConnectionDefnId;
    }

    @JsonProperty("apiConnectionDefnId")
    public void setApiConnectionDefnId(Object apiConnectionDefnId) {
        this.apiConnectionDefnId = apiConnectionDefnId;
    }

    @JsonProperty("apiPath")
    public Object getApiPath() {
        return apiPath;
    }

    @JsonProperty("apiPath")
    public void setApiPath(Object apiPath) {
        this.apiPath = apiPath;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("version")
    public Integer getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(Integer version) {
        this.version = version;
    }

    @JsonProperty("activeFlag")
    public Boolean getActiveFlag() {
        return activeFlag;
    }

    @JsonProperty("activeFlag")
    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("tenantId")
    public String getTenantId() {
        return tenantId;
    }

    @JsonProperty("tenantId")
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    @JsonProperty("apiHeaders")
    public ApiHeaders getApiHeaders() {
        return apiHeaders;
    }

    @JsonProperty("apiHeaders")
    public void setApiHeaders(ApiHeaders apiHeaders) {
        this.apiHeaders = apiHeaders;
    }

    @JsonProperty("apiConnectionDefn")
    public Object getApiConnectionDefn() {
        return apiConnectionDefn;
    }

    @JsonProperty("apiConnectionDefn")
    public void setApiConnectionDefn(Object apiConnectionDefn) {
        this.apiConnectionDefn = apiConnectionDefn;
    }

    @JsonProperty("baseMasterDataDefnId")
    public Object getBaseMasterDataDefnId() {
        return baseMasterDataDefnId;
    }

    @JsonProperty("baseMasterDataDefnId")
    public void setBaseMasterDataDefnId(Object baseMasterDataDefnId) {
        this.baseMasterDataDefnId = baseMasterDataDefnId;
    }

    @JsonProperty("objectDefn")
    public Object getObjectDefn() {
        return objectDefn;
    }

    @JsonProperty("objectDefn")
    public void setObjectDefn(Object objectDefn) {
        this.objectDefn = objectDefn;
    }

    @JsonProperty("fields")
    public Fields getFields() {
        return fields;
    }

    @JsonProperty("fields")
    public void setFields(Fields fields) {
        this.fields = fields;
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
        return "Content{" +
                "apiConnectionDefnId=" + apiConnectionDefnId +
                ", apiPath=" + apiPath +
                ", name='" + name + '\'' +
                ", label='" + label + '\'' +
                ", description='" + description + '\'' +
                ", version=" + version +
                ", activeFlag=" + activeFlag +
                ", type='" + type + '\'' +
                ", tenantId='" + tenantId + '\'' +
                ", apiHeaders=" + apiHeaders +
                ", apiConnectionDefn=" + apiConnectionDefn +
                ", baseMasterDataDefnId=" + baseMasterDataDefnId +
                ", objectDefn=" + objectDefn +
                ", fields=" + fields +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}

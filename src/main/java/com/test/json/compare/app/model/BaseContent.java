
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
    "status",
    "content",
    "messages"
})
public class BaseContent {

    @JsonProperty("status")
    private String status;
    @JsonProperty("content")
    private List<Content> content = null;
    @JsonProperty("messages")
    private List<Object> messages = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("content")
    public List<Content> getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(List<Content> content) {
        this.content = content;
    }

    @JsonProperty("messages")
    public List<Object> getMessages() {
        return messages;
    }

    @JsonProperty("messages")
    public void setMessages(List<Object> messages) {
        this.messages = messages;
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
        return "BaseContent{" +
                "status='" + status + '\'' +
                ", content=" + content +
                ", messages=" + messages +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}

package com.wolknashatle.dataanalizeservice.exceptions;

import java.util.Arrays;
import java.util.Map;

public class ApiErrorResponce {

    private String title;
    private String type;
    private Map<String, String> properties;
    private String[] required;

    public ApiErrorResponce(String title, String type, Map<String, String> properties, String[] required) {
        this.title = title;
        this.type = type;
        this.properties = properties;
        this.required = required;
    }

    @Override
    public String toString() {
        return "ApiErrorResponce{" +
                "title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", properties=" + properties +
                ", required=" + Arrays.toString(required) +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public String[] getRequired() {
        return required;
    }

    public void setRequired(String[] required) {
        this.required = required;
    }
}

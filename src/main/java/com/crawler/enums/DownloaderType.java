package com.crawler.enums;

/**
 * description
 * Created by Sun on 2015/12/9.
 */
public enum DownloaderType {
    HTML("HTML"),
    IMAGE("IMAGE"),
    VIDEO("VIDEO");

    private String value;

    private DownloaderType(String type) {
        this.value = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}

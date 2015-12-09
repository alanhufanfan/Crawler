package com.crawler.config;

import com.crawler.enums.DownloaderType;

/**
 * description
 * Created by Sun on 2015/12/9.
 */
public class ConfigEntity {

    private String url;
    private String downloaderTypeStr;
    private DownloaderType downloaderType;
    private String spiderTypeStr;
    private String spiderType;

    //todo 枚举一下
    ConfigEntity(String url, String spiderTypeStr){
        this.url = url;
        this.url = url;
        this.url = url;
    }

    ConfigEntity(String url, String spiderTypeStr,String downloaderTypeStr ){

    }


    public String getSpiderType() {
        return spiderType;
    }

    public DownloaderType getDownloaderType() {
        return downloaderType;
    }

    public String getUrl() {
        return url;
    }
}

package com.crawler.config;

import com.crawler.enums.DownloaderType;

/**
 * description
 * Created by Sun on 2015/12/9.
 */
public class URLEntity {

    private String url;
    private String downloaderTypeStr;
    private DownloaderType downloaderType;
    private String spiderTypeStr;
    private String spiderType;

    //todo 枚举一下
    public URLEntity(String url, String spiderTypeStr){
        this.url = url;
        this.url = url;
        this.url = url;
    }

    public URLEntity(String url, DownloaderType downloaderType){
        this.url = url;
        this.downloaderType = downloaderType;
    }

    public URLEntity(String url, String spiderTypeStr, String downloaderTypeStr){

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

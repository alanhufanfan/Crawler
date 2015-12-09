package com.crawler.engine;

import com.crawler.config.ConfigEntity;
import com.crawler.downloader.Downloader;
import com.crawler.downloader.HTMLDownloader;
import com.crawler.downloader.ImageDownloader;
import com.crawler.downloader.VideoDownloader;
import com.crawler.enums.DownloaderType;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * description
 * Created by Sun on 2015/12/9.
 */
public class EngineSuper {

    //url=》classType
    private static HashSet<ConfigEntity> spiders = new HashSet<ConfigEntity>();

    public static void main(String[] args) {
        System.out.println("start---------->");
    }

    public EngineSuper() {
        //初始化设置 ，spider设置，db设置
//        this.spiders.put("http://www.baidu.com", "com.crawler.spiders.Baidu");
//        读取配置
    }

    //todo  定时
    public void start() {
        Iterator iterator = this.spiders.iterator();
        //启动多个线程
        while (iterator.hasNext()) {
            final Map.Entry entry = (Map.Entry) iterator.next();
            new Thread(new Runnable() {
                public void run() {
                    ConfigEntity url = (ConfigEntity) entry.getValue();
                    DownloaderType downloaderType = url.getDownloaderType();
                    Downloader downloader;
                    switch (downloaderType) {
                        case HTML:
                            downloader = new HTMLDownloader("");
                            break;
                        case IMAGE:
                            downloader = new ImageDownloader();
                            break;
                        case VIDEO:
                            downloader = new VideoDownloader();
                            break;
                        default:
                            downloader = new HTMLDownloader("");
                    }
                    downloader.down();

                    if (downloaderType == DownloaderType.HTML) {
                        //根据url的配置，与spider 的注解来使用对应的parser
                    }
                }
            }).start();
        }
    }

    //读配置，然后抓取，这个过程都是进行http请求


    //抓取之后进行处理  ，不同的url使用不同的spider处理


    //入库


}

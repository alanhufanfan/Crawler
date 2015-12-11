package com.crawler.engine;

import com.crawler.config.URLEntity;
import com.crawler.downloader.Downloader;
import com.crawler.downloader.HTMLDownloader;
import com.crawler.downloader.ImageDownloader;
import com.crawler.downloader.VideoDownloader;
import com.crawler.enums.DownloaderType;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * description
 * Created by Sun on 2015/12/9.
 */
public class EngineSuper {

    //url=》classType
    private static HashSet<URLEntity> urls = new HashSet<URLEntity>();

    public static void main(String[] args) {
        System.out.println("start---------->");
    }

    public EngineSuper() {
        this.urls.add(new URLEntity("http://moment.douban.com/post/117638/?douban_rec=1",DownloaderType.HTML));
        //读取配置

        //启动线程池

        //初始化队列
    }

    public void start() {
        //启动线程池，监听队列
        Iterator iterator = this.urls.iterator();
        while (iterator.hasNext()) {
            final URLEntity url = (URLEntity)iterator.next();
            new Thread(new Runnable() {
                public void run() {
                    DownloaderType downloaderType = url.getDownloaderType();
                    Downloader downloader;
                    switch (downloaderType) {
                        case HTML:
                            downloader = new HTMLDownloader(url);
                            break;
                        case IMAGE:
                            downloader = new ImageDownloader();
                            break;
                        case VIDEO:
                            downloader = new VideoDownloader();
                            break;
                        default:
                            downloader = new HTMLDownloader(url);
                    }
                    downloader.down();
                }
            }).start();
        }
    }

    /**
     * todo
     * 解决一个段落里面有图片，但是图片下载失败的问题。
     * 这是一个事务的问题，解决一致性问题
     */
    private void play(){
        // DOWN  SAVE     DOWNLOADER


        //PARSE  CALLBACK(SAVE)  NULL  PARSER   push queue


        //SAVE   DB
    }
}

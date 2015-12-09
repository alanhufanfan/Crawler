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

    //url=��classType
    private static HashSet<ConfigEntity> spiders = new HashSet<ConfigEntity>();

    public static void main(String[] args) {
        System.out.println("start---------->");
    }

    public EngineSuper() {
        //��ʼ������ ��spider���ã�db����
//        this.spiders.put("http://www.baidu.com", "com.crawler.spiders.Baidu");
//        ��ȡ����
    }

    //todo  ��ʱ
    public void start() {
        Iterator iterator = this.spiders.iterator();
        //��������߳�
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
                        //����url�����ã���spider ��ע����ʹ�ö�Ӧ��parser
                    }
                }
            }).start();
        }
    }

    //�����ã�Ȼ��ץȡ��������̶��ǽ���http����


    //ץȡ֮����д���  ����ͬ��urlʹ�ò�ͬ��spider����


    //���


}

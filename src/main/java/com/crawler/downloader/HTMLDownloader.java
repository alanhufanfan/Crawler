package com.crawler.downloader;

import com.crawler.config.URLEntity;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Iterator;

/**
 * description
 * Created by Sun on 2015/12/9.
 */
public class HTMLDownloader extends DownloaderSuper {


    private URLEntity url;


    private String content = "";

    public static void main(String[] args) {

    }

    public HTMLDownloader(URLEntity url) {
        this.url = url;
    }

    public void down() {
//        get();
        try {
            org.jsoup.nodes.Document doc = Jsoup.connect(this.url.getUrl()).userAgent("Mozilla/5.0 (jsoup)").timeout(5000).get();
            Elements divs = doc.getElementById("content").children();

            Iterator it = divs.iterator();
            while (it.hasNext()){
                Element element = (Element) it.next();

                System.out.println(element.getElementsByClass("bd").text());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void get() {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            // 创建httpget.
            HttpGet httpget = new HttpGet(this.url.getUrl());
            System.out.println("executing request " + httpget.getURI());
            // 执行get请求.
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                // 获取响应实体
                HttpEntity entity = response.getEntity();
                System.out.println("--------------------------------------");
                // 打印响应状态
                System.out.println(response.getStatusLine());
                if (entity != null) {
                    // 打印响应内容长度
                    System.out.println("Response content length: " + entity.getContentLength());
                    // 打印响应内容
                    System.out.println("Response content: " + EntityUtils.toString(entity));

                    parse(entity);
                }
                System.out.println("------------------------------------");
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getContent() {
        return content;
    }

    public void parse(HttpEntity entity) {
        //根据url的配置，与spider 的注解来使用对应的parse

        try {
            entity.getContent();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parse(String urlStr) {

    }

}

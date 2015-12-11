package com.crawler.config;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.*;

/**
 * description
 * Created by Sun on 2015/12/11.
 */
public class Configuration {

    private static Gson gson = new Gson();

    private static ConfigInfo configInfo = null;

    public static void main(String[] args) {
        try {
            new Configuration().init();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void init() throws FileNotFoundException {
        InputStream input = new FileInputStream(new File("D:\\java\\Crawler\\src\\main\\resources\\urlconfig.json"));
        JsonReader reader = new JsonReader(new InputStreamReader(input));

        this.configInfo = gson.fromJson(reader, ConfigInfo.class);

        System.out.println("---------");
    }

}

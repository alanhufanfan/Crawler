package com.test.enums;

import com.crawler.enums.DownloaderType;

/**
 * description
 * Created by Sun on 2015/12/9.
 */
public class Test {

    public static void main(String[] args) {

        String s = "html";
       String a =  DownloaderType.IMAGE.getValue();

        System.out.println(a);
        DownloaderType type = DownloaderType.HTML;
        switch (type){
            case HTML:
                System.out.println(DownloaderType.HTML.getValue());

        }
    }

}

package com.crawler.spiders;

/**
 * description
 * Created by Sun on 2015/12/9.
 */
public class DoubanyikeParser<T> extends ParserSuper {

    private T content;

    public static void main(String[] args) {

    }

    @Override
    public void process() {
            //把图片新开个线程来下载

        //把图片路径处理成占位符，

        //把处理好的文本 放入 db
    }

    public DoubanyikeParser(T content) {
        this.content = content;
    }

}

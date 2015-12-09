package com.crawler.downloader;

/**
 * description
 * Created by Sun on 2015/12/9.
 */
public interface Downloader<T> {

    public void down();
    public T getContent();
}

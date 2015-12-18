package com.crawler.queue;

public interface Action<T> {
    void run(T var1);
}
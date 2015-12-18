package com.crawler.queue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 初始化多线程来监听队列，进行处理
 * Created by Sun on 2015/12/14.
 */
public class FastQueue<T> {

    private int threadCount;

    private String name;

    private Queue<T> queue;

    private volatile int capacity;

    private ArrayList<ThreadProcess> threadProcesses = new ArrayList<ThreadProcess>();

    //todo  可以设置多个个性化 dequeueAction
    public FastQueue(int threadCount, String name, Action<T> dequeueAction) {
        this.threadCount = threadCount;
        this.name = name;
        this.queue = new ConcurrentLinkedQueue<T>();
        this.capacity = 65536;
        for (int i = 0; i < threadCount; i++) {
            ThreadProcess t = new ThreadProcess(queue, dequeueAction);
            t.start();
            threadProcesses.add(t);
        }
    }

    public void enQueue(T a) {
        if (queue.size() > capacity) {
            return;
        }
        queue.add(a);
    }

    public void deQueue(T a) {
        if (queue.contains(a)) {
            queue.remove(a);
        }
    }

    public void flush() {
        queue.clear();
    }

    public int size() {
        return queue.size();
    }

    public Iterator<T> iterator() {
        return queue.iterator();
    }

    public void setRunStatus(boolean status) {

        Iterator<ThreadProcess> it = threadProcesses.iterator();
        while (it.hasNext()) {
            ThreadProcess item = it.next();
            item.setStatusFlag(status);
        }
    }


}

class ThreadProcess<T> extends Thread {

    private Queue<T> queue;

    private int lazyMs = 100;

    private Action<T> dequeueAction;

    private boolean statusFlag = true;

    public ThreadProcess(Queue<T> queue, Action<T> dequeueAction) {
        this.queue = queue;
        this.dequeueAction = dequeueAction;
    }

    @Override
    public void run() {
        while (statusFlag) {
            if (queue.size() > 0) {
                System.out.println(Thread.currentThread().getName());
                System.out.println("size--->" + queue.size());
                T t = queue.poll();
                //多线程的时候这里有可能是null
                if (t != null) {
                    dequeueAction.run(t);
                }
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean setStatusFlag(boolean status) {
        this.statusFlag = status;
        return this.statusFlag;
    }
}

package com.test.queue;

import com.crawler.queue.Action;
import com.crawler.queue.FastQueue;
import com.crawler.queue.LazyQueue;
import org.junit.Test;

import java.util.List;

/**
 * description
 * Created by Sun on 2015/12/14.
 */
public class TestQueue {

    public static void main(String[] args) {
//        new TestQueue().testQ();
        new TestQueue().testFastQueue();
    }


    @Test
    public void testQ() {
        System.out.println("testQ ----->start");
        LazyQueue<Integer> queue = new LazyQueue<Integer>("TestLazyQueue", 1000, 30, new Action<List<Integer>>() {
            @Override
            public void run(List<Integer> a) {
                System.out.println(a);
            }
        });
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
//        try {
//            Thread.sleep(300);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        queue.flush();
//        queue.getCapacity();
//        queue.getName();
//        queue.iterator();
//        queue.setCapacity(10);
//        queue.size();
//        System.out.println(queue.toString());;
//        queue.setRunStatus(false);

    }

    @Test
    public void testInterrupt() {

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("WWWWWWWWWWWWWWWWW");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                    System.out.println("打断啦 擦");
                    e.printStackTrace();
                }
            }
        });

        a.start();

        try {
            System.out.println("cacaca");
            a.interrupt();

            Thread.sleep(100);
            System.out.println(a.isInterrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testWhile() {
        while (true) {

            System.out.println("@@@@@@@@@");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testFastQueue() {
        FastQueue<Integer> q = new FastQueue<Integer>(2, "testFastQ", new Action<Integer>() {
            @Override
            public void run(Integer var1) {

                System.out.println(
                        String.format("%s : %s  ",
                                Thread.currentThread().getName(),
                                var1
                        )

                );

            }
        });
        int i = 0;
        while (true) {
            q.enQueue(i++);
            if(i==1000){
                q.setRunStatus(false);
                return;
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}

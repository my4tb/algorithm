package com.my4tb.concurrency.tools;

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

/**
 * 一个或多个线程等待所有任务执行完毕，再继续执行。
 * 使用AQS辅助完成子线程完成情况的计数：初始化传入的线程数，作为AQS的state，
 * 每一个线程完成任务，调用countDown()，都会通过调用releaseShared()方法将state减一。
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(4); // 3个子任务

        IntStream.range(0, 3).forEach(i -> new Thread(() -> {
            try {
                Thread.sleep(2000); // 模拟子任务执行
                System.out.println("hello");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        }).start());

        System.out.println("子线程启动完毕");

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程执行完毕");

    }

}

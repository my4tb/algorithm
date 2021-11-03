package com.my4tb.concurrent.threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.StringJoiner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _04_transmittableThreadLocal {

    private static final ExecutorService executor =
            TtlExecutors.getTtlExecutorService(Executors.newFixedThreadPool(2));

    private static final ThreadLocal<Integer> tl = new TransmittableThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            String currName = "thread-1";
            tl.set(1);

            assert executor != null;

            executor.execute(() -> {
                sleep(1);
                System.out.printf("本地变量改变之前(1), 父线程名称-%s, 子线程名称-%s, 变量值=%s%n", currName, Thread.currentThread().getName(), tl.get());
            });
            executor.execute(() -> {
                sleep(1);
                System.out.printf("本地变量改变之前(1), 父线程名称-%s, 子线程名称-%s, 变量值=%s%n", currName, Thread.currentThread().getName(), tl.get());
            });
            executor.execute(() -> {
                sleep(1);
                System.out.printf("本地变量改变之前(1), 父线程名称-%s, 子线程名称-%s, 变量值=%s%n", currName, Thread.currentThread().getName(), tl.get());
            });

            sleep(5); // 确保上面三次execute执行完毕 线程池中所有线程创建完毕
            tl.set(2); // 修改变量值

            executor.execute(() -> {
                sleep(1L);
                System.out.printf("本地变量改变之后(2), 父线程名称-%s, 子线程名称-%s, 变量值=%s%n", currName, Thread.currentThread().getName(), tl.get());
            });

            executor.execute(() -> {
                sleep(1L);
                System.out.printf("本地变量改变之后(2), 父线程名称-%s, 子线程名称-%s, 变量值=%s%n", currName, Thread.currentThread().getName(), tl.get());
            });

            executor.execute(() -> {
                sleep(1L);
                System.out.printf("本地变量改变之后(2), 父线程名称-%s, 子线程名称-%s, 变量值=%s%n", currName, Thread.currentThread().getName(), tl.get());
            });

            System.out.println(String.format("线程名称-%s, 变量值=%s", Thread.currentThread().getName(), tl.get()));
        }).start();
    }

    private static void print() {
        StringJoiner joiner = new StringJoiner("\t|\t")
                .add(String.format("thread name : %s", Thread.currentThread().getName()))
                .add(String.format("data : %s", tl.get()));
        System.out.println(joiner);
    }

    private static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

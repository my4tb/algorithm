package com.my4tb.concurrent.threadlocal;

import java.util.StringJoiner;

public class _01_threadLocal {

    static final ThreadLocal<String> tl = new ThreadLocal<>(); // 同一个

    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().setName("main");
        tl.set("val in main");
        print();

        new Thread(() -> {
            Thread.currentThread().setName("sub");
            print();
            tl.set("val in sub");
            print();
        }).start();

        Thread.sleep(1000);
        print();
    }

    private static void print() {
        StringJoiner joiner = new StringJoiner("\t|\t")
                .add(String.format("thread name : %s", Thread.currentThread().getName()))
                .add(String.format("data : %s", tl.get()));
        System.out.println(joiner);
    }

}

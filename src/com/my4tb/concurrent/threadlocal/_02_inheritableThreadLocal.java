package com.my4tb.concurrent.threadlocal;

import java.util.StringJoiner;

public class _02_inheritableThreadLocal {

    static final ThreadLocal<Hello> tl = new InheritableThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

        Thread.currentThread().setName("main");

        Hello hello = new Hello("init");
        tl.set(hello);
        print();

        new Thread(() -> {
            Thread.currentThread().setName("sub");
            Hello sub_hello = tl.get();
            sub_hello.name = "sub_init";
            print();
        }).start();

        Thread.sleep(1_000);
        print();

    }

    private static class Hello {
        private String name;
        Hello(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Hello{" +
                    " name = '" + name + '\'' +
                    '}';
        }
    }

    private static void print() {
        StringJoiner joiner = new StringJoiner("\t|\t")
                .add(String.format("thread name : %s", Thread.currentThread().getName()))
                .add(String.format("data : %s", tl.get()));
        System.out.println(joiner);
    }

}

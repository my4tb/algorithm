package com.my4tb.concurrent.threadlocal;

import java.util.StringJoiner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _03_inheritableThreadLocal_pool {

    private static final ExecutorService executor = Executors.newFixedThreadPool(1);

    private static final ThreadLocal<Integer> tl = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        Thread.currentThread().setName("main");
        tl.set(1); // 父线程设置值1
        print(); // 打印

        // 子线程 第一次执行需要创建线程 获得了父线程的值
        executor.execute(_03_inheritableThreadLocal_pool::print);

        tl.set(2); // 父线程设置值2
        print(); // 打印

        // 不发生创建子线程动作 更新后的值不会传递
        executor.execute(_03_inheritableThreadLocal_pool::print);
    }

    private static void print() {
        StringJoiner joiner = new StringJoiner("\t|\t")
                .add(String.format("thread name : %s", Thread.currentThread().getName()))
                .add(String.format("data : %s", tl.get()));
        System.out.println(joiner);
    }

}

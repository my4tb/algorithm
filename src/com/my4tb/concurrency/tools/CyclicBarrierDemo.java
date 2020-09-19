package com.my4tb.concurrency.tools;

import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;

/**
 * CyclicBarrier是多个线程在某个节点互相等待，当所有线程都达到此节点后，这些线程才同时向下执行。
 *
 * CyclicBarrier可以重复使用，当多个线程冲破屏障后，计数会恢复初始值。
 *
 * 通过Lock和Condition实现，执行逻辑为：
 * 1、初始化CyclicBarrier，包括parties、count以及可选的Runnable
 * 2、调用CyclicBarrier的await()方法时，如果计数器count已经归零，则先执行可选的Runnable，然后开始下一个Generation
 * 3、在下一个Generation中，会重置count和parties，并创建新的Generation实例
 * 4、调用Condition的signalAll()方法，唤醒所有屏障处等待的线程
 * 5、调用CyclicBarrier的await()方法时，如果计数器count没有归零，则会调用Condition的await()方法，令线程在屏障前等待
 * 6、上述所有逻辑都在Lock内执行，不会出现并发安全问题
 *
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {

        /*
            初始化入参为3，表示需要有3个线程到达屏障后才能继续推进。
         */
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> System.out.println("自定义runnable"));

//        IntStream.range(0, 3).forEach(i -> new Thread(() -> {
//            try {
//                Thread.sleep((long) (Math.random() * 2000));
//                System.out.println(Thread.currentThread().getName());
//                cyclicBarrier.await();
//                System.out.println(Thread.currentThread().getName());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }).start());

        IntStream.range(0, 2).forEach(i -> IntStream.range(0, 3).forEach(j -> new Thread(() -> {
            try {
                Thread.sleep((long) (Math.random() * 5000));
                System.out.println(Thread.currentThread().getName());
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start()));

    }

}

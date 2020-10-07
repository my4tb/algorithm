package com.my4tb.concurrency;

import java.util.function.Predicate;

public class PrintABC {

    private static final int MAX = 30;

    private static int idx = 0;

    private static final String LOCK = "lock";

    public static Thread getPrintThread(Predicate<Integer> condition, String value2Print) {
        return new Thread(() -> {
            while (true) {
                /*
                    这里一定需要对lock对象加锁，然后在synchronized代码块内调用lock的wait()和notify()等方法，
                    否则会抛出IllegalMonitorStateException。抛出IllegalMonitorStateException异常的含义是：
                    没有持有某一对象的monitor时却想要调用这个monitor所属对象的wait()和notify()等方法。
                 */
                synchronized (LOCK) {
                    while (!condition.test(idx)) {
                        // 结束任务
                        if (idx >= MAX)
                            return;
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // 任务结束
                    if (idx >= MAX) {
                        // 唤醒其它线程，全部结束任务，否则其它线程会一直等待
                        LOCK.notifyAll();
                        return;
                    }
                    System.out.print(value2Print + " ");
                    idx++;
                    LOCK.notifyAll();
                }
            }
        });
    }

    public static void main(String[] args) {
        getPrintThread(i -> i % 3 == 0, "A").start();
        getPrintThread(i -> i % 3 == 1, "B").start();
        getPrintThread(i -> i % 3 == 2, "C").start();
    }

}

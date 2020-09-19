package com.my4tb.concurrency.lockandcondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * 传统通过synchronized关键字 + wait + notify/notifyAll来实现多线程通信，整个过程由jvm实现。
 * jdk1.5开始，并发包提供了Lock和Condition(await + signal/signalAll)来实现多线程通信，过程由开发者控制，更加灵活。
 *
 * Lock对应与synchronized关键字，Condition的各方法对应monitor的各方法。
 */
public class ConditionDemo {

    public static void main(String[] args) {
        BoundedBuffer buffer = new BoundedBuffer();
        IntStream.range(0, 10).forEach(i -> new Thread(() -> {
            try {
                buffer.put("1111");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start());
    }

    private static class BoundedBuffer {

        private final Lock lock = new ReentrantLock();
        private final Condition notFull = lock.newCondition();
        private final Condition notEmpty = lock.newCondition();

        private final Object[] items = new Object[100];
        private int takePtr, putPtr, count;

        public void put(Object x) throws InterruptedException {
            lock.lock(); // synchronized
            try {
                while (count == items.length)
                    notFull.await();
                items[putPtr] = x;
                if (++putPtr == items.length)
                    putPtr = 0;
                count++;
                notEmpty.signal(); // 数组非空，可以获取item
            } finally {
                lock.unlock();
            }
        }

        public Object take() throws InterruptedException {
            lock.lock();
            try {
                while (count == 0)
                    notEmpty.await();
                Object x = items[takePtr];
                if (++takePtr == items.length)
                    takePtr = 0;
                count--;
                notFull.signal();
                return x;
            } finally {
                lock.unlock();
            }
        }

    }

}

package com.my4tb.concurrency.lockandcondition;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

    private Lock lock = new ReentrantLock();

    private void m1() {
        try {
            lock.lock();
            System.out.println("m1 invoked ... ");
        } finally {
//            lock.unlock();
        }
    }

    private void m2() {
//        try {
//            lock.lock();
//            System.out.println("m2 invoked ... ");
//        } finally {
//            lock.unlock();
//        }
        boolean flag = false;
        try {
            flag = lock.tryLock(800, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (flag)
            System.out.println("m2 get the lock");
        else
            System.out.println("m2 cannot get the lock");
    }

    public static void main(String[] args) {

        LockDemo lockDemo = new LockDemo();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lockDemo.m1();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lockDemo.m2();
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

}

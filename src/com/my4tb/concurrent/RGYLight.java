package com.my4tb.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 单向红绿灯
 * 1. 控制三色灯
 * 2. 三色灯轮流亮起指定时间
 * 3. 绿灯通知车辆通过
 */
public class RGYLight {

    // 1-red 2-green 3-yellow
    volatile int flag = 1;

    volatile boolean running = false;

    final Lock lock = new ReentrantLock();
    final Condition red = lock.newCondition();
    final Condition green = lock.newCondition();
    final Condition yellow = lock.newCondition();

    public static void main(String[] args) {

        RGYLight light = new RGYLight();

        new Thread(() -> {
            try {
                light.car();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // red light
        new Thread(() -> {
            try {
                for (; ; )
                    light.red();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (; ; )
                    light.green();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (; ; )
                    light.yellow();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

    }

    private void car() throws InterruptedException {
        while (true) {
            if (running) {
                System.out.println("a car passed");
                Thread.sleep(1_000);
            }
        }
    }

    // light red
    private void red() throws InterruptedException {
        lock.lock();

        if (flag != 1) {
            red.await(); // release当前Lock对象的锁
        }
        running = false;
        int time = 3;
        while (time > 0) {
            System.out.println("red light, remaining " + time + " seconds");
            Thread.sleep(500);
            time--;
        }
        flag = 2;
        green.signal(); // must hold exclusive

        lock.unlock();
    }

    private void green() throws InterruptedException {
        lock.lock();

        if (flag != 2) {
            green.await();
        }
        running = true;
        int time = 5;
        while (time > 0) {
            System.out.println("green light, remaining " + time + " seconds");
            Thread.sleep(500);
            time--;
        }
        flag = 3;
        yellow.signal();

        lock.unlock();
    }

    private void yellow() throws InterruptedException {
        lock.lock();

        if (flag != 3) {
            yellow.await();
        }
        running = false;
        int time = 2;
        while (time > 0) {
            System.out.println("yellow light, remaining " + time + " seconds");
            Thread.sleep(500);
            time--;
        }
        flag = 1;
        red.signal();

        lock.unlock();
    }

}

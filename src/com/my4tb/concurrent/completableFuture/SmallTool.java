package com.my4tb.concurrent.completableFuture;

import java.util.StringJoiner;

public class SmallTool {

    public static void sleepSeconds(int seconds, String tag) {
        while (seconds > 0) {
            try {
                System.out.println(tag + " 剩余 " + seconds + " 秒 ");
                Thread.sleep(1_000);
                seconds--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void sleepMillis(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void printTimeAndThread(String tag) {
        String info = new StringJoiner("\t|\t", "[\t", "\t]")
                .add(String.valueOf(System.currentTimeMillis()))
                .add(String.valueOf(Thread.currentThread().getId()))
                .add(String.valueOf(Thread.currentThread().getName()))
                .add(tag)
                .toString();
        System.out.println(info);
    }

    public static void main(String[] args) {
        printTimeAndThread("test");
    }

}

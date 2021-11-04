package com.my4tb.concurrent.completableFuture;

import java.util.concurrent.CompletableFuture;

import static com.my4tb.concurrent.completableFuture.SmallTool.printTimeAndThread;
import static com.my4tb.concurrent.completableFuture.SmallTool.sleepMillis;

/**
 * 连接两个有依赖关系的任务
 * 两个任务由不同线程完成
 * 后者在前者执行完成后才开始
 */
public class _02_thenCompose {

    public static void main(String[] args) {

        printTimeAndThread("进入餐厅");
        printTimeAndThread("点餐：番茄炒蛋 + 一碗米饭");

        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            printTimeAndThread("厨师做番茄炒蛋");
            sleepMillis(3000);
            return "番茄炒蛋";
        }).thenCompose(dish -> CompletableFuture.supplyAsync(() -> {
            printTimeAndThread("服务员打饭");
            sleepMillis(1000);
            return dish + " + 米饭";
        }));

        printTimeAndThread("等待上菜，玩游戏");
        printTimeAndThread(String.format("%s, 开始吃饭", cf.join()));

    }

}

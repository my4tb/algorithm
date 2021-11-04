package com.my4tb.concurrent.completableFuture;

import java.util.concurrent.CompletableFuture;

import static com.my4tb.concurrent.completableFuture.SmallTool.printTimeAndThread;
import static com.my4tb.concurrent.completableFuture.SmallTool.sleepMillis;

/**
 * 开启一个异步任务
 */
public class _01_supplyAsync {

    public static void main(String[] args) {
        printTimeAndThread("进入餐厅");
        printTimeAndThread("点餐：番茄炒蛋 + 一碗米饭");

        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            printTimeAndThread("厨师做番茄炒蛋");
            sleepMillis(3000);
            printTimeAndThread("厨师盛米饭");
            sleepMillis(1000);
            return "番茄炒蛋 + 米饭 做好了";
        });

        printTimeAndThread("等待上菜，玩游戏");
        printTimeAndThread(String.format("%s, 开始吃饭", cf.join()));
    }

}

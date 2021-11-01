package com.my4tb.concurrent.completableFuture;

import java.util.concurrent.CompletableFuture;

import static com.my4tb.concurrent.completableFuture.SmallTool.*;

public class _04_thenApply {

    public static void main(String[] args) {
        printTimeAndThread("进入餐厅");
        printTimeAndThread("点餐：番茄炒蛋 + 一碗米饭");

        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> { // 厨师
            printTimeAndThread("厨师做番茄炒蛋");
            sleepSeconds(3, "番茄炒蛋");
            return "番茄炒蛋";
        }).thenCombine(
                CompletableFuture.supplyAsync(() -> { // 服务员
                    printTimeAndThread("服务员蒸饭");
                    sleepSeconds(4, "蒸饭");
                    return "米饭";
                }).thenApply(rice -> {
                    printTimeAndThread("服务员盛饭");
                    sleepSeconds(1, "盛饭");
                    return "盛好米饭";
                }),
                (dish, rice) -> dish + " + " + rice
        );

        printTimeAndThread("等待上菜，玩游戏");
        printTimeAndThread(String.format("%s, 开始吃饭", cf.join()));
    }

}

package com.my4tb.concurrent.completableFuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.my4tb.concurrent.completableFuture.SmallTool.*;

public class _07_performance {

    private static void wrongExample() {
        printTimeAndThread("来到餐厅，点餐");

        long start = System.currentTimeMillis();

        // 点菜
        List<Dish> dishList = IntStream.range(0, 10)
                .mapToObj(i -> new Dish("菜" + i, 1))
                .collect(Collectors.toList());

        // 做菜
        dishList.forEach(dish -> CompletableFuture.runAsync(dish::make).join());

        printTimeAndThread("做菜花费时间：" + (System.currentTimeMillis() - start));

        printTimeAndThread("菜做好了");
    }

    private static void rightExample() {
        printTimeAndThread("来到餐厅，点餐");
        long start = System.currentTimeMillis();

        CompletableFuture[] cfs = IntStream.range(0, 7)
                .mapToObj(i -> new Dish("菜" + i, 1))
                .map(dish -> CompletableFuture.runAsync(dish::make))
                .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(cfs).join();

        printTimeAndThread("菜做好了，花费时间："  + (System.currentTimeMillis() - start));
    }

    public static void main(String[] args) {
        rightExample();
    }

}

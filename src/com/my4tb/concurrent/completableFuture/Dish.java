package com.my4tb.concurrent.completableFuture;

import java.util.concurrent.TimeUnit;

import static com.my4tb.concurrent.completableFuture.SmallTool.*;

public class Dish {

    private String name; // 菜名
    private Integer productionTime; // 制作时长

    Dish(String name, Integer productionTime) {
        this.name = name;
        this.productionTime = productionTime;
    }
    
    public void make() {
        sleepMillis(TimeUnit.SECONDS.toMillis(productionTime));
        printTimeAndThread(name + "制作完成");
    }

}

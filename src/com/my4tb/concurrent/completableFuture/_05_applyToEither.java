package com.my4tb.concurrent.completableFuture;

import java.util.concurrent.CompletableFuture;

import static com.my4tb.concurrent.completableFuture.SmallTool.*;

public class _05_applyToEither {

    public static void main(String[] args) {

        printTimeAndThread("等公交，700或800都可以");

        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            printTimeAndThread("700路公交");
            sleepMillis(3_000);
            return "700路公交";
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            printTimeAndThread("800路公交");
            sleepMillis(2_000);
            return "800路公交";
        }), bus -> bus);

        printTimeAndThread("坐 " + cf.join() + " 回家");

    }

}

package com.my4tb.concurrent;

import java.util.concurrent.CompletableFuture;

public class CompletableFeatureTest {

    public static void main(String[] args) throws Exception {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        new Thread(() -> {
            System.out.println("completable feature monitor this task");
            completableFuture.complete("task is done");
        }).start();
        System.out.println(completableFuture.get());
    }

}

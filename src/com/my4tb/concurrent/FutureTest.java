package com.my4tb.concurrent;

import java.util.concurrent.*;

public class FutureTest {

    public void testFeature() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> futureRate = executorService.submit(new Callable<String>() {
            @Override
            public String call() {
                return doSthLongComputation(); // 10 seconds waste
            }
        });
        System.out.println(doSthElse());
        try {
            String rst = futureRate.get(10, TimeUnit.SECONDS);
            System.out.println(rst);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    private String doSthLongComputation() {
        try {
            Thread.sleep(9_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "sth long computation done";
    }

    private String doSthElse() {
        return "sth else done";
    }

    public static void main(String[] args) {
        new FutureTest().testFeature();
    }

}

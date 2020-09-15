package com.my4tb.concurrency.pool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Test3 {

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        MyTask myTask = new MyTask(1000, 1, 500000000);
        long start = System.currentTimeMillis();
        Integer result = forkJoinPool.invoke(myTask);
        double used = (System.currentTimeMillis() - start) / 1000d;
        System.out.println("used = " + used);
        System.out.println(result);
        int r = 0;
        start = System.currentTimeMillis();
        for (int i = 1; i <= 500000000; i++) {
            r += i;
        }
        used = (System.currentTimeMillis() - start) / 1000d;
        System.out.println("used = " + used);
    }

    private static class MyTask extends RecursiveTask<Integer> {

        private int limit;

        private int firstIdx;

        private int lastIdx;

        public MyTask(int limit, int firstIdx, int lastIdx) {
            this.limit = limit;
            this.firstIdx = firstIdx;
            this.lastIdx = lastIdx;
        }

        @Override
        protected Integer compute() {
            int result = 0;
            int gap = lastIdx - firstIdx;
            boolean flag = gap <= limit;
            if (flag) {
//                System.out.println(Thread.currentThread().getName());
                for (int i = firstIdx; i <= lastIdx; i++)
                    result += i;
            }
            else {
                int midIdx = firstIdx + ((lastIdx - firstIdx) >> 1);
                MyTask leftTask = new MyTask(limit, firstIdx, midIdx);
                MyTask rightTask = new MyTask(limit, midIdx + 1, lastIdx);
                invokeAll(leftTask, rightTask);
                int leftJoin = leftTask.join();
                int rightJoin = rightTask.join();
                result = leftJoin + rightJoin;
            }
            return result;
        }

    }

}



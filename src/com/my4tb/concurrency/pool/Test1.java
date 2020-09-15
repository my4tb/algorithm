package com.my4tb.concurrency.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * int corePoolSize：线程池中持续维护的线程数量，即使线程池处于任务空闲状态，这一部分线程也不会被回收。这个参数可以根据cpu数量去设置。
 * int maximumPoolSize：线程池中维护的线程的最大数量。
 * long keepAliveTime：线程池中超过corePoolSize数量的线程处于空闲的最大时间，达到这个时间，这部分线程将被回收。
 * TimeUnit unit：keepAliveTime的时间单位。
 * BlockingQueue<Runnable> workQueue：提交到线程池的任务若无法立即被处理，则添加到阻塞队列中。
 * ThreadFactory threadFactory：线程工厂，创建新的线程并被线程池管理。默认线程工厂所创建的线程都是用户线程，且优先级全部相同，为norm=5等级。
 * RejectedExecutionHandler handler：当线程池中maximumPoolSize数量的线程全忙，且workQueue也填满，如果再新来任务，就会根据handler去处理这个新来的任务。拒绝策略常见有四种：
 *  1、AbortPolicy：直接抛出异常
 *  2、DiscardPolicy：直接抛弃新来任务，什么也不做
 *  3、DiscardOldestPolicy：将队列头部任务丢弃，腾出一个空间，然后将当前任务再次execute到线程池
 *  4、CallerRunsPolicy：交由提交任务的线程执行该任务
 *
 * 在应用线程池时，最好将偏向锁标记关闭。
 */
public class Test1 {

    public static void main(String[] args) {

        /*
            线程池创建的线程是非守护线程，当main方法执行完毕，程序不会结束。
            只有手动关闭线程池，程序才会顺利结束并退出。
         */
        /*
            工厂模式创建的几种线程池：
                Executors.newFixedThreadPool()，固定数量线程
                Executors.newSingleThreadExecutor()，单线程
                Executors.newCachedThreadPool()，线程数量无上限
            这几种线程池的拒绝策略默认都是AbortPolicy，即抛出异常。
            FixedThreadPool和SingleThreadExecutor的阻塞队列都采用LinkedBlockingQueue，如果并发量巨大，队列会有大量任务堆积，导致OOM。
         */
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        IntStream.range(0, 10).forEach(i ->
                executorService.submit(() ->
                        IntStream.range(0, 50).forEach(j ->
                                System.out.println(Thread.currentThread().getName()))));
        executorService.shutdown();
    }

}

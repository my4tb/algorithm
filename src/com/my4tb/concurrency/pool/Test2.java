package com.my4tb.concurrency.pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 线程池执行策略：
 * 1、如果线程池中执行任务的线程数<=corePoolSize，对于新来的任务，线程池优先创建新的线程
 * 2、如果线程池中执行任务的线程数>=corePoolSize，对于新来的任务，线程池优先将任务放入阻塞队列
 * 3、如果线程池阻塞队列已满，并且线程池内线程数<maximumPoolSize，对于新来的任务，线程池会创建新的线程
 * 4、如果随着创建线程，线程池内线程数达到maximumPoolSize，那么拒绝策略就会生效
 *
 * 对于一个线程池，它需要维护两个状态，下面这两个状态是通过ThreadPoolExecutor中private final AtomicInteger ctl变量完成表示的：
 * 1、线程池本身的状态，ctl高3位控制
 * 2、线程池中运行中的线程数量，ctl低29位控制，因此线程池中线程数量最大为2^29 - 1，而非2^31 - 1
 *
 * 线程池的5种状态：
 * 1、RUNNING：线程池可以接收新的任务，并且还可以正常处理阻塞队列中的任务。
 * 2、SHUTDOWN：不再接收新任务的提交，不过线程池可以继续处理阻塞队列中的任务。
 * 3、STOP：不再接收新任务的提交，同时丢弃阻塞队列中的任务，并且会中断正在处理中的任务。
 * 4、TIDYING：线程池内所有任务执行完毕后（线程正在执行和阻塞队列中的任务），当前线程池中活动的线程数量降为0，将会调用terminated方法。
 * 5、TERMINATED：线程池的中止状态，当terminated方法执行完毕后，线程池就会处于该状态之下。
 * 上面5中状态间的转换，在ThreadPoolExecutor文档中有说明。
 *
 */
public class Test2 {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3), new ThreadPoolExecutor.CallerRunsPolicy());

        IntStream.range(0, 9).forEach(i -> {
            executor.submit(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                IntStream.range(0, 1).forEach(j -> System.out.println(Thread.currentThread().getName()));
            });
        });

    }

}

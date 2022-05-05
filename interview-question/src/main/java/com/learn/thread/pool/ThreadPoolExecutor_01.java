package com.learn.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wencheng
 * @create 2022/5/5 14:17
 */
public class ThreadPoolExecutor_01 {
    public static void main(String[] args) {


//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,10, 30,TimeUnit.SECONDS,
//                new LinkedBlockingDeque<>(10)); //默认 拒绝策略是AbortPolicy 直接抛出异常，默认策略
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,10, 30,TimeUnit.SECONDS,
//                new LinkedBlockingDeque<>(10),new ThreadPoolExecutor.DiscardPolicy()); //直接丢弃任务
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,10, 30,TimeUnit.SECONDS,
//                new LinkedBlockingDeque<>(10),new ThreadPoolExecutor.DiscardOldestPolicy()); //丢弃阻塞队列中靠最前的任务，并执行当前任务；


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,10, 30,TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(10),new ThreadPoolExecutor.CallerRunsPolicy()); //用调用者所在的线程来执行任务； 用主线程执行
        for (int i = 0; i < 100000; i++) {
            ThreadPool thread = new ThreadPool(i, "张" + i);
            threadPoolExecutor.execute(thread);
        }
        threadPoolExecutor.shutdown();
    }
}
class ThreadPool implements Runnable{

    private int id;

    private String name;

    public ThreadPool(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println(name + " " + Thread.currentThread().getName() + " print " + id);
    }
}

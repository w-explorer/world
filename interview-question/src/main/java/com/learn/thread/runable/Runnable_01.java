package com.learn.thread.runable;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wencheng
 * @create 2022/5/5 9:40
 */
public class Runnable_01 {
    /**
     * 阿里建议不推荐使用 Executors创建线程
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CountDownLatch countDownLatch = new CountDownLatch(3);

        for (int i = 0; i < 3; i++) {
            ThreadRunnable threadRunnable = new ThreadRunnable(countDownLatch,""+i);
            executorService.submit(threadRunnable);
        }

        countDownLatch.await();
        executorService.shutdown();
    }
}

class ThreadRunnable implements Runnable {

    private CountDownLatch countDownLatch;

    private String data;


    public ThreadRunnable(CountDownLatch countDownLatch, String data) {
        this.countDownLatch = countDownLatch;
        this.data = data;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+String.format("数据：%s",data));
        countDownLatch.countDown();
    }
}

package com.learn.atguigu.面试题第一季.day02单例模式.test;

import com.learn.atguigu.面试题第一季.day02单例模式.single.Singleton06;

import java.util.concurrent.*;

/**
 * @author wencheng
 * @create 2022/2/26 21:59
 */
public class TestSingleton06_test02 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Singleton06> callable = () -> Singleton06.getInstance();

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<Singleton06> c1 = executorService.submit(callable);
        Future<Singleton06> c2 = executorService.submit(callable);
        Future<Singleton06> c3 = executorService.submit(callable);
        Future<Singleton06> c4 = executorService.submit(callable);
        goalTest(c1.get(),c2.get());

        System.out.println(c3.get());
        System.out.println(c4.get());
    }

    public  static void goalTest(Singleton06 instance01, Singleton06 instance02){
        System.out.println(instance01 == instance02);
        System.out.println(instance01);
        System.out.println(instance02);
    }
}

package com.explore.model.biz.cha01singleton.test;


import com.explore.model.biz.cha01singleton.single.Singleton04;

import java.util.concurrent.*;

/**
 * @author wencheng
 * @create 2022/2/26 21:29
 */
public class TestSingleton04 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Singleton04 instance01 = Singleton04.getInstance();
//
//        Singleton04 instance02 = Singleton04.getInstance();


        Callable<Singleton04> callable = () -> Singleton04.getInstance();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Singleton04> es01 = executorService.submit(callable);
        Future<Singleton04> es02 = executorService.submit(callable);

        Singleton04 instanse = es01.get();
        Singleton04 instanse2 = es02.get();
        goalTest(instanse,instanse2);

        executorService.shutdown();
    }

    public  static void goalTest(Singleton04 instance01,Singleton04 instance02){
        System.out.println(instance01 == instance02);
        System.out.println(instance01);
        System.out.println(instance02);
    }
}

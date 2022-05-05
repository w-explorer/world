package com.learn.thread.callable;


import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author wencheng
 * @create 2022/3/9 9:27
 */
public class MainTest {
    /**
     *1.接收的任务类型 execute和submit都属于线程池的方法，execute只能提交Runnable类型的任务，而submit既能提交Runnable类型任务也能提交Callable类型任务。
     *
     *2.异常 execute会直接抛出任务执行时的异常，submit会吃掉异常，可通过Future的get方法将任务执行时的异常重新抛出。get方法调用时会阻塞至任务执行完成。
     *
     *3.返回值 execute没有返回结果
     * submit有返回结果
     *
     */

    public static void main(String[] args) {
        try {
            List<String> datas = Lists.newArrayList();
            datas.add("data1");
            datas.add("data2");
            datas.add("data3");
            long start = System.currentTimeMillis();

            ExecutorService executorService = Executors.newCachedThreadPool();
            List<FutureTask<String>> futureTasks = new ArrayList<>();

            //模拟处理3条数据
            for(int i=0; i<3; i++){
                CallAbleTest myCallable = new CallAbleTest(datas.get(i));
                FutureTask<String> futureTask = new FutureTask<>(myCallable);
                futureTasks.add(futureTask);
                //无需返回
//                executorService.execute(futureTask);
                //需要返回
                executorService.submit(futureTask);
            }
            executorService.shutdown();
            //返回结果
            for(int i=0; i<futureTasks.size(); i++){
                System.out.println("线程返回:"+futureTasks.get(i).get());
            }
            System.out.println("处理数据消耗："+(System.currentTimeMillis()-start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

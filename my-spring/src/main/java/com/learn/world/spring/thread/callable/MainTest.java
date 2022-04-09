package com.learn.world.spring.thread.callable;

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
    //            executorService.execute(futureTask);
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

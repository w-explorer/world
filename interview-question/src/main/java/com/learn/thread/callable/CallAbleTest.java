package com.learn.thread.callable;

import java.util.concurrent.Callable;

/**
 * @author wencheng
 * @create 2022/3/9 9:24
 */
public class CallAbleTest implements Callable<String> {
    private String data;

    public CallAbleTest(String data){
        this.data = data;
    }


    @Override
    public String call() {
        System.out.println("当前线程名称:"+Thread.currentThread().getName());
        System.out.println("当前数据名称:"+data);
        try {
            System.out.println("开始处理:"+data);
            Thread.sleep(1000);
            System.out.println("处理结束:"+data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return data;
    }
}

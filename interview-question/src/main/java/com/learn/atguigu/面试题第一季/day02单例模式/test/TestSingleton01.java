package com.learn.atguigu.面试题第一季.day02单例模式.test;

import com.learn.atguigu.面试题第一季.day02单例模式.single.Singleton01;

/**
 * @author wencheng
 * @create 2022/2/26 20:45
 */
public class TestSingleton01 {
    public static void main(String[] args) {
        Singleton01 instance = Singleton01.INSTANCE;
        Singleton01 instance2 = Singleton01.INSTANCE;

        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());

    }
}

package com.learn.atguigu.面试题第一季.day02单例模式.test;

import com.learn.atguigu.面试题第一季.day02单例模式.single.Singleton02;

/**
 * @author wencheng
 * @create 2022/2/26 20:47
 */
public class TestSingleton02 {
    public static void main(String[] args) {
        Singleton02 instance = Singleton02.INSTANCE;
        Singleton02 instance2 = Singleton02.INSTANCE;

        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
    }
}

package com.learn.atguigu.面试题第一季.day02单例模式.test;

import com.learn.atguigu.面试题第一季.day02单例模式.single.Singleton03;

/**
 * @author wencheng
 * @create 2022/2/26 21:02
 */
public class TestSingleton03 {
    public static void main(String[] args) {
        Singleton03 instance = Singleton03.INSTANCE;
        System.out.println(instance.getInfo());
    }
}

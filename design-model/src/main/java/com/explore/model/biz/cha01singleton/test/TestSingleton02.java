package com.explore.model.biz.cha01singleton.test;


import com.explore.model.biz.cha01singleton.single.Singleton02;

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

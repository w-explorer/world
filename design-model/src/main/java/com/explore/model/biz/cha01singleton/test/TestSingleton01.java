package com.explore.model.biz.cha01singleton.test;


import com.explore.model.biz.cha01singleton.single.Singleton01;

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

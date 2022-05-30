package com.explore.model.biz.cha01singleton.test;


import com.explore.model.biz.cha01singleton.single.Singleton03;

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

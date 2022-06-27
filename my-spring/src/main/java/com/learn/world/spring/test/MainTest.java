package com.learn.world.spring.test;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

/**
 * @author wencheng
 * @create 2022/1/21 15:26
 */
public class MainTest {
    public static void main(String[] args) {
        String dataString = "222";
        System.out.println(ObjectSizeCalculator.getObjectSize(dataString));

    }

}




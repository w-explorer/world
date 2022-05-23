package com.export.word;

/**
 * @author wencheng
 * @create 2022/5/23 19:50
 */
public class Debug_01 {
    //异常断点是开发、调试的时候经常用到的一个功能，用于快速定位到那行代码出现了异常
    public static void main(String[] args) {
        Object o = null;

        o.toString();
        System.out.println(1/0);
        System.out.println(1/0);
    }
}

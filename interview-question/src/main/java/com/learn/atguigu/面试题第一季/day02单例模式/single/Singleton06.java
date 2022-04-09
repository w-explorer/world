package com.learn.atguigu.面试题第一季.day02单例模式.single;

/**
 * 饿汉式-静态内部类-线程安全--最简单
 *
 * 在内部类被加载和初始化时，才创建instance
 * 静态内部内不会自动随着外部类的加载和初始化而初始化，它是要单独去加载和初始化的。
 * 因为是在内部内加载和初始化时创建的，所以是安全的，
 *
 *
 * @author wencheng
 * @create 2022/2/26 21:47
 */
public class Singleton06 {

    private Singleton06(){

    }
    private static class Inner{
       private static final Singleton06 instance = new Singleton06();
    }

    public static Singleton06 getInstance(){
        return Inner.instance;
    }
}

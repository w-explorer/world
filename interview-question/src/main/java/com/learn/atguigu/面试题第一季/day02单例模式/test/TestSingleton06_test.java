package com.learn.atguigu.面试题第一季.day02单例模式.test;

/**
 * @author wencheng
 * @create 2022/2/26 21:59
 */
public class TestSingleton06_test {
    public static void main(String[] args) {
        TestSingleton06 instance = TestSingleton06.getInstance();
        instance.putSet("1");
        System.out.println(instance+"--set="+instance.getSet());
        TestSingleton06 instance2 = TestSingleton06.getInstance();
        instance2.putSet("2");
        System.out.println(instance+"--set="+instance.getSet());
    }
}

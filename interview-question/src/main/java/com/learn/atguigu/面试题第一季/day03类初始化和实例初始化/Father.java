package com.learn.atguigu.面试题第一季.day03类初始化和实例初始化;

/**
 * @author wencheng
 * @create 2022/2/28 19:56
 */
public class Father {
    //静态代码块
    static {
        System.out.println("(1)");
    }
    //静态变量
    private static int  j = method();

    //非静态变量
    private int i = test();


    //非静态代码块
    {
        System.out.println("(3)");
    }

    //构造函数
    Father(){
        System.out.println("(2)");
    }
    public int test(){
        System.out.println("(4)");
        return 1;
    }

    public static int method(){
        System.out.println("(5)");
        return 1;
    }
}

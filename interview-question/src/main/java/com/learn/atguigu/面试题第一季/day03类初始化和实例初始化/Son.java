package com.learn.atguigu.面试题第一季.day03类初始化和实例初始化;

/**
 * 类的初始化--先执行父类再执行子类
 *  先执行静态变量和静态代码块   这两个的执行顺序自上到下（交换代码顺序即运行顺序变化）
 *  类的初始化就是执行<clinit>（）方法可以查看字节码查看
 *      <clinit>()方法由静态变量现实赋值代码和静态代码块组成
 *      类变量现实赋值代码和静态代码块代码从上到下顺序执行
 *      <clinit>()方法只执行一次
 *
 * 类的实例化--先执行父类再执行子类--就是执行<init>()方法
 *      <init>() 方法可能重载有几个，有几个构造器就有几个<init>方法
 *      <init>() 方法由非静态实例变量现实赋值代码和非静态代码块、对应构造器代码组成
 *      非静态实例变量现实赋值代码和非静态代码块从上到下顺序执行，而对应构造器的代码最后执行
 *      每次创建实例对象，调用对应的构造器方法，执行的就是对应的<init>方法
 *      <init>方法的首航是super()或super(实参列表)，即对应的<init>方法
 *
 *
 * 非静态方法前面其实有一个默认的对象this
 * this在构造器（或<init>）他表示的是正在创建的对象，因为这里是在创建Son对象，所以test()执行的是子类重写的代码（面向对象多态）
 * test()执行的是子类重写的test（）方法。
 *
 *
 * 方法的重写
 *  那些方法不可以被重写？
 *      final方法
 *      静态方法
 *      private等子类中不可见方法
 *  对象的多态性
 *      子类如果重写了父类的方法，通过子类对象调用的一定是子类重写过的代码
 *      非静态方法默认的调用对象是this
 *      this对象在构造器或说init方法中就是正在创建的对象
 *
 *
 *
 * @author wencheng
 * @create 2022/2/28 20:00
 */
public class Son extends Father{
    //非静态变量赋值
    private int i = test();
    //静态变量
    private static int j = method();
    //静态代码块
    static {
        System.out.println("(6)");
    }
    //非静态代码块
    {
        System.out.println("(8)");
    }
    //构造函数

    Son(){
        System.out.println("(7)");
    }


    public int test() {
        System.out.println("(9)");
        return 1;
    }

    //静态方法
    public static int method() {
        System.out.println("(10)");
        return 1;
    }

    public static void main(String[] args) {
        Son son = new Son();
    }
}

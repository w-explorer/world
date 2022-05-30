package com.explore.model.biz.cha01singleton.single;

/**
 * 饿汉式--不存在线程安全问题
 * 枚举形式最简单
 *
 * 直接类初始化的时候创建实例，不管你是否需要这个对象都会创建-内存浪费
 * 例如你只想调用这个类里面的test方法，就不需要这个对象
 *
 *  1.私有化构造函数,外部不可创建对象
 *  2.自行创建，并用静态变量保存
 *  3.向外提供这个实例，可以用public 修饰变量，对象.实例获取。可以提供get方法
 *  4.强调这是个单例，用final来修饰
 *
 * @author wencheng
 * @create 2022/2/26 20:40
 */
public class Singleton01 {

    public static final Singleton01 INSTANCE = new Singleton01();

    private Singleton01(){

    }

    public static void test(){
        System.out.println("test...方法");
    }
}

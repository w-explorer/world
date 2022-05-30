package com.explore.model.biz.cha01singleton.single;

/**
 * 懒汉式：延迟创建实例对象-避免了不必要的获取实例对象-运行效率不高
 * 线程不安全--适合单线程
 * 静态内部类最简单
 *
 *
 * 1.创建私有的构造函数
 * 2.静态变量保存这个唯一实例对象  privite避免外部通过对象点变量获取
 * 3.提供静态方法，来获取实例对象
 *
 * @author wencheng
 * @create 2022/2/26 21:23
 */
public class Singleton04 {

    private Singleton04(){

    }
    private static Singleton04 instance;//不能用final 修饰 ,用final修饰必须初始化变量值。

    public static Singleton04 getInstance(){
        if(instance == null){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Singleton04();
        }
        return instance;
    }
}

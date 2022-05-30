package com.explore.model.biz.cha01singleton.single;

/**
 * 懒汉式：延迟创建实例对象-避免了不必要的获取实例对象
 * 线程安全版本
 *
 *
 * 1.创建私有的构造函数
 * 2.静态变量保存这个唯一实例对象  privite避免外部通过对象点变量获取
 * 3.提供静态方法，来获取实例对象
 *
 * @author wencheng
 * @create 2022/2/26 21:23
 */
public class Singleton05 {

    private Singleton05(){

    }
    private static Singleton05 instance;//不能用final 修饰 ,用final修饰必须初始化变量值。

    public static Singleton05 getInstance(){
        if(instance == null){ //减少加锁的次数，优化性能效率
            //加锁-  但是如果前面已经有线程初始化了实例了就不需要再次加锁了。
            synchronized (Singleton05.class){
                if(instance == null){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Singleton05();
                }
            }
        }
        return instance;
    }
}

package com.learn.world.spring.thread.callable.threadlocal;

/**
 * @author wencheng
 * @create 2022/7/15 10:26
 */
public class InheritableThreadLocal01 {
    public static void main(String[] args) {
        ThreadLocal inheritableThreadLocal = new InheritableThreadLocal();
        inheritableThreadLocal.set("老王");
        new Thread(() -> System.out.println(inheritableThreadLocal.get())).start();
    }
}

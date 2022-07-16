package com.learn.world.spring.thread.callable.threadlocal;

/**
 * @author wencheng
 * @create 2022/7/15 9:57
 */
public class Test1 {
    public static void main(String[] args) {
        ThreadLocal threadLocal = new InheritableThreadLocal();
        threadLocal.set("老王");
        threadLocal.get();
        ThreadLocal threadLocal2 = new ThreadLocal();
        threadLocal2.set("老王");
        threadLocal2.get();

        System.out.println(threadLocal.get().equals(threadLocal2.get()));
        new Thread(() -> {
            System.out.println(threadLocal.get().equals(threadLocal2.get()));
        }).start();
    }
}

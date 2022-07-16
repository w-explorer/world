package com.learn.world.spring.thread.callable.threadlocal;

import java.util.Arrays;
import java.util.List;

/**
 * @author wencheng
 * @create 2022/7/15 10:25
 */
public class ThreadLocal01 {
    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        // 存值
        threadLocal.set(Arrays.asList("老王", "Java 面试题"));
        threadLocal.set(Arrays.asList("老王1", "Java 面试题1"));
        // 取值
        List list = (List) threadLocal.get();
        System.out.println(list.size());
        System.out.println(threadLocal.get());
        //删除值
        threadLocal.remove();
        System.out.println(threadLocal.get());
    }
}

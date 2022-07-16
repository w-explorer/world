package com.learn.world.spring.thread.callable.threadlocal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ThreadLocalOOMTest {
    static ThreadLocal threadLocal = new ThreadLocal();
    static Integer MOCK_MAX = 10000;
    static Integer THREAD_MAX = 100;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_MAX);
        for (int i = 0; i < THREAD_MAX; i++) {
            executorService.execute(() -> {
                threadLocal.set(new ThreadLocalOOMTest().getList());
                System.out.println(Thread.currentThread().getName());
                System.out.println("-----------------------------------------------");
                System.out.println(threadLocal.get().toString().length());
//                threadLocal.remove();
            });
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }

    List getList() {
        List list = new ArrayList();
        for (int i = 0; i < MOCK_MAX; i++) {
            list.add("Version：JDK 8");
            list.add("ThreadLocal");
            list.add("Author：老王");
            list.add("DateTime：" + LocalDateTime.now());
            list.add("Test：ThreadLocal OOM");
        }
        return list;
    }
}
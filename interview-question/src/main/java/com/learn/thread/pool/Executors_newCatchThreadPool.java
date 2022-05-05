package com.learn.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wencheng
 * @create 2022/5/5 14:22
 * https://blog.csdn.net/xby7437/article/details/102534592?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522165173191416782184678299%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=165173191416782184678299&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_ecpm_v1~rank_v31_ecpm-2-102534592.142^v9^pc_search_result_cache,157^v4^control&utm_term=%E4%BD%BF%E7%94%A8Executors%E5%88%9B%E5%BB%BA%E7%BA%BF%E7%A8%8B%E6%B1%A0&spm=1018.2226.3001.4187
 */
public class Executors_newCatchThreadPool {
    public static void main(String[] args) {

        /**
         * 1.核心线程数和最大线程数一样大
         * 2.当线程数据量超过核心最大线程数，等待时间为0，多出来的空闲线程直接被销毁
         * 3.用于存放但是未被执行的任务队列LinkedBlockingQueue。长度是Integer.MAX_VALUE当任务数大于线程数时，任务回一直向队列中增加，可能回造成内存溢出
         * 4.fixedThreadPool线程池，当线程数量不够时候，不会增加线程，而是全部加到队列里面去，容易造成OOM
         */
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 100000; i++) {
            FixedThread thread = new FixedThread(i, "张" + i);
            executorService.execute(thread);
        }
        executorService.shutdown();
    }
}

class CatchThread implements Runnable{

    private int id;

    private String name;

    public CatchThread(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println(name + " " + Thread.currentThread().getName() + " print " + id);
    }
}

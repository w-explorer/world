package com.export.word;

/**
 * @author wencheng
 * @create 2022/5/23 19:50
 */
public class Debug_03 {
    //如果把断点打在System.out.println上,除了0是能保证第一个输出的，1、2、3的执行顺序是没办法保证的；
    //如果将所有断点的suspend设置为Thread之后，就会按着线程的顺序，逐个去执行
    public static void main(String[] args) {
        System.out.println("0 main start");
        new Thread(() -> {
            System.out.println("1 hello");
        }, "thread1").start();

        new Thread(() -> {
            System.out.println("2 world");
        }, "thread2").start();

        System.out.println("3 main end");
    }
}

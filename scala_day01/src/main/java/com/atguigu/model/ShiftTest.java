package com.atguigu.model;

/**
 * @author wencheng
 * @create 2022/2/10 9:13
 */
public class ShiftTest {
    public static void main(String[] args) {
        byte b = 10;
        test(b);
    }

    public static void test(char b){
        System.out.println("char");
    }
    public static void test(int b){
        System.out.println("int");
    }
    public static void test(byte b){
        System.out.println("byte");
    }
    public static void test(short b){
        System.out.println("short");
    }
}

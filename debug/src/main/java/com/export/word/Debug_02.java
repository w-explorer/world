package com.export.word;

/**
 * @author wencheng
 * @create 2022/5/23 19:50
 */
public class Debug_02 {
    public static void main(String[] args) {
        try {
            //throw new RuntimeException("IDEA优雅模拟异常 ");
            testThorException();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testThorException(){
        System.out.println("手动");
    }
}

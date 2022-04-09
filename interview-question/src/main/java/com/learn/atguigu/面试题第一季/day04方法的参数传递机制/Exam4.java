package com.learn.atguigu.面试题第一季.day04方法的参数传递机制;

import jdk.internal.cmm.SystemResourcePressureImpl;

import java.util.Arrays;

/**
 *
 * 形参是基本数据类型
 *  传递数据值
 *
 * 实参是引用数据类型
 *  传递地址值
 *  特俗的类型：String、包装类等对象不可变性
 *
 * @author wencheng
 * @create 2022/2/28 20:44
 */
public class Exam4 {

    public static void main(String[] args) {
        int []arr = {1,2,3};
        String str = "hello";
        MyData myData = new MyData();
        Integer i = 1;
        change(arr,str,myData,i);

        System.out.println("arr:"+ Arrays.toString(arr));
        System.out.println("str:"+str);
        System.out.println("myData.a:"+myData.a);
        System.out.println("i:"+i);
    }

    private static void change(int[] arr, String str, MyData myData, Integer i) {
        arr[0] +=1;
        str += "word";
        myData.a +=1;
        i+=1;
    }

}

class MyData{
    public int a = 10;
}


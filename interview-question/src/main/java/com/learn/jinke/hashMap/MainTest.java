package com.learn.jinke.hashMap;

import java.util.HashMap;

/**
 * @author wencheng
 * @create 2022/3/15 10:40
 *
 * ==  和equals 的区别
 * ==的作用：
 *  基本类型：比较的是值是否相同
 *  引用类型：比较的就是地址值是否相同| ==  比较的是内存中的地址（堆内存地址）（即是否是同一个  new出来的对象）
 * equals的作用：
 *  引用类型：默认情况下，是比较地址值，不过可以重写该方法，比较对象的成员变量的值是相同
 *
 *
 *面试题：请解释字符串比较之中“==”和equals()的区别？
 *
 *  ==：比较的是两个字符串内存地址（堆内存）的数值是否相等，属于数值比较；
 *  equals()：比较的是两个字符串的内容，属于内容比较。
 *
 *  ----------------------------------------------------------------------------------------------------
 *
 * 1.重写equals 方法是为了比较两个不同对象的值是否相等|具有相同成员变量值的对象相等
 * 2.重写hashCode 是为了让同一个Class对象的两个具有相同值的对象的Hash值相等。
 * 3.同时重写equals和hashCode是为了满住HashSet、HashMap 等此类集合的使用hashCode值存储相同对象不重复存储。
 * 4.重写toString 方法是为了方便输出。父类是类名@Integer.toHexString(hashCode());
 *
 *
 *
 */
public class MainTest {

    public static void main(String[] args) {
        Student s1 = new Student("张三", 2);
        Student s2 = new Student("张三", 2);

        System.out.println(s1.equals(s2));

        HashMap<Student, String> hashMap = new HashMap<>();
        hashMap.put(s1,"你好hashCode");
        hashMap.put(s2,"你好hashCode");

        hashMap.forEach((k,v)->{
            System.out.println(k.toString()+v);
        });
    }
}

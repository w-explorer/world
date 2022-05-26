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
 *  ==：比较的是两个字符串内存地址（堆内存）的数值是否相等，是否是同一个 new出来的对象；
 *  equals()：比较的是两个字符串的内容，属于内容比较。
 *
 *  ----------------------------------------------------------------------------------------------------
 *
 * 1.重写equals 方法是为了比较两个不同对象的值是否相等|具有相同成员变量值的对象相等
 * 2.重写hashCode 是为了让同一个Class对象的两个具有相同值的对象的Hash值相等。
 * 3.同时重写equals和hashCode是为了满足HashSet、HashMap 等此类集合的使用hashCode值存储相同对象不重复存储。
 * 4.重写toString 方法是为了方便输出。父类是类名@Integer.toHexString(hashCode());
 *
 * hasMap 存储和取数据的原理：
 * put : hash&(length-1)作为数组的下标值，
 *
 *
 * HashMap的长度为什么要是2的n次方  为了用位运算取代取余，提高效率。
 * HashMap为了存取高效，要尽量较少碰撞，就是要尽量把数据分配均匀，每个链表长度大致相同，这个实现就在把数据存到哪个链表中的算法；
 * 这个算法实际就是取模，hash%length，计算机中直接求余效率不如位移运算，源码中做了优化hash&(length-1)，
 * hash%length==hash&(length-1)的前提是length是2的n次方；
 * 为什么这样能均匀分布减少碰撞呢？2的n次方实际就是1后面n个0，2的n次方-1  实际就是n个1；
 * 例如长度为9时候，3&(9-1)=0  2&(9-1)=0 ，都在0上，碰撞了；
 * 例如长度为8时候，3&(8-1)=3  2&(8-1)=2 ，不同位置上，不碰撞；
 *
 *
 * get: hash碰撞 意思就是角标是否一样。可以通过hashCode的异或运算来降低碰撞的概率。异或运算可以猜才能打到1和0的比例是1:1平衡状态。
 * 异或运算让结果的随机性更大。
 *
 * hashCode 一样，通过key的quals方法来对比找链路中的位置。
 * public final boolean equals(Object o) {
 *             if (o == this)
 *                 return true;
 *             if (o instanceof Map.Entry) {
 *                 Map.Entry<?,?> e = (Map.Entry<?,?>)o;
 *                 if (Objects.equals(key, e.getKey()) &&
 *                     Objects.equals(value, e.getValue()))
 *                     return true;
 *             }
 *             return false;
 *         }
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

package com.explore.model.biz.cha01singleton.test;

import java.util.HashSet;

/**
 * 饿汉式-静态内部类-线程安全--最简单
 *
 * 在内部类被加载和初始化时，才创建instance
 * 静态内部内不会自动随着外部类的加载和初始化而初始化，它是要单独去加载和初始化的。
 * 因为是在内部内加载和初始化时创建的，所以是安全的，
 *
 *
 * @author wencheng
 * @create 2022/2/26 21:47
 */
public class TestSingleton06 {

    private static HashSet<String> set = new HashSet<>();
    private TestSingleton06(){

    }
    private static class Inner{
       private static final TestSingleton06 instance = new TestSingleton06();
    }

    public static TestSingleton06 getInstance(){
        return Inner.instance;
    }

    public void putSet(String set){
        TestSingleton06 instance = getInstance();
        HashSet<String> hashSet = instance.getSet();
        hashSet.add(set);
    }

    public HashSet<String> getSet() {
        return set;
    }

    public void setSet(HashSet<String> set) {
        this.set = set;
    }
}

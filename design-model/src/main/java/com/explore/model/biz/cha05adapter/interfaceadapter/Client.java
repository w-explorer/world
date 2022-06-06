package com.explore.model.biz.cha05adapter.interfaceadapter;

/**
 * @author wencheng
 * @create 2022/6/4 16:44
 */
public class Client {
    public static void main(String[] args) {
        //匿名内部类可以实例化抽象类
        InterfaceAdapter interfaceAdapter = new InterfaceAdapter() {
            @Override
            public void m1() {
                System.out.println("使用m1方法");
            }
        };
        interfaceAdapter.m1();

        //匿名内部类可以实例化抽象类
        AbstractClass abstractClass = new AbstractClass(){

        };
        abstractClass.test();
    }
}

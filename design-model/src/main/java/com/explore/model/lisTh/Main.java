package com.explore.model.lisTh;

/**
 * @author wencheng
 * @create 2022/5/24 19:44
 */
public class Main {
    public static void main(String[] args) {

        B b = new B();
        System.out.println("1-2="+b.func1(1, 2));
    }
}

class A{
    public int func1(int a,int b){
        return a-b;
    }
}

class B extends A{
    //无意识得重写了父类的方法 破坏了父类方法的意思
    public int func1(int a,int b){
        return a+b;
    }
}

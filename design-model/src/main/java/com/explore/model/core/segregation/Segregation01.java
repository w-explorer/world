package com.explore.model.core.segregation;

/**
 * @author wencheng
 * @create 2022/4/11 15:51
 *
 *
 * 类D 通过Interface1 依赖（使用）B  (只使用方法1，2，3 但是B还需实现没必要的方法4，5)
 * 类E 通过Interface1 依赖（使用）C  (只使用方法1，4，5 但是C还需实现没必要的方法2，3)
 *
 *
 */
public class Segregation01 {

    public static void main(String[] args) {
        new D().depend1(new B());
        new D().depend2(new B());
        new D().depend3(new B());

        new E().depend1(new C());
        new E().depend4(new C());
        new E().depend5(new C());


    }
}

interface Interface1{
    void operation1();
    void operation2();
    void operation3();
    void operation4();
    void operation5();
}


class D {

    public void depend1(Interface1 inter){
        inter.operation1();
    }
    public void depend2(Interface1 inter){
        inter.operation2();
    }
    public void depend3(Interface1 inter){
        inter.operation3();
    }
}
class E {

    public void depend1(Interface1 inter){
        inter.operation1();
    }
    public void depend4(Interface1 inter){
        inter.operation4();
    }
    public void depend5(Interface1 inter){
        inter.operation5();
    }
}

class B implements Interface1{

    @Override
    public void operation1() {
        System.out.println("B 实现了方法1");
    }

    @Override
    public void operation2() {
        System.out.println("B 实现了方法2");
    }

    @Override
    public void operation3() {
        System.out.println("B 实现了方法3");
    }

    @Override
    public void operation4() {
        System.out.println("B 实现了方法4");
    }

    @Override
    public void operation5() {
        System.out.println("B 实现了方法5");
    }
}

class C implements Interface1{

    @Override
    public void operation1() {
        System.out.println("C 实现了方法1");
    }

    @Override
    public void operation2() {
        System.out.println("C 实现了方法2");
    }

    @Override
    public void operation3() {
        System.out.println("C 实现了方法3");
    }

    @Override
    public void operation4() {
        System.out.println("C 实现了方法4");
    }

    @Override
    public void operation5() {
        System.out.println("C 实现了方法5");
    }
}

package com.explore.model.segregation;

/**
 * @author wencheng
 * @create 2022/4/11 16:30
 *
 * 拆分接口为三个接口  ，被依赖方做到  最小隔离级别，互不干扰
 */
public class Segregation02 {

    public static void main(String[] args) {
        new Dd().depend1(new Bb());
        new Dd().depend2(new Bb());
        new Dd().depend3(new Bb());


        new Ee().depend1(new Cc());
        new Ee().depend4(new Cc());
        new Ee().depend5(new Cc());
    }
}

interface Interface11{

    void operation1();
}
interface Interface22{
    void operation2();
    void operation3();
}
interface Interface33{
    void operation4();
    void operation5();
}

class Dd{
    public void depend1(Interface11 inter){
        inter.operation1();
    }
    public void depend2(Interface22 inter){
        inter.operation2();
    }
    public void depend3(Interface22 inter){
        inter.operation3();
    }
}
class Ee{
    public void depend1(Interface11 inter){
        inter.operation1();
    }
    public void depend4(Interface33 inter){
        inter.operation4();
    }
    public void depend5(Interface33 inter){
        inter.operation5();
    }
}

class Bb implements Interface11,Interface22{
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
}
class Cc implements Interface11,Interface33{
    @Override
    public void operation1() {
        System.out.println("C 实现了方法1");
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



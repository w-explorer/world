package com.explore.model.biz.cha03prototype.improve;

/**
 * @author wencheng
 * @create 2022/5/31 20:25
 */
public class MainTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep sheep = new Sheep("TOM", 1, "白色");
        Sheep sheep1 = (Sheep) sheep.clone();
        Sheep sheep2 = (Sheep) sheep.clone();

        System.out.println(sheep+"hashCode"+sheep.hashCode());
        System.out.println(sheep1+"hashCode"+sheep1.hashCode());
        System.out.println(sheep2+"hashCode"+sheep2.hashCode());

        System.out.println(sheep == sheep1);
    }
}

package com.explore.model.core.singleresponsibility;

/**
 * @author wencheng
 * @create 2022/4/9 21:27
 *
 *
 * 单一职责原则
 *
 * 对类来说，即一个类只负责一项职责。如类A负责两个不同的职责：职责1、职责2.当职责需求变更而改变类A时，可能造成职责2的执行错误。所以需要将A分为A1  A2 两个
 * 细粒度的类。
 *
 *
 *
 */
public class SingleResponsibility01 {

    public static void main(String[] args) {
        Vehicle vehicle  = new Vehicle();

        vehicle.run("摩托车");
        vehicle.run("汽车");
        vehicle.run("飞机");
    }


}

/**
 * 1.在run方法中违反了单一职责原则
 * 2.根据交通工具方式的不同分解成不同的类
 *
 */
class Vehicle{
    public void run(String vehicle){

        System.out.println(String.format("%s在公路上跑",vehicle));
    }
}

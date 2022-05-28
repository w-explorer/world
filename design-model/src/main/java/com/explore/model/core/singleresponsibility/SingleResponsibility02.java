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
public class SingleResponsibility02 {

    public static void main(String[] args) {
        LandVehicle landVehicle = new LandVehicle();

        landVehicle.run("摩托车");
        landVehicle.run("汽车");


        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("飞机");
    }


}

/**
 * 1.遵循单一职责原则
 * 2.但是这样做的改动很大，即将类的分解，同时修改客户端
 * 3.改进：直接修改Vehicle类，改动的代码会比较少=》方案3
 */

class LandVehicle{
    public void run(String vehicle){
        System.out.println(String.format("%s在公路上跑",vehicle));
    }
}
class AirVehicle{
    public void run(String vehicle){
        System.out.println(String.format("%s在天空中飞",vehicle));
    }
}

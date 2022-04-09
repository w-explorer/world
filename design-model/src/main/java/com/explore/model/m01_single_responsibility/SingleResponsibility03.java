package com.explore.model.m01_single_responsibility;

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
public class SingleResponsibility03 {

    public static void main(String[] args) {
        CommonVehicle vehicle = new CommonVehicle();
        vehicle.LandRun("汽车");
        vehicle.WaterRun("游艇");
        vehicle.AirRun("飞机");
    }


}

/**
 *1.没有对原来的类做大的修改，只是增加了方法
 *2.虽然没有在这个类上遵守单一职责原则，但是在方法级别上任然是遵守单一职责
 */
class CommonVehicle{
    public void LandRun(String vehicle){
        System.out.println(String.format("%s在公路上跑",vehicle));
    }
    public void WaterRun(String vehicle){
        System.out.println(String.format("%s在水里游",vehicle));
    }
    public void AirRun(String vehicle){
        System.out.println(String.format("%s在空中飞",vehicle));
    }
}

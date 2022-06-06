package com.explore.model.biz.cha05adapter.classadapter;

/**
 * @author wencheng
 * @create 2022/6/4 16:04
 */
public class Phone {

    public void charge(Valtage5V valtage5V){
        int valtage = valtage5V.output5v();
        if(valtage == 5){
            System.out.println("电压为5V，可以进行充电");
        } else {
            System.out.println(String.format("电压为%dV，不能进行充电",valtage));
        }
    }
}

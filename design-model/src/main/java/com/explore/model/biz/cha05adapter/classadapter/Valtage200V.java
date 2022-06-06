package com.explore.model.biz.cha05adapter.classadapter;

/**
 * @author wencheng
 * @create 2022/6/4 15:59
 */
public class Valtage200V {

    private int valtage = 220;

    public int outputValtage(){
        System.out.println(String.format("家用电压%d伏",valtage));
        return valtage;
    }
}

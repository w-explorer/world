package com.explore.model.biz.cha05adapter.classadapter;

/**
 * @author wencheng
 * @create 2022/6/4 16:02
 */
public class ValtageAdapter extends Valtage200V implements Valtage5V{
    @Override
    public int output5v() {
        int valtage = outputValtage();
        int valtage5v = valtage / 44;
        System.out.println("适配器转换电压");
        return valtage5v;
    }
}

package com.explore.model.biz.cha05adapter.objectadapter;

/**
 * @author wencheng
 * @create 2022/6/4 16:02
 */
public class ValtageAdapter extends Valtage200V implements Valtage5V {
    private Valtage200V valtage200V;

    public ValtageAdapter(Valtage200V valtage200V) {
        this.valtage200V = valtage200V;
    }

    @Override
    public int output5v() {
        int valtage = 0;
        if(valtage200V != null){
            System.out.println("对象适配者模式,使用适配器转换电压");
            int outputValtage = valtage200V.outputValtage();
            valtage = outputValtage/44;
        }
        return valtage;
    }
}

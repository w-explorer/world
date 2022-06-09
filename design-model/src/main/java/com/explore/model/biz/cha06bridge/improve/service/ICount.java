package com.explore.model.biz.cha06bridge.improve.service;

/**
 * @author wencheng
 * @create 2022/6/9 20:13
 */
public abstract class ICount {

    //组合平台
    private ISystem system;

    public ICount(ISystem system){
        this.system = system;
    }

    protected void transferAccounts(){
        this.system.transferAccounts();
    }
}

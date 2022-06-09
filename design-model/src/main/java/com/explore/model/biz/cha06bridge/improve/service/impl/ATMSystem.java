package com.explore.model.biz.cha06bridge.improve.service.impl;

import com.explore.model.biz.cha06bridge.improve.service.ISystem;

/**
 * @author wencheng
 * @create 2022/6/9 20:11
 */
public class ATMSystem implements ISystem {
    @Override
    public void transferAccounts() {
        System.out.println("记录ATM转账账单-在ATM交易系统做记录");
    }
}

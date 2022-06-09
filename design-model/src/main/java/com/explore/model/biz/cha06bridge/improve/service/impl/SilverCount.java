package com.explore.model.biz.cha06bridge.improve.service.impl;

import com.explore.model.biz.cha06bridge.improve.service.ICount;
import com.explore.model.biz.cha06bridge.improve.service.ISystem;

/**
 * @author wencheng
 * @create 2022/6/9 20:15
 */
public class SilverCount extends ICount {

    public SilverCount(ISystem system) {
        super(system);
    }

    @Override
    public void transferAccounts() {
        super.transferAccounts();
        System.out.println("银卡用户: 走中等流程-审批稍快-从地级市仓库拿");
    }

}

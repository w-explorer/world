package com.explore.model.biz.cha06bridge.improve.service.impl;

import com.explore.model.biz.cha06bridge.improve.service.ICount;
import com.explore.model.biz.cha06bridge.improve.service.ISystem;

/**
 * @author wencheng
 * @create 2022/6/9 20:15
 */
public class GoldCount extends ICount {

    public GoldCount(ISystem system) {
        super(system);
    }

    @Override
    public void transferAccounts() {
        super.transferAccounts();
        System.out.println("金卡用户: 走高等流程-审批块-从当地仓库拿（现场拿）");
    }

}

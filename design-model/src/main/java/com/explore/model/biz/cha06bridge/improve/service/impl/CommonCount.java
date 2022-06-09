package com.explore.model.biz.cha06bridge.improve.service.impl;

import com.explore.model.biz.cha06bridge.improve.service.ICount;
import com.explore.model.biz.cha06bridge.improve.service.ISystem;

/**
 * @author wencheng
 * @create 2022/6/9 20:15
 */
public class CommonCount extends ICount {

    public CommonCount(ISystem system) {
        super(system);
    }

    @Override
    public void transferAccounts() {
        super.transferAccounts();
        System.out.println("普通用户: 走普通正常流程-审批慢-需要从中央仓库拿");
    }

}

package com.explore.model.biz.cha06bridge.improve;

import com.explore.model.biz.cha06bridge.improve.service.impl.ATMSystem;
import com.explore.model.biz.cha06bridge.improve.service.impl.CommonCount;
import com.explore.model.biz.cha06bridge.improve.service.impl.GTSystem;
import com.explore.model.biz.cha06bridge.improve.service.impl.OnlineSystem;

/**
 * @author wencheng
 * @create 2022/6/9 20:01
 */
public class Client {
    //1.todo 需求说明
    //设计银行转账系统
    /**
     *网上转账：记录网上转账账单-在网上交易系统做记录
     *柜台转账：记录线下转账账单-在柜台交易系统做记录
     *ATM转账：记录ATM转账账单-在ATM交易系统做记录
     */

    /**
     * 普通用户: 走普通正常流程-审批慢-需要从中央仓库拿
     * 银卡用户: 走中等流程-审批稍快-从地级市仓库拿
     * 金卡用户: 走高等流程-审批块-从当地仓库拿（现场拿）
     */
//    银行转账系统
//    转账分类：网上转账，柜台转账，AMT转账--（纵向、即抽象类）
//    转账用户类型：普通用户，银卡用户，金卡用户.--（横向类型、即实现类）

    public static void main(String[] args) {
        CommonCount commonCountATM = new CommonCount(new ATMSystem());
        commonCountATM.transferAccounts();

        System.out.println("=============================");

        CommonCount commonCountOnline = new CommonCount(new OnlineSystem());
        commonCountOnline.transferAccounts();

        System.out.println("=============================");
        CommonCount commonCountGT = new CommonCount(new GTSystem());
        commonCountGT.transferAccounts();
    }

}

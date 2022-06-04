package com.explore.model.biz.cha02factory.absfactory.service.impl;

import com.explore.model.biz.cha02factory.absfactory.service.IPizza;

/**
 * @author wencheng
 * @create 2022/5/31 19:57
 */
public class TJpizza implements IPizza {
    @Override
    public String getType() {
        return "TJ";
    }

    @Override
    public void orderPizza() {
        System.out.println("天津披萨");
    }
}

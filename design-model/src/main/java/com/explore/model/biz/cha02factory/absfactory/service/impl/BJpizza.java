package com.explore.model.biz.cha02factory.absfactory.service.impl;

import com.explore.model.biz.cha02factory.absfactory.service.IPizza;

/**
 * @author wencheng
 * @create 2022/5/31 19:57
 */
public class BJpizza implements IPizza {
    @Override
    public String getType() {
        return "BJ";
    }

    @Override
    public void orderPizza() {
        System.out.println("北京披萨");
    }
}

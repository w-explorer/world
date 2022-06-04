package com.explore.model.biz.cha02factory.absfactory;

import com.explore.model.biz.cha02factory.absfactory.service.IPizza;
import com.explore.model.biz.cha02factory.absfactory.service.impl.BJpizza;
import com.explore.model.biz.cha02factory.absfactory.service.impl.TJpizza;

/**
 * @author wencheng
 * @create 2022/5/31 19:55
 */
public class PizzaFactory {

    public static void main(String[] args) {
        IPizza bj = getPizzaFactory("BJ");
        bj.orderPizza();
    }

    public static IPizza getPizzaFactory(String type){
        switch (type){
            case "TJ":
                return new TJpizza();
            case "BJ":
                return new BJpizza();
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
    }
}

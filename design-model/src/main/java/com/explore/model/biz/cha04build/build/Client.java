package com.explore.model.biz.cha04build.build;

/**
 * @author wencheng
 * @create 2022/6/4 14:41
 */
public class Client {
    public static void main(String[] args) {
        CommonHouse commonHouse = new CommonHouse();
        HouseDirector houseDirector = new HouseDirector(commonHouse);
        houseDirector.constructHouse();
    }
}

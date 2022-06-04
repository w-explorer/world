package com.explore.model.biz.cha04build.build;

import lombok.Data;
import sun.util.resources.hu.CalendarData_hu;

/**
 * @author wencheng
 * @create 2022/6/4 14:37
 */
@Data
public class HouseDirector {
    HouseBuilder houseBuilder = null;

    //通过构造器传入houseBuilder
    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }
    //通过set方法传入houseBuilder

    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House constructHouse(){
        houseBuilder.buildBasic();
        houseBuilder.buildWalls();
        houseBuilder.buildRoof();
        return houseBuilder.buildHouse();
    }
}

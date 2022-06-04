package com.explore.model.biz.cha04build.build;

/**
 * @author wencheng
 * @create 2022/6/4 14:34
 *
 */
public abstract class HouseBuilder {
    House house = new House();

    //地基
    public abstract void buildBasic();
    //墙
    public abstract void buildWalls();
    //屋顶
    public abstract void buildRoof();

    public House buildHouse(){
        return house;
    }
}

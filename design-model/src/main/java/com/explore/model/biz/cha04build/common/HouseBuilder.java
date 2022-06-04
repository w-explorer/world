package com.explore.model.biz.cha04build.common;

/**
 * @author wencheng
 * @create 2022/6/4 14:19
 */
public abstract class HouseBuilder {
    //地基
    public abstract void buildBasic();
    //墙
    public abstract void buildWalls();
    //屋顶
    public abstract void buildRoof();

    public void build(){
        buildBasic();
        buildWalls();
        buildRoof();
    }
}

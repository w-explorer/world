package com.explore.model.biz.cha04build.build;


/**
 * @author wencheng
 * @create 2022/6/4 14:21
 */
public class CommonHouse extends HouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println("普通房子：打地基");
    }

    @Override
    public void buildWalls() {
        System.out.println("普通房子：修建墙体");
    }

    @Override
    public void buildRoof() {
        System.out.println("普通房子：盖屋顶");
    }
}

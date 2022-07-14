package com.explore.model.biz.cha20watch;

import lombok.Data;

/**
 * @author wencheng
 * @create 2022/7/14 11:38
 */
@Data
public class User1 implements IUser{

    private String name;

    public User1(String name) {
        this.name = name;
    }

    @Override
    public void updateParkingNum(int parkingNum) {
        System.out.println(String.format("%s接收到通知，停车场空余车位还剩%d个",name,parkingNum));
    }
}

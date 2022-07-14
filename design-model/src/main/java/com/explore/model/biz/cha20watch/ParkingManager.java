package com.explore.model.biz.cha20watch;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wencheng
 * @create 2022/7/14 13:48
 */
@Data
public class ParkingManager implements Manager{
    private List<IUser> users = new ArrayList<>();
    private int parkingNum;

    public void setParkingNum(int parkingNum) {
        this.parkingNum = parkingNum;
        noticeAll();
    }

    public void registered(IUser user){
        if(!users.contains(user)){
            users.add(user);
        }
    }

    @Override
    public boolean remove(IUser user) {
        users.remove(user);
        return true;
    }

    @Override
    public void noticeAll() {
        users.forEach(u->{
            u.updateParkingNum(parkingNum);
        });
    }
}

package com.explore.model.biz.cha20watch;

/**
 * @author wencheng
 * @create 2022/7/14 13:59
 */
public class Client {
    public static void main(String[] args) {
        IUser user1 = new User1("张山");
        IUser user2 = new User1("李四");
        ParkingManager parkingManager = new ParkingManager();
        parkingManager.registered(user1);
        parkingManager.registered(user2);
//        for (int i = 10; i > 0; i--) {
//            parkingManager.setParkingNum(i);
//        }

        parkingManager.setParkingNum(4);

        parkingManager.remove(user1);

        parkingManager.setParkingNum(5);

    }
}

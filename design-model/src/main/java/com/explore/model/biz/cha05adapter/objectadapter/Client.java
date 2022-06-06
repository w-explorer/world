package com.explore.model.biz.cha05adapter.objectadapter;

/**
 * @author wencheng
 * @create 2022/6/4 16:07
 */
public class Client {
    public static void main(String[] args) {

        Phone phone = new Phone();
        phone.charge(new ValtageAdapter(new Valtage200V()));

    }
}

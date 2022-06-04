package com.explore.model.biz.cha03prototype.deptClone;

import com.explore.model.biz.cha03prototype.deptClone.model.Park;
import com.explore.model.biz.cha03prototype.deptClone.model.Tree;
import com.google.gson.Gson;

/**
 * @author wencheng
 * @create 2022/6/4 13:26
 */
public class GsonMainApp {
    public static void main(String[] args) {
        Park park = new Park();
        park.setName("东湖公园");
        park.setAddr("锦江区");
        park.setTree(new Tree("柏树"));

        Gson gson = new Gson();
        Park park1 = gson.fromJson(gson.toJson(park), Park.class);

        park1.setName("东岸胡公园");

        System.out.println(park.toString()+"hashCode="+park.hashCode());
        System.out.println(park1.toString()+"hashCode="+park1.hashCode());
    }
}

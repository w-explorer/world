package com.explore.model.biz.cha03prototype.improve;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wencheng
 * @create 2022/5/31 20:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sheep implements Cloneable{


    private String name;

    private int age;

    private String color;

    public Sheep(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    private List<String> list = new ArrayList<>();



    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

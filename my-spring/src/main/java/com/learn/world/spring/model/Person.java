package com.learn.world.spring.model;

import lombok.Data;

/**
 * @author wencheng
 * @create 2022/3/12 16:25
 */
@Data
public class Person {


    private String name;

    private int age;

    private String addr;

    public String sex;

    public Person(){
    }

    public Person(String name){
        this.name = name;
    }


}

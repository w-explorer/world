package com.learn.world.spring.tag.model;

import lombok.Getter;

/**
 * @author wencheng
 * @create 2022/4/22 14:48
 */
@Getter
public enum JoinType {

    LEFT_JOIN("LEFT OUTER JOIN","左连接"),
    RIGHT_JOIN("RIGHT OUTER JOIN","右连接"),
    INNER_JOIN("INNER OUTER JOIN","内连接"),
    FULL_JOIN("FULL OUTER JOIN","全连接"),;

    JoinType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    private String code;
    private String name;
}

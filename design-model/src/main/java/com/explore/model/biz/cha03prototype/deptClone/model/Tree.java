package com.explore.model.biz.cha03prototype.deptClone.model;

import lombok.*;

import java.io.Serializable;

/**
 * @author wencheng
 * @create 2022/6/4 12:39
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Tree implements Cloneable, Serializable {
    private String name;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

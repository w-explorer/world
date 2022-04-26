package com.learn.world.spring.tag.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoinInfo {

    /**
     * 源表字段
     */
    private TagField sourceField;

    /**
     * 目标表字段
     */
    private TagField destField;

}

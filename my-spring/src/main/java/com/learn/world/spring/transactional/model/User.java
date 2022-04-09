package com.learn.world.spring.transactional.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author wencheng
 * @create 2021/9/30 9:43
 */
@Data
@TableName(value = "t_word_user")
public class User extends BaseEntity{

    @ApiModelProperty(value = "ip地址")
    @TableField(value = "name")
    private String name;

    @ApiModelProperty(value = "适用范围,多个用英文逗号隔开")
    @TableField(value = "age")
    private int age;

    @ApiModelProperty(value = "说明")
    @TableField(value = "sex")
    private String sex;
}

package com.learn.world.spring.transactional.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author wencheng
 */
@Data
public class BaseEntity {
    @ApiModelProperty(value = "flowId",name = "主键")
    @TableId(value = "flow_id",type = IdType.ID_WORKER)
    private Long flowId;

    @ApiModelProperty(value = "创建人id",example = "-1")
    @TableField(value = "create_user_id",fill = FieldFill.INSERT)
    private String createUserId;

    @ApiModelProperty(value = "创建时间",example = "1603814400000")
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value ="更新人id",example = "-1")
    @TableField(value = "update_user_id",fill = FieldFill.INSERT_UPDATE)
    private String updateUserId;

    @ApiModelProperty(value = "更新时间",example = "1603814400000")
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 逻辑字段
     */
    @ApiModelProperty(value = "创建人名字")
    @TableField(exist = false)
    private String createUserName;

    @ApiModelProperty(value ="更新人名字",example = "100000")
    @TableField(exist = false)
    private String updateUserName;
}

package com.learn.world.redis.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author wencheng
 * @create 2021/6/16 14:45
 */
@Data
@ApiModel(value = "跳转数据对象")
public class MeiYaRequestData {
    @ApiModelProperty("请求数据--手机(SJ)、QQ(QQ)、微信(WX)、证件号码（ZJHM）、案件编号（AJBH）、银行卡号(YHKH)、支付账号(ZFZH)")
    private Map<String, List<String>> meiYaApiData;
}

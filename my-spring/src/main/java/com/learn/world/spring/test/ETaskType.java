package com.learn.world.spring.test;

import lombok.Getter;

@Getter
public enum ETaskType {
    /**
     * 代码集删除任务
     */
    CODE_SET_DEL("CODE_SET_DEL", "代码集删除任务"),
    CODE_SET_BATCH_IMPORT("CODE_SET_BATCH_IMPORT", "代码集批量生成任务"),
    LOCAL_UNIT_GEN_CODESET_REL("LOCAL_UNIT_GEN_CODESET_REL", "本地数据元智能生成与代码集关系任务"),
    LOCAL_UNIT_IMPORT("LOCAL_UNIT_IMPORT", "导入本地数据元任务"),
    AREA_UNIT_IMPORT("AREA_UNIT_IMPORT", "导入地标数据元任务"),
    INDUSTRY_UNIT_IMPORT("INDUSTRY_UNIT_IMPORT", "导入行标数据元任务"),
    NATIONAL_UNIT_IMPORT("NATIONAL_UNIT_IMPORT", "导入国标数据元任务"),
    LOCAL_UNIT_MASTER_IMPORT("LOCAL_UNIT_MASTER_IMPORT", "智能生成本地数据元任务");

    private String type;
    private String name;

    ETaskType(String type, String name) {
        this.type = type;
        this.name = name;
    }

    /**
     * 超时设置1分钟
     */
    public static final long REDIS_TIMEOUT_1_MINUTE=60000;
    /**
     * 超时设置3分钟
     */
    public static final long REDIS_TIMEOUT_3_MINUTE=180000;
    /**
     * 超时设置5分钟
     */
    public static final long REDIS_TIMEOUT_5_MINUTE=300000;
    /**
     * 超时设置10分钟
     */
    public static final long REDIS_TIMEOUT_10_MINUTE=600000;
    /**
     * 超时设置30分钟
     */
    public static final long REDIS_TIMEOUT_30_MINUTE=3000000;
}

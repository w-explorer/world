package com.learn.world.spring.tag.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wencheng
 * @create 2022/4/22 11:36
 */
@Data
public class Node {

    /**
     * 节点id
     */
    private String id;

    /**
     * 父节点id
     */
    private String parentId;

    /**
     * 表英文
     */
    private String tableCode;

    /**
     * 关联类型
     */
    private JoinType type;

    /**
     * 关联条件
     */
    @NotEmpty
    private List<JoinInfo> joinInfo = new ArrayList<>();


    private long y;

    private long x;


    private List<Node> children;

    //逻辑字段

    /**
     * 表临时别名
     */
    private String tableAliasName;

    /**
     * 与子节点形成的临时sql
     */
    private String nodeSql;

    /**
     * 表字段
     */
    private List<String> fields = new ArrayList<>();

    /**
     * 重命名表字段映射
     */
    private Map<String,String> aliasFieldMap = new HashMap<>();

}

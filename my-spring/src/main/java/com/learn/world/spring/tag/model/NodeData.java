package com.learn.world.spring.tag.model;

import lombok.Data;

import java.util.List;

/**
 * @author wencheng
 * @create 2022/4/22 11:36
 */
@Data
public class NodeData {

    private Node node;

    private List<NodeData> children;

}

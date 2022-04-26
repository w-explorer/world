package com.learn.world.spring.tag;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.google.common.collect.Lists;
import com.learn.world.spring.tag.model.JoinInfo;
import com.learn.world.spring.tag.model.JoinType;
import com.learn.world.spring.tag.model.Node;
import com.learn.world.spring.tag.model.TagField;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author wencheng
 * @create 2022/4/22 14:44
 */
public class TestMainApp_01 {

    public static void main(String[] args) {
        //todo 构造数据
        //数据库字段结构


        Map<String, List<String>> tableMetaDataMap = new HashMap<>();
        tableMetaDataMap.put("class",Arrays.asList("id","class_name","school_id","honour_id"));
        tableMetaDataMap.put("student",Arrays.asList("id","name","class_id","project_id"));
        tableMetaDataMap.put("school",Arrays.asList("id","school_name"));
        tableMetaDataMap.put("honour",Arrays.asList("id","h_name"));


        List<Node> treeData = new ArrayList<>();

        Node headNode = new Node();
        headNode.setId("1");
        headNode.setTableCode("student");


        Node node1 = new Node();
        node1.setId("2");
        node1.setTableCode("class");
        node1.setParentId("1");
        node1.setType(JoinType.LEFT_JOIN);
        JoinInfo joinInfo = new JoinInfo(new TagField("student","class_id"),new TagField("class","id"));
        node1.setJoinInfo(Arrays.asList(joinInfo));

//        Node node4 = new Node();
//        node4.setId("5");
//        node4.setTableCode("project");
//        node4.setParentId("1");
//        node4.setType(JoinType.LEFT_JOIN);
//        JoinInfo joinInfo4 = new JoinInfo(new TagField("student","project_id"),new TagField("project","id"));
//        node4.setJoinInfo(Arrays.asList(joinInfo4));

        Node node2 = new Node();
        node2.setId("3");
        node2.setTableCode("school");
        node2.setParentId("2");
        node2.setType(JoinType.FULL_JOIN);
        JoinInfo joinInfo2 = new JoinInfo(new TagField("class","school_id"),new TagField("school","id"));
        node2.setJoinInfo(Arrays.asList(joinInfo2));


        Node node3 = new Node();
        node3.setId("4");
        node3.setTableCode("honour");
        node3.setParentId("2");
        node3.setType(JoinType.LEFT_JOIN);
        JoinInfo joinInfo3 = new JoinInfo(new TagField("class","honour_id"),new TagField("honour","id"));
        node3.setJoinInfo(Arrays.asList(joinInfo3));

        treeData.add(headNode);
        treeData.add(node1);
        treeData.add(node2);
        treeData.add(node3);
//        treeData.add(node4);

        //todo 唯一化 表中重复的所有字段
        HashMap<String, String> hashMap = new HashMap<>();
        HashMap<String, Integer> fieldTagMap = new HashMap<>();
        HashMap<String, Integer> tableTagMap = new HashMap<>();
        treeData.forEach(r->{
            Integer tableCodeIndex = tableTagMap.get(r.getTableCode());

            if(tableCodeIndex == null){
                tableTagMap.put(r.getTableCode(),0);
            } else {
                tableTagMap.put(r.getTableCode(),tableCodeIndex+1);
                r.setTableAliasName(String.format(r.getTableCode()+"_%d",tableCodeIndex+1));
            }


            List<String> fields = tableMetaDataMap.get(r.getTableCode());
            r.setFields(fields);

            Map<String, String> aliasFieldMap = new HashMap<>();
            fields.forEach(f->{
                Integer integer = fieldTagMap.get(f);
                if(fieldTagMap.get(f) == null){
                    fieldTagMap.put(f,0);
                } else {
                    fieldTagMap.put(f,integer+1);
                    aliasFieldMap.put(f,String.format(f+"_%d",integer+1));
                }
            });
            r.setAliasFieldMap(aliasFieldMap);
        });





        List<Node> nodes = list2Tree(treeData);

        System.out.println(nodes);

        List<Node> dataNode = new ArrayList<>();
        cylTree(nodes,dataNode);

        AtomicInteger count = new AtomicInteger();
        int size = dataNode.size();
        for (int i = size-1; i >= 0; i--) {
            Node node = dataNode.get(i);
            List<Node> children = node.getChildren();
            if(children!=null&&!children.isEmpty()){
                StringBuffer buffer = new StringBuffer();
                buffer.append("select * from "+node.getTableCode());
                children.forEach(r->{
                    if(Tools.isNotNull(r.getNodeSql())){
                        // left join (select ...) on ()
                        buffer.append(" "+r.getType().getCode()+"( "+r.getNodeSql()+")"+" as temp"+count+" on (");
                        r.getJoinInfo().forEach(q->{
                            buffer.append(" "+q.getSourceField().getTableCode()+"."+q.getSourceField().getFieldCode()+" = " + q.getDestField().getTableCode()+"."+q.getDestField().getFieldCode());
                        });
                        buffer.append(")");
                        count.getAndIncrement();
                    } else {
                        buffer.append(" "+r.getType().getCode()+" "+r.getTableCode()+" on (");
                        r.getJoinInfo().forEach(q->{
                            buffer.append(" "+q.getSourceField().getTableCode()+"."+q.getSourceField().getFieldCode()+" = " + q.getDestField().getTableCode()+"."+q.getDestField().getFieldCode());
                        });
                        buffer.append(")");
                    }

                });
                node.setNodeSql(buffer.toString());
                System.out.println(buffer.toString());
            }
        }

    }

    public static void cylTree(List<Node> nodes,List<Node> dataNode){
        nodes.forEach(r->{
            System.out.println(r.getTableCode()+"^^^^^^^^^^^^^^^^^");
            dataNode.add(r);
            List<Node> children = r.getChildren();
            if(children!=null && !children.isEmpty()){
                cylTree(children,dataNode);
            }
        });
    }


    public static List<Node> list2Tree(List<Node> datas) {
        List<Node> root = Lists.newArrayList();
        datas.forEach(d -> {
            if (d.getParentId()==null) {
                root.add(fillChildren(d, datas));
            }
        });

        return root;
    }

    private static Node fillChildren(Node parent, List<Node> datas) {
        datas.forEach(d -> {
            if (Objects.equals(parent.getId(), d.getParentId())) {
                if (CollectionUtils.isEmpty(parent.getChildren())) {
                    parent.setChildren(Lists.newArrayList());
                }
                parent.getChildren().add(fillChildren(d, datas));
            }
        });
        return parent;
    }
}

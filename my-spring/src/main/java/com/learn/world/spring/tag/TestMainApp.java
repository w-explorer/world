//package com.learn.world.spring.tag;
//
//import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
//import com.google.common.collect.Lists;
//import com.learn.world.spring.tag.model.JoinInfo;
//import com.learn.world.spring.tag.model.JoinType;
//import com.learn.world.spring.tag.model.Node;
//import com.learn.world.spring.tag.model.TagField;
//
//import java.util.*;
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.stream.Collectors;
//
///**
// * @author wencheng
// * @create 2022/4/22 14:44
// */
//public class TestMainApp {
//
//    public static void main(String[] args) {
//        //todo 构造数据
//        //数据库字段结构
//
//
////        Map<String, List<String>> dataMap = new HashMap<>();
////        dataMap.put("class",new List<String>("1","2"));
//
//
//        List<Node> treeData = new ArrayList<>();
//
//        Node headNode = new Node();
//        headNode.setId("1");
//        headNode.setTableName("student");
//
//
//        Node node1 = new Node();
//        node1.setId("2");
//        node1.setTableName("class");
//        node1.setParentId("1");
//        node1.setType(JoinType.LEFT_JOIN);
//        JoinInfo joinInfo = new JoinInfo(new TagField("student","class_id"),new TagField("class","id"));
//        node1.setJoinInfo(Arrays.asList(joinInfo));
//
//        Node node2 = new Node();
//        node2.setId("3");
//        node2.setTableName("school");
//        node2.setParentId("2");
//        node2.setType(JoinType.FULL_JOIN);
//        JoinInfo joinInfo2 = new JoinInfo(new TagField("class","school_id"),new TagField("school","id"));
//        node2.setJoinInfo(Arrays.asList(joinInfo2));
//
//
//        Node node3 = new Node();
//        node3.setId("4");
//        node3.setTableName("honour");
//        node3.setParentId("2");
//        node3.setType(JoinType.LEFT_JOIN);
//        JoinInfo joinInfo3 = new JoinInfo(new TagField("class","honour_id"),new TagField("honour","id"));
//        node3.setJoinInfo(Arrays.asList(joinInfo3));
//
//        treeData.add(headNode);
//        treeData.add(node1);
//        treeData.add(node2);
//        treeData.add(node3);
//
//
//        List<Node> nodes = list2Tree(treeData);
//
//        System.out.println(nodes);
//
//        List<Node> dataNode = new ArrayList<>();
//        cylTree(nodes,dataNode);
//
//        AtomicInteger count = new AtomicInteger();
//        int size = dataNode.size();
//        for (int i = size-1; i >= 0; i--) {
//            Node node = dataNode.get(i);
//            List<Node> children = node.getChildren();
//            if(children!=null&&!children.isEmpty()){
//                List<Node> fullType = children.stream().filter(r -> JoinType.FULL_JOIN == r.getType()).collect(Collectors.toList());
//
//                boolean withFull = !fullType.isEmpty();
//
//                StringBuffer buffer = new StringBuffer();
//                if(withFull){
//                    buffer.append("select * from ");
//                } else {
//                    buffer.append("select * from "+node.getTableName());
//                }
//                children.forEach(r->{
//                    if(Tools.isNotNull(r.getNodeSql())){
//                        if(JoinType.FULL_JOIN == r.getType()){
//
//                        } else {
//                            // left join (select ...) on ()
//                            buffer.append(" "+r.getType().getCode()+"( "+r.getNodeSql()+")"+" as temp"+count+" on (");
//                            r.getJoinInfo().forEach(q->{
//                                buffer.append(" "+q.getSourceField().getTableCode()+"."+q.getSourceField().getFieldCode()+" = " + q.getDestField().getTableCode()+"."+q.getDestField().getFieldCode());
//                            });
//                            buffer.append(")");
//                        }
//                        count.getAndIncrement();
//                    } else {
//                        if(JoinType.FULL_JOIN == r.getType()){
//                            buffer.append("( ");
//
//                            StringBuffer tempBuffer = new StringBuffer();
//                            tempBuffer.append("select * from "+node.getTableName());
//                            tempBuffer.append(" "+JoinType.LEFT_JOIN.getCode()+" "+r.getTableName()+" on (");
//                            r.getJoinInfo().forEach(q->{
//                                tempBuffer.append(" "+q.getSourceField().getTableCode()+"."+q.getSourceField().getFieldCode()+" = " + q.getDestField().getTableCode()+"."+q.getDestField().getFieldCode());
//                            });
//                            tempBuffer.append(")");
//
//                            tempBuffer.append(" union ");
//
//                            tempBuffer.append("select * from "+node.getTableName());
//                            tempBuffer.append(" "+JoinType.RIGHT_JOIN.getCode()+" "+r.getTableName()+" on (");
//                            r.getJoinInfo().forEach(q->{
//                                tempBuffer.append(" "+q.getSourceField().getTableCode()+"."+q.getSourceField().getFieldCode()+" = " + q.getDestField().getTableCode()+"."+q.getDestField().getFieldCode());
//                            });
//                            tempBuffer.append(")");
//
//                            buffer.append(tempBuffer);
//                            buffer.append(" )");
//                        } else {
//                            buffer.append(" "+r.getType().getCode()+" "+r.getTableName()+" on (");
//                            r.getJoinInfo().forEach(q->{
//                                buffer.append(" "+q.getSourceField().getTableCode()+"."+q.getSourceField().getFieldCode()+" = " + q.getDestField().getTableCode()+"."+q.getDestField().getFieldCode());
//                            });
//                            buffer.append(")");
//                        }
//                    }
//
//                });
//                node.setNodeSql(buffer.toString());
//                System.out.println(buffer.toString());
//            }
//        }
//
//    }
//
//    public static void cylTree(List<Node> nodes,List<Node> dataNode){
//        nodes.forEach(r->{
//            System.out.println(r.getTableName()+"^^^^^^^^^^^^^^^^^");
//            dataNode.add(r);
//            List<Node> children = r.getChildren();
//            if(children!=null && !children.isEmpty()){
//                cylTree(children,dataNode);
//            }
//        });
//    }
//
//
//    public static List<Node> list2Tree(List<Node> datas) {
//        List<Node> root = Lists.newArrayList();
//        datas.forEach(d -> {
//            if (d.getParentId()==null) {
//                root.add(fillChildren(d, datas));
//            }
//        });
//
//        return root;
//    }
//
//    private static Node fillChildren(Node parent, List<Node> datas) {
//        datas.forEach(d -> {
//            if (Objects.equals(parent.getId(), d.getParentId())) {
//                if (CollectionUtils.isEmpty(parent.getChildren())) {
//                    parent.setChildren(Lists.newArrayList());
//                }
//                parent.getChildren().add(fillChildren(d, datas));
//            }
//        });
//        return parent;
//    }
//}

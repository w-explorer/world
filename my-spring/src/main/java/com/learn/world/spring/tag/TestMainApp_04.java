package com.learn.world.spring.tag;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.google.common.collect.Lists;
import com.learn.world.spring.tag.model.JoinInfo;
import com.learn.world.spring.tag.model.JoinType;
import com.learn.world.spring.tag.model.Node;
import com.learn.world.spring.tag.model.TagField;
import com.learn.world.spring.tag.utils.DataTypeUtil;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wencheng
 * @create 2022/4/22 14:44
 */
public class TestMainApp_04 {

    /**
     *
     * 1.将图中所有节点的表的元数据获取出来---data-metaData
     * 2.进行全局节点表和字段取别名
     *        --重复表  取别名 xx_1     避免重复表链接关系
     *        --重复字段  取别名 xx_1   避免出现关联条件字段指向不明确，重复问题
     *        --将数据填充到节点总存储
     *
     *
     * 3.节点-转森林结构
     *
     * 4.森林深度遍历--得到从所有路线的叶子节点回溯全路径
     *
     *
     * 5.解析select 字段，不能用* 必须展平所有字段
     *         --子节点是否有子查询
     *         -- 有  select table.id ,table.name,tempTable_1.* from (子查询语句) as tempTable_1 on ()
     *
     *         -- 无  select table1.id,table1.name,table2.id as id_1,table3.name as name_1
     * 6.解析关联查询语句拼接--叶子节点不存储解析关系
     *          left join on ()
     *
     *          --子节点是否有子查询
     *          -- 有 把子查询 as 成临时表，关系需要和临时表建立关系
     *                例如关系： select * from A left join (select B.id as 'id_1',C.id as 'id_2' from B left join C on (B.id = C.id))
     *                解析关系： select A.id,tempTable.* from A left join (select from B left join C) as tempTable_1 on (A.id = tempTable_1.'id_1')
     *
     *          -- 无 子节点是否有重名名
     *              -- 有 left join table as tempTable_1 on ( xxx = table.id )
     *              -- 无 left join table on ( xxx = table.id )
     *
     *          -- 所有节点的临时表结果保存在节点中（非叶子节点）
     *
     *
     *
     */


    public static void main(String[] args) {
        //todo 构造数据
        //数据库字段结构


        Map<String, List<String>> tableMetaDataMap = new HashMap<>();
        tableMetaDataMap.put("class",Arrays.asList("id","class_name","school_id","honour_id"));
        tableMetaDataMap.put("student",Arrays.asList("id","name","class_id","project_id"));
        tableMetaDataMap.put("school",Arrays.asList("id","school_name"));
        tableMetaDataMap.put("honour",Arrays.asList("id","h_name"));
        tableMetaDataMap.put("project",Arrays.asList("id","name"));


        List<Node> treeData = new ArrayList<>();

        Node headNode = new Node();
        headNode.setId("1");
        headNode.setTableCode("student");


        Node node1 = new Node();
        node1.setId("2");
        node1.setTableCode("student");
        node1.setParentId("1");
        node1.setType(JoinType.LEFT_JOIN);
        JoinInfo joinInfo = new JoinInfo(new TagField("student","id"),new TagField("student","id"));
        node1.setJoinInfo(Arrays.asList(joinInfo));

//        Node node4 = new Node();
//        node4.setId("5");
//        node4.setTableCode("project");
//        node4.setParentId("1");
//        node4.setType(JoinType.RIGHT_JOIN);
//        JoinInfo joinInfo4 = new JoinInfo(new TagField("student","project_id"),new TagField("project","id"));
//        node4.setJoinInfo(Arrays.asList(joinInfo4));

        Node node2 = new Node();
        node2.setId("3");
        node2.setTableCode("student");
        node2.setParentId("2");
        node2.setType(JoinType.LEFT_JOIN);
        JoinInfo joinInfo2 = new JoinInfo(new TagField("student","id"),new TagField("student","id"));
        node2.setJoinInfo(Arrays.asList(joinInfo2));


        Node node3 = new Node();
        node3.setId("4");
        node3.setTableCode("student");
        node3.setParentId("2");
        node3.setType(JoinType.LEFT_JOIN);
        JoinInfo joinInfo3 = new JoinInfo(new TagField("student","id"),new TagField("student","id"));
        node3.setJoinInfo(Arrays.asList(joinInfo3));

        Node node4 = new Node();
        node4.setId("5");
        node4.setTableCode("student");
        node4.setParentId("2");
        node4.setType(JoinType.LEFT_JOIN);
        JoinInfo joinInfo4 = new JoinInfo(new TagField("student","id"),new TagField("student","id"));
        node4.setJoinInfo(Arrays.asList(joinInfo4));

        Node node5 = new Node();
        node5.setId("6");
        node5.setTableCode("student");
        node5.setParentId("4");
        node5.setType(JoinType.LEFT_JOIN);
        JoinInfo joinInfo5 = new JoinInfo(new TagField("student","id"),new TagField("student","id"));
        node5.setJoinInfo(Arrays.asList(joinInfo5));

        Node node6 = new Node();
        node6.setId("7");
        node6.setTableCode("student");
        node6.setParentId("4");
        node6.setType(JoinType.LEFT_JOIN);
        JoinInfo joinInfo6 = new JoinInfo(new TagField("student","id"),new TagField("student","id"));
        node6.setJoinInfo(Arrays.asList(joinInfo6));

        treeData.add(headNode);
        treeData.add(node1);
        treeData.add(node2);
        treeData.add(node3);
        treeData.add(node4);
        treeData.add(node5);
        treeData.add(node6);

        String dbType = "mysql";
        String scheme = "mysql";

        treeData.forEach(r->{
            List<String> fields = tableMetaDataMap.get(r.getTableCode());
            r.setFields(fields);
        });

        //todo 唯一化 表中重复的所有字段
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


            List<String> fields = r.getFields();

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

        wrapTableAndFiled(treeData,"mysql",null);





        List<Node> nodes = list2Tree(treeData);

        System.out.println(nodes);

        List<Node> dataNode = new ArrayList<>();
        cylTree(nodes,dataNode);

        AtomicInteger count = new AtomicInteger();
        int size = dataNode.size();
        if(size == 1){
            Node node = dataNode.get(0);

            StringBuffer buffer = new StringBuffer();
            buffer.append("select ");
            String finalTableCode = node.getTableCode();
            node.getFields().forEach(f->{
                buffer.append(String.format(" %s.%s ,", finalTableCode,f));
            });
            buffer.deleteCharAt(buffer.length()-1);
            buffer.append(" from "+node.getTableCode());
            node.setNodeSql(buffer.toString());
            System.out.println(buffer.toString());
        } else {
            for (int i = size-1; i >= 0; i--) {
                Node node = dataNode.get(i);
                List<Node> children = node.getChildren();
                if(children!=null&&!children.isEmpty()){
                    StringBuffer buffer = new StringBuffer();

                    List<Node> hasChildrenNode = new ArrayList<>();
                    List<Node> withOutChildrenNode = new ArrayList<>();
                    withOutChildrenNode.add(node);
                    children.forEach(n->{
                        if(Tools.isNotNull(n.getNodeSql())){
                            hasChildrenNode.add(n);
                        } else {
                            withOutChildrenNode.add(n);
                        }
                    });
                    buffer.append("select ");
                    withOutChildrenNode.forEach(n->{
                        List<String> fields = n.getFields();
                        Map<String, String> aliasFieldMap = n.getAliasFieldMap();
                        String tableCode = Tools.isNotNull(n.getTableAliasName())?n.getTableAliasName():n.getTableCode();
                        //父节点 字段查询  表名不需要别名处理
                        if(n == node){
                            tableCode = n.getTableCode();
                        }
                        String finalTableCode = tableCode;
                        fields.forEach(f->{
                            if(Tools.isNotNull(aliasFieldMap.get(f))){
                                buffer.append(String.format(" %s.%s as %s ,", finalTableCode,f,aliasFieldMap.get(f)));
                            } else {
                                buffer.append(String.format(" %s.%s ,", finalTableCode,f));
                            }
                        });
                    });

                    hasChildrenNode.forEach(n->{
                        String tableCode = Tools.isNotNull(n.getTableAliasName())?n.getTableAliasName():n.getTableCode();
                        buffer.append(String.format(" %s.* ,",String.format("%s_tempTable",tableCode)));
                    });

                    buffer.deleteCharAt(buffer.length()-1);

                    buffer.append(" from "+node.getTableCode());

                    children.forEach(n->{
                        if(Tools.isNotNull(n.getNodeSql())){

                            String tableCode = Tools.isNotNull(n.getTableAliasName())?n.getTableAliasName():n.getTableCode();
                            String tempTableCode = String.format("%s_tempTable", tableCode);
                            // left join (select ...) on ()
                            buffer.append(String.format(" %s( %s )"+" as %s on (",n.getType().getCode(),n.getNodeSql(),tempTableCode));
                            n.getJoinInfo().forEach(q->{
                                String fieldCode = q.getDestField().getFieldCode();
                                String desFieldCode = n.getAliasFieldMap().getOrDefault(fieldCode,fieldCode);
                                buffer.append(" "+node.getTableCode()+"."+q.getSourceField().getFieldCode()+" = " + tempTableCode+"."+desFieldCode);
                            });
                            buffer.append(")");
                            count.getAndIncrement();
                        } else {
                            if(Tools.isNotNull(n.getTableAliasName())){
                                // left join table as tempTable on (
                                buffer.append(String.format(" %s %s as %s on (",n.getType().getCode(),n.getTableCode(),n.getTableAliasName()));
                                n.getJoinInfo().forEach(q->{
                                    buffer.append(" "+node.getTableCode()+"."+q.getSourceField().getFieldCode()+" = " + n.getTableAliasName()+"."+q.getDestField().getFieldCode());
                                });
                            } else {
                                // left join table on (
                                buffer.append(String.format(" %s %s on (",n.getType().getCode(),n.getTableCode()));
                                n.getJoinInfo().forEach(q->{
                                    buffer.append(" "+node.getTableCode()+"."+q.getSourceField().getFieldCode()+" = " + n.getTableCode()+"."+q.getDestField().getFieldCode());
                                });
                            }
                            buffer.append(")");
                        }

                    });
                    node.setNodeSql(buffer.toString());
                    System.out.println(buffer.toString());
                }
            }
        }

    }

    public static void wrapTableAndFiled(List<Node> nodes,String dbType,String schema){
        nodes.forEach(r->{
            r.setTableCode(DataTypeUtil.getQuoteSchemaTable(dbType,schema,r.getTableCode()));

            List<String> fields = new ArrayList<>();
            r.getFields().forEach(f->{
                fields.add(DataTypeUtil.quoteField(dbType,f));
            });
            r.setFields(fields);

            Map<String,String> aliasFieldMap = new HashMap<>();
            Map<String, String> aliasFieldTempMap = r.getAliasFieldMap();
            aliasFieldTempMap.forEach((k,v)->{
                aliasFieldMap.put(DataTypeUtil.quoteField(dbType,k),DataTypeUtil.quoteField(dbType,v));
            });
            r.setAliasFieldMap(aliasFieldMap);

            r.getJoinInfo().forEach(info->{
                TagField sourceField = info.getSourceField();
                TagField destField = info.getDestField();
                sourceField.setFieldCode(DataTypeUtil.quoteField(dbType,sourceField.getFieldCode()));
                sourceField.setTableCode(DataTypeUtil.getQuoteSchemaTable(dbType,schema,sourceField.getTableCode()));

                destField.setFieldCode(DataTypeUtil.quoteField(dbType,destField.getFieldCode()));
                destField.setTableCode(DataTypeUtil.getQuoteSchemaTable(dbType,schema,destField.getTableCode()));
            });


        });
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

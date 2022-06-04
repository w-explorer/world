package com.explore.model.biz.cha03prototype.deptClone.model;

import lombok.*;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.*;

/**
 * @author wencheng
 * @create 2022/6/4 12:38
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Park implements Cloneable, Serializable {

    private String name;

    private String addr;

    private Tree tree;

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object deep = null;
        //基本数据类型
        deep = super.clone();

        Park park = (Park) deep;
        park.tree = (Tree) tree.clone();

        return deep;
    }

    public Park deepClone(){
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;

        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;


        try {
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);//当前对象以对象流的方式输出

            //反序列化
            bis =new  ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            Park park = (Park)ois.readObject();
            return park;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(bos);
            IOUtils.closeQuietly(oos);
            IOUtils.closeQuietly(bis);
            IOUtils.closeQuietly(ois);
        }
        return null;
    }
}

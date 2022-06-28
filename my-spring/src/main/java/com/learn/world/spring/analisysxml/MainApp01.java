package com.learn.world.spring.analisysxml;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @author wencheng
 * @create 2022/6/28 17:46
 */
public class MainApp01 {
    /**
     * 解析xml
     * @param args
     */
    public static void main(String[] args) {
        try (Connection connection = getConnection()){
            File file = new File("C:\\Users\\86135\\Documents\\WXWork\\1688852705482790\\Cache\\File\\2022-06\\cloudbugs");		//获取其file对象
            File[] fs = file.listFiles();
            for (File f : fs) {
                readXml(f.getAbsolutePath(),connection,f.getName());
            }

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }
    public static void readXml(String filePath,Connection connection,String fileName) {
        try {
            // 创建解析器工厂
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = factory.newDocumentBuilder();
            // 创建一个Document对象
            Document doc = db.parse(filePath);
            NodeList bookList = doc.getElementsByTagName("Method");
            // 获取节点个数
            System.out.println("一共有" + bookList.getLength() + "method");

            // 遍历每个book节点
            for (int i = 0; i < bookList.getLength(); i++) {
                System.out.println("*******************************");
                // 索引从零开始
                org.w3c.dom.Node book = bookList.item(i);
                // 获取book节点所有属性集合
                org.w3c.dom.NamedNodeMap attrs = book.getAttributes();

                System.out.println("第" + (i + 1) + "method" + "属性");
                // 遍历book属性，不知道节点属性和属性名情况
//                for (int j = 0; j < attrs.getLength(); j++) {
//                    // 获取某一个属性
//                    org.w3c.dom.Node attr = attrs.item(j);
//                    System.out.print("属性名:" + attr.getNodeName());
//                    System.out.println(" --- 属性值:" + attr.getNodeValue());
//                }
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `104test`.`warning`(`model_name`, `classname`, `method_name`) VALUES (?,?,?)");
                ps.setString(1,fileName);
                ps.setString(2,attrs.item(0).getNodeValue());
                ps.setString(3,attrs.item(2).getNodeValue());
                ps.execute();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection  con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("数据库驱动加载成功");
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        try {
            String pd = "Cdsf_sjzl_5408";
            String url = "jdbc:mysql://10.0.8.104:53302/104test?serverTimezone=Asia/Shanghai&noAccessToProcedureBodies=true&useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true";
            con = DriverManager.getConnection(url,"sdc", pd);
            System.out.println("数据库连接成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}



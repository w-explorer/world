package com.learn.world.spring.test;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wencheng
 * @create 2021/12/17 14:37
 */
public class Main {


    public static void main(String[] args) {
        String NEW_LINE = "\n";
        long start = System.currentTimeMillis();
        BufferedWriter bw = null;
        String fileName = "D:\\文档\\WXWork\\1688852705482790\\Cache\\File\\2022-01\\测试.csv";
        List<String> columnNames = new ArrayList<>();
        columnNames.add("公民身份号码(syrk_gmsfhm)");
        columnNames.add("姓名(syrk_xm)");
        StringBuilder buf = new StringBuilder();
        // 组装表头
        for (String columnName : columnNames) {
            buf.append(columnName).append(",");
        }
        buf.append(NEW_LINE);

        List<Map<String,Object>> datas = new ArrayList<>();
        HashMap<String, Object> map = new HashMap<>();
        map.put("公民身份号码(syrk_gmsfhm)","150221194602264000");
        map.put("姓名(syrk_xm)","王二黑哴");
        datas.add(map);

        // 组装数据
        for (Map<String, Object> data : datas) {
            for (String columnName : columnNames) {
                String strValue = String.valueOf(data.get(columnName));
                strValue = strValue.replaceAll("\"","\"\"");
                buf.append("\"").append(strValue).append("\"").append(",");
            }
            buf.append(NEW_LINE);
        }
        // 生成文件
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "GBK"));
            bw.write(buf.toString());
            bw.flush();
            long end = System.currentTimeMillis();
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }finally {
            if (null != bw) {
                try {
                    bw.close();
                } catch (Exception e) {
                }
            }
            try {
            } catch (Exception e) {
            }
        }
    }
}

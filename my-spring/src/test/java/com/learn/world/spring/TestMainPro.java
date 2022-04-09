package com.learn.world.spring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wencheng
 * @create 2021/9/18 14:30
 */
public class TestMainPro  {
    public static void main(String[] args) {
        List<Bean> bean56 = listData("D:\\tmp\\test.txt");
        List<Bean> bean104 = listData("D:\\tmp\\test - 副本.txt");
        HashMap<String, String> map56 = new HashMap<>();
        HashMap<String, String> map104 = new HashMap<>();
        bean56.forEach(r->{
            if(map56.get(r.getName())==null){
                map56.put(r.getName(),r.getCode());
            }
        });
        bean104.forEach(r->{
            if(map104.get(r.getName())==null){
                map104.put(r.getName(),r.getCode());
            }
        });

        map56.forEach((k,v)->{
            if(map104.get(k)!=null&&!map104.get(k).equals(v)){
                System.out.println("56code:"+k+"name:"+v+" "+"104code:"+k+"name:"+map104.get(k));
            }
        });
    }

    private static List<Bean> listData(String fileName) {
        // 使用ArrayList来存储每行读取到的字符串
        List<Bean> arrayList = new ArrayList<>();
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader bf = new BufferedReader(fr);
            String str;
            // 按行读取字符串
            while ((str = bf.readLine()) != null) {
                String[] split = str.split(",");
                arrayList.add(new Bean(split[1],split[0]));
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Bean{
    private String code;
    private String name;
}

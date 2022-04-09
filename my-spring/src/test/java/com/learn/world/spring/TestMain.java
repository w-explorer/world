package com.learn.world.spring;

import lombok.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wencheng
 * @create 2021/9/18 14:30
 */
public class TestMain  {
    public static void main(String[] args) {
        // 使用ArrayList来存储每行读取到的字符串
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            FileReader fr = new FileReader("D:\\tmp\\test.txt");
            BufferedReader bf = new BufferedReader(fr);
            String str;
            // 按行读取字符串
            while ((str = bf.readLine()) != null) {
                arrayList.add(str);
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuffer buffer = new StringBuffer();
        List<String> collect = arrayList.stream().distinct().collect(Collectors.toList());
        collect.forEach(r->{
            buffer.append("'"+r+"'"+",");
        });
        System.out.println(buffer.toString());
        System.out.println(arrayList.size());
    }
}

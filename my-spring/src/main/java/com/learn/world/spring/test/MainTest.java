package com.learn.world.spring.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wencheng
 * @create 2022/1/21 15:26
 */
public class MainTest {
    public static void main(String[] args) {

        File file = new File("\\D:\\tmp\\77\\test.txt");
        HashSet<String> set = new HashSet<>();
        try{

            BufferedReader br = new BufferedReader(new FileReader(file));

            String s;

            while((s = br.readLine())!=null){

                set.add(s.substring(s.lastIndexOf("/")+1));
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        set.forEach(r-> System.out.println(r));

    }
}

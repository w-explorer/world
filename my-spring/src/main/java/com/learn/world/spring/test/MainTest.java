package com.learn.world.spring.test;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wencheng
 * @create 2022/1/21 15:26
 */
public class MainTest {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>(2);

        map.put("debugType", "1");
        map.put("msg","2");
        System.out.println(map.toString());

    }
    public static java.util.Date getDateObject(Object o){
        if (o != null) {
            if (o instanceof Date) {
                return new java.util.Date(((Date) o).getTime());
            }
            if (o instanceof Timestamp) {
                return new java.util.Date(((Timestamp) o).getTime());
            }
            if (o instanceof Time) {
                return new java.util.Date(((Time) o).getTime());
            }
        }
        return null;
    }

    public static String timeStamp2Date(String seconds,String format) {
        if(seconds == null || seconds.isEmpty() || seconds.equals("null")){
            return "";
        }
        if(format == null || format.isEmpty()){
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds)));
    }
}

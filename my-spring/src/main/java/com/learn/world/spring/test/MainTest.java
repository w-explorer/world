package com.learn.world.spring.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wencheng
 * @create 2022/1/21 15:26
 */
public class MainTest {
    public static void main(String[] args) {
        String[] arr = new String[12];
        arr[0] = "1";
        arr[1] = "1";

        List<String> collect = Arrays.stream(arr).distinct().filter(r->Tools.isNotNull(r)).collect(Collectors.toList());
        System.out.println(collect);


    }


}

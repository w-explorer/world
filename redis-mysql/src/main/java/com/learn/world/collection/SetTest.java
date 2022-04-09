package com.learn.world.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @author wencheng
 * @create 2021/7/27 14:22
 */
public class SetTest {
    public static void main(String[] args) {
//        Set<String> set = new HashSet<>();
//        set.add(null);
//        set.add("1");
//        set.remove(null);
//        ArrayList<String> list = new ArrayList<>(set);
//        list.forEach(r->{
//            System.out.println(r);
//        });
        System.out.println(accept("*log","log.txt"));

        System.out.println((int)Math.ceil(new Double(5) / 2));
    }
    public void test(){

        String s = new String();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.reverse();
    }

    public static boolean accept(String wildcard, String fileName) {
        Pattern bak = Pattern.compile("^" + wildcard);
        return bak.matcher(fileName).find();
    }
}

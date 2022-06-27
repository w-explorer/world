package com.learn.world.spring.datasplit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wencheng
 * @create 2022/6/27 9:19
 */
public class MainApp {

    public static void main(String[] args) {
        List<String> data = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            data.add(""+i);
        }

        DataSplitter dataSplitter = new DataSplitter(data, 4);
        while (dataSplitter.hasNext()){
            List<String> next = dataSplitter.next();
            System.out.println("next = " + next);
        }
    }
}

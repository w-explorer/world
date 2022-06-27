package com.learn.world.spring.datasplit;

import java.util.Iterator;
import java.util.List;

/**
 * @author wencheng
 * @create 2022/6/27 9:20
 */
public class DataSplitter implements Iterator<List<String>> {

    private final List<String> data;

    private int currentIndex;

    private int dataStep;

    public DataSplitter(List<String> data, int dataStep) {
        this.data = data;
        this.dataStep = dataStep;
    }

    @Override
    public boolean hasNext() {
        if(currentIndex< data.size()){
            return true;
        }
        return false;
    }

    @Override
    public List<String> next() {

        int nextIndex = currentIndex;

        for (; nextIndex < data.size() ; nextIndex++) {
            if(nextIndex - currentIndex == dataStep){
                break;
            }
        }

        List<String> subList = data.subList(currentIndex, nextIndex);
        currentIndex = nextIndex;

        return subList;
    }
}

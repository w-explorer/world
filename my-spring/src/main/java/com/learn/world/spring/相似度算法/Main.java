package com.learn.world.spring.相似度算法;

import me.xdrop.diffutils.DiffUtils;
import me.xdrop.fuzzywuzzy.FuzzySearch;

/**
 * @author wencheng
 * @create 2021/11/2 9:06
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("1 "+ FuzzySearch.ratio("1", "xx你是"));
        System.out.println("2 "+FuzzySearch.partialRatio("ADMIN", "admin"));
        System.out.println("3 "+FuzzySearch.tokenSetPartialRatio("test", "test1"));
        System.out.println("4 "+FuzzySearch.weightedRatio("你是那个", "xx你是"));
        System.out.println("5 "+FuzzySearch.tokenSortRatio("你是", "你是W"));
        System.out.println("6 "+FuzzySearch.tokenSetRatio("你是", "你是o"));
        System.out.println(DiffUtils.getRatio("你是", "你是我"));
        System.out.println(DiffUtils.levEditDistance("你是", "你是我",1));
        System.out.println(DiffUtils.getMatchingBlocks("你是", "你是我"));
        System.out.println(DiffUtils.getEditOps("你是", "你是我"));
    }
}

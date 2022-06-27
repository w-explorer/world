package com.learn.world.spring.test;

import com.learn.world.spring.test.es.EsSearchRequestBuilderAdapter;
import com.learn.world.spring.test.es.Script;
import com.sefonsoft.pub.ds.api.elasticsearch.model.request.EsSearchRequest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author wencheng
 * @create 2022/6/8 14:06
 */
public class EsMainApp {
    public static void main(String[] args) {
        int pageIndex = 1;
        int pageSize =10;

        EsSearchRequest searchRequest = new EsSearchRequest();
        searchRequest.setIndex("test_index");

        EsSearchRequestBuilderAdapter searchReqBuilder = new EsSearchRequestBuilderAdapter();
        searchReqBuilder.includeFields(new HashSet<>(Arrays.asList("primaryKey","searchDataType")));

        searchReqBuilder.from((pageIndex-1) * pageSize);
        searchReqBuilder.size(pageSize);
        HashMap<String, Script> map = new HashMap<>();
        map.put("test_1",new Script("doc['searchDataType'].value+\"123\""));
        map.put("test_2",new Script("doc['searchDataType'].value+\"123\""));
        searchReqBuilder.setBeans(map);

        System.out.println(searchReqBuilder.toJsonString());
    }
}

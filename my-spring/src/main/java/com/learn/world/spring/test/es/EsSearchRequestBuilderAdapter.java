package com.learn.world.spring.test.es;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sefonsoft.cloud.elasticsearch.sdk.search.EsSearchRequestBuilder;

import java.util.Map;

/**
 * @author wencheng
 * @create 2022/6/8 14:51
 */
public class EsSearchRequestBuilderAdapter extends EsSearchRequestBuilder {
    @JsonProperty("script_fields")
    private Map<String, Script> beans;

    public String toJsonString() {
        String result = null;

        try {
            result = (new ObjectMapper()).writeValueAsString(this);
            return result;
        } catch (JsonProcessingException var3) {
            throw new RuntimeException(var3);
        }
    }

    public Map<String, Script> getBeans() {
        return beans;
    }

    public void setBeans(Map<String, Script> beans) {
        this.beans = beans;
    }
}

package com.learn.world.spring.domain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.minidev.json.JSONValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 文本样式 
 * 2018年12月1日  下午4:09:30
 * @Author Huangxiaocong
 */
public class TextStyle {
    

    public static void main(String[] args) {
        Demo demo = new Demo();

        Map<String, List<String>> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        map.put("dynamicAttributes",list);
        demo.setDynamicAttributes(map);

        System.out.println(String.format("{\"terms\": {\"dynamicList\": \"%s\"}}", list));
    }

}
@Data
class Demo{
    private Map<String, List<String>> dynamicAttributes;
}
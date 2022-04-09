package com.learn.world.spring.aspect.controller;

import com.learn.world.spring.aspect.handler.ApiCount;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wencheng
 * @create 2021/9/18 14:49
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/around")
    @ApiCount
    public void testAround(){
        System.out.println("内容");
    }
}

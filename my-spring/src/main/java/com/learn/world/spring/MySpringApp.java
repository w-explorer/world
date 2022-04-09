package com.learn.world.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author wencheng
 * @create 2021/9/18 14:37
 */
@SpringBootApplication
//@EnableTransactionManagement
//@EnableSwagger2
@MapperScan(basePackages = {"com.learn.world.spring.**.mapper"})
public class MySpringApp {
    public static void main(String[] args) {
        SpringApplication.run(MySpringApp.class,args);
    }
}

package com.learn.world.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.learn.world.redis.mapper")
@EnableSwagger2
public class RedisMysqlApplication {

    public static void main(String[] args){
        SpringApplication.run(RedisMysqlApplication.class,args);
    }

}

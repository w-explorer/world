package com.learn.world.redis;

import com.learn.world.redis.mapper.TaskMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author wencheng
 * @create 2021/5/26 17:50
 */
public class RedisTest extends BaseTestService{

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void test1(){
        redisTemplate.opsForValue().set("test","test");
        System.out.println(redisTemplate.opsForValue().get("test"));
    }

    @Test
    public void test2(){
        taskMapper.insertTest("A",1);
    }

    /**
     * 缓存读取
     */

    //
}

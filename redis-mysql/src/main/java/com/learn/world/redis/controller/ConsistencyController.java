package com.learn.world.redis.controller;

import com.learn.world.redis.mapper.TaskMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author wencheng
 * @create 2021/5/27 10:23
 */
@RestController
@RequestMapping("/")
public class ConsistencyController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private TaskMapper taskMapper;

    @ApiOperation(value = "save")
    @PostMapping("/save")
    public void save(@RequestParam String bus,@RequestParam int no){
        taskMapper.insertTest(bus,no);
    }

    @ApiOperation(value = "update")
    @PostMapping("/update_delete")
    public void update(@RequestParam String bus,@RequestParam int no){
        taskMapper.updateTest(bus,no);
        redisTemplate.delete(bus);
    }

    @ApiOperation(value = "update1")
    @PostMapping("/update1_delete")
    public void update1(@RequestParam String bus,@RequestParam int no){
        taskMapper.updateTest(bus,no);
        int flog =5;
        try {
            redisTemplate.delete(bus);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//更新缓存---------------还是删除缓存----------------------//

    /**
     * 更新缓存，多个线程之间，会由于网络的原因。缓存操作顺序错误。导致脏数据
     *
     * 删除缓存，出现脏数据只有在，删除缓存失败的情况下才会出现，但是删除失败的场景很少。
     * 可以加重试机制。
     */

    @ApiOperation(value = "update_up")
    @PostMapping("/update_up")
    public void update_up(@RequestParam String bus,@RequestParam int no){
        taskMapper.updateTest(bus,no);
        try {
            //等待2秒  让线程B 先更新缓存。造成缓存 和 DB 数据不一致。
            //产生脏数据
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        redisTemplate.opsForValue().set(bus,no,5,TimeUnit.MINUTES);
    }

    @ApiOperation(value = "update1_up")
    @PostMapping("/update1_up")
    public void update1_up(@RequestParam String bus,@RequestParam int no){
        taskMapper.updateTest(bus,no);
        redisTemplate.opsForValue().set(bus,no,5,TimeUnit.MINUTES);
    }
    //更新缓存---------------还是删除缓存----------------------//

    @ApiOperation(value = "get")
    @PostMapping("/get")
    public int get(@RequestParam String bus){
        Object o = redisTemplate.opsForValue().get(bus);
        if(o == null){
            Integer integer = taskMapper.selectByBus(bus);
            if(integer == null){
                throw new RuntimeException("data is null");
            }
            int value = integer.intValue();
            redisTemplate.opsForValue().set(bus,value, 5,TimeUnit.MINUTES);
            return value;
        } else {
            return (int) o;
        }
    }
}

package com.learn.world.redis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author wencheng
 * @create 2020/9/8 14:54
 */
public interface TaskMapper extends BaseMapper<Object> {
    void insertTest(@Param("bus")String bus,@Param("no")int no);

    Integer selectByBus(@Param("bus")String bus);

    void updateTest(@Param("bus")String bus,@Param("no")int no);
}

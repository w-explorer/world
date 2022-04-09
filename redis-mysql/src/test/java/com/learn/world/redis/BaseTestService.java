package com.learn.world.redis;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author zhouyu4034@sefonsoft.com
 * @date 2020/9/14 9:21
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BaseTestService {
    long start = 0;

    @Before
    public void init() {
        System.out.println("开始测试-----------------");
        start = System.currentTimeMillis();
    }

    @After
    public void after() {
        System.out.println("测试结束，总共耗时：" + (System.currentTimeMillis() - start));
    }

}

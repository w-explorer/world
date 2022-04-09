package com.learn.world.spring.transcational;

import com.learn.world.spring.MySpringApp;
import com.learn.world.spring.transactional.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wencheng
 * @create 2021/9/30 10:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MySpringApp.class)
public class TransTest {
    @Autowired
    private IUserService userService;



    @Test
    public void transactionAction(){
        userService.transactionActionPrivate();
    }

}

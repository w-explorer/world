package com.learn.world.spring.transactional.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.world.spring.transactional.dao.mapper.UserMapper;
import com.learn.world.spring.transactional.model.User;
import com.learn.world.spring.transactional.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author wencheng
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public void privteMethod() {

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void transactionAction() {
        User user = new User();
        user.setName("你好");
        saveOrUpdate(user);
        transactionTemplate.execute(status -> {
            transactionAction2();
            return Boolean.TRUE;
        });

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void transactionAction2() {
        User user = new User();
        user.setName("你好2");
        saveOrUpdate(user);

        int i = 1/0;
    }

    @Transactional(rollbackFor = Exception.class)
    public final void finalMethod() {
        User user = new User();
        user.setName("你好");
        saveOrUpdate(user);

        int i = 1/0;
    }


    @Transactional(rollbackFor = Exception.class)
    public void transactionActionPrivate() {
        method();
    }

    private void method(){
        method2();
                int a = 2/0;

    }
//    @Transactional(rollbackFor = Exception.class)
    public void method2(){
        User user = new User();
        user.setName("你好11111");
        saveOrUpdate(user);
//        int a = 2/0;
    }
}

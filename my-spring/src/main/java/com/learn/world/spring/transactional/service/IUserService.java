package com.learn.world.spring.transactional.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.world.spring.transactional.model.User;

/**
 * @author wencheng
 */
public interface IUserService extends IService<User> {

    void privteMethod();

    void transactionAction();

    void transactionAction2();

    void transactionActionPrivate();
}

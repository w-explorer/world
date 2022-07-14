package com.explore.model.biz.cha20watch;

/**
 * @author wencheng
 * @create 2022/7/14 13:53
 */
public interface Manager {
    /**
     * 注册
     * @param user
     */
    void registered(IUser user);

    /**
     * 移除
     * @param user
     * @return
     */
    boolean remove(IUser user);

    /**
     * 通知变更
     */
    void noticeAll();
}

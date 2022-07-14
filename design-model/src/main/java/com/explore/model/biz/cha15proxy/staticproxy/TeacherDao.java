package com.explore.model.biz.cha15proxy.staticproxy;

/**
 * @author wencheng
 * @create 2022/7/12 19:44
 */
public class TeacherDao implements ITeacherDao{
    @Override
    public void teach() {
        System.out.println("老师授课中");
    }
}

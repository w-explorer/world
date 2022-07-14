package com.explore.model.biz.cha15proxy.dynamic;

/**
 * @author wencheng
 * @create 2022/7/12 19:44
 */
public class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println("老师授课中");
    }

    @Override
    public void sayHello(String name) {
        System.out.println("hello: "+name);
    }
}

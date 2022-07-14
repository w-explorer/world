package com.explore.model.biz.cha15proxy.cglib;

/**
 * @author wencheng
 * @create 2022/7/14 10:43
 */
public class Client {
    public static void main(String[] args) {
        TeacherDao teacherDao = new TeacherDao();
        TeacherDao proxyInstance = (TeacherDao)new ProxyFactory(teacherDao).getProxyInstance();

        System.out.println(proxyInstance.teach());

    }
}

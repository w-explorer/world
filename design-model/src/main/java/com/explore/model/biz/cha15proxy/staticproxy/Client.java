package com.explore.model.biz.cha15proxy.staticproxy;

/**
 * @author wencheng
 * @create 2022/7/12 19:45
 */
public class Client {
    public static void main(String[] args) {
        TeacherDao teacherDao = new TeacherDao();
        TeacherDaoProxy teacherDaoProxy = new TeacherDaoProxy(teacherDao);
        teacherDaoProxy.teach();
    }
}

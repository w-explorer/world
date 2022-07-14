package com.explore.model.biz.cha15proxy.dynamic;

/**
 * @author wencheng
 * @create 2022/7/12 20:15
 */
public class Client {
    public static void main(String[] args) {
        ITeacherDao teacherDao = new TeacherDao();
        ITeacherDao proxyInstance = (ITeacherDao) new ProxyFactory(teacherDao).getProxyInstance();
        System.out.println(proxyInstance);
        proxyInstance.teach();

        proxyInstance.sayHello("tom");
    }
}

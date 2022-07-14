package com.explore.model.biz.cha15proxy.staticproxy;

/**
 * @author wencheng
 * @create 2022/7/12 19:44
 */
public class TeacherDaoProxy implements ITeacherDao{
    private TeacherDao teacherDao;

    public TeacherDaoProxy(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public void teach() {
        System.out.println("开始代理");
        teacherDao.teach();
        System.out.println("结束代理");
    }
}

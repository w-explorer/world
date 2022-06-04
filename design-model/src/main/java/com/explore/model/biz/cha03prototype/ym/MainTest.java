package com.explore.model.biz.cha03prototype.ym;

import com.explore.model.biz.cha03prototype.improve.Sheep;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author wencheng
 * @create 2022/5/31 20:39
 */
public class MainTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Object sheep = applicationContext.getBean("sheep");
        Object sheep1 = applicationContext.getBean("sheep");
        System.out.println(sheep == sheep1);

        Sheep sheep2 = (Sheep)applicationContext.getBean("sheepSingleTon");
        Sheep sheep3 = (Sheep)applicationContext.getBean("sheepSingleTon");
        System.out.println(sheep2 == sheep3);

        List<String> list = sheep2.getList();
        list.add("1");

        sheep3.getList().add("2");
        System.out.println(sheep3.getList());
        System.out.println(sheep2 == sheep3);
    }
}

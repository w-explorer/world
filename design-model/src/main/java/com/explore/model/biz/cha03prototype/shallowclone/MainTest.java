package com.explore.model.biz.cha03prototype.shallowclone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wencheng
 * @create 2022/6/4 13:18
 */
public class MainTest {
    //浅拷贝:只拷贝了对象的引用，对象的值发生变化，拷贝对象的值也对随着变化。
    public static void main(String[] args) {
        Person person1 = new Person("张三", 1);
        Person person2 = person1;

        person2.setAge(2);

        System.out.println(String.format("person:%s,hashCode:%s",person1.toString(),person1.hashCode()));
        System.out.println(String.format("person:%s,hashCode:%s",person2.toString(),person2.hashCode()));
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Person{
    private String name;
    private int age;
}

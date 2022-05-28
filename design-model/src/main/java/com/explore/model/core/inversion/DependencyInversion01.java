package com.explore.model.core.inversion;

/**
 * @author wencheng
 * @create 2022/5/23 20:26
 */
public class DependencyInversion01 {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
    }

}

class Email{
    public String getInfo(){
        return "电子邮件信息：Hello word!";
    }
}

/**
 * 1.完成Person接口信息的功能
 * 方法分析：
 * 1.简单，比较容易想到
 * 2.如果后续需要扩展更多的接收对象，例如微信，QQ等。改动比较大需要新增类，需要在Person中新增对应的方法
 * 3.解决思路，依赖倒转。反向约束。引入IReceive 接受者接口。这样Person和IReceive发送依赖。Email和微信等就各自实现IReceive接口就可以。
 *
 **/
class Person{
    public void receive(Email email){
        System.out.println(email.getInfo());
    }
}

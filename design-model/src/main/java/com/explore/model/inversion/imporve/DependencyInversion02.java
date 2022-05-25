package com.explore.model.inversion.imporve;

/**
 * @author wencheng
 * @create 2022/5/23 20:26
 */
public class DependencyInversion02 {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
        person.receive(new WeiXin());
    }

}

/**
 * 定义接口
 */

interface IReceive{
    public String getInfo();
}

class Email implements IReceive{
    public String getInfo(){
        return "电子邮件信息：Hello word!";
    }
}

class WeiXin implements IReceive{
    public String getInfo(){
        return "微信信息：Hello word!";
    }
}

class Person{
    public void receive(IReceive receive){
        System.out.println(receive.getInfo());
    }
}

package com.explore.model.inversion.dependencyTransmit.constructor;

public class Main {

    public static void main(String[] args) {

        Person person = new Person(new Email());
        person.receive();
    }
}


interface IReceive{

    String getInfo();

}

class Email implements IReceive{

    @Override
    public String getInfo() {
        return "Email 消息发送{构造方法 传递}";
    }

}

class Person {

    private IReceive receive;

    public Person(IReceive receive) {
        this.receive = receive;
    }

    public void receive(){
        System.out.println(receive.getInfo());
    }

}
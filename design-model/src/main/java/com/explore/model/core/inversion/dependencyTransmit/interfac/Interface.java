package com.explore.model.core.inversion.dependencyTransmit.interfac;

public class Interface {

    public static void main(String[] args) {

        Person person = new Person();
        person.receive(new Email());
    }
}


interface IReceive{
    String getInfo();
}

class Email implements IReceive{

    @Override
    public String getInfo() {
        return "Email 消息发送";
    }

}

class Person {
    public void receive(IReceive receive){
        System.out.println(receive.getInfo());
    }
}
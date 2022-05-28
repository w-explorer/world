package com.explore.model.core.inversion.dependencyTransmit.set;

public class Interface {

    public static void main(String[] args) {

        Person person = new Person();
        person.setReceive(new Email());
        person.receive();
    }
}


interface IReceive{
    String getInfo();
}

class Email implements IReceive{

    @Override
    public String getInfo() {
        return "Email 消息发送{set 传递}";
    }

}

class Person {

    private IReceive receive;

    public void setReceive(IReceive receive) {
        this.receive = receive;
    }

    public void receive(){
        System.out.println(receive.getInfo());
    }
}
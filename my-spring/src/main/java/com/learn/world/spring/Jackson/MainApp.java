package com.learn.world.spring.Jackson;

/**
 * @author wencheng
 * @create 2022/5/6 17:54
 */
public class MainApp {

    public static void main(String[] args) {

        EndEvent event = new EndEvent();
        event.setId("1");
        event.setType("event");
        event.setEndEvent("1");
        event.setEndInfo("2");


        StartEvent start = new StartEvent();
        start.setId("2");
        start.setType("start");
        start.setStartEvent("3");
        start.setStartInfo("4");

        jsonTest(event);
        jsonTest(start);

    }

    public static void jsonTest (BaseElement baseElement){
        if(baseElement.type.equals("start")){
            StartEvent startEvent = (StartEvent) baseElement;
            System.out.println(startEvent.toString());
        } else {
            EndEvent endEvent = (EndEvent) baseElement;
            System.out.println(endEvent.toString());
        }
    }
}

interface JsonService{
    void jsonTest (BaseElement baseElement);
}

class StartEven implements JsonService{

    @Override
    public void jsonTest(BaseElement baseElement) {
        StartEvent startEvent = (StartEvent) baseElement;
        System.out.println(startEvent.toString());
    }

}

class EntEven implements JsonService{

    @Override
    public void jsonTest(BaseElement baseElement) {
        EndEvent endEvent = (EndEvent) baseElement;
        System.out.println(endEvent.toString());
    }
}


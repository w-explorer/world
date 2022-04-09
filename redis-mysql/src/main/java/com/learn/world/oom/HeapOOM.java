package com.learn.world.oom;

import java.util.ArrayList;

/**
 * VM Args : -Xms20m -Xmx20m -XX:+HeapDumpOnOutOf-MemoryError
 * @author wencheng
 * @create 2021/7/2 9:46
 */
public class HeapOOM {
    static class OOMObject{

    }
    public static void main(String[] args) {
        ArrayList<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}

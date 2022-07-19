package com.learn.world.spring.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author wencheng
 * @create 2022/7/19 13:52
 */
public class Client {

    public static void main( String[] args ) {
        ServiceLoader<Export> exports = ServiceLoader.load(Export.class);
        Iterator<Export> iter =  exports.iterator();
        while (iter.hasNext()){
            Export export = iter.next();
            export.export();
        }
    }

}

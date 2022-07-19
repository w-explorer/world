package com.learn.world.spring.spi;

public class WordExport implements Export {
    @Override
    public void export( ) {
        System.out.println("导出为Word");
    }
}
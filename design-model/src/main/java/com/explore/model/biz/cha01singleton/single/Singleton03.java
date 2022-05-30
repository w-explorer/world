package com.explore.model.biz.cha01singleton.single;

import java.io.IOException;
import java.util.Properties;

/**
 * 饿汉式-静态代码块（适合复杂实例化）--例如需要加载一些配置文件才能完成类的初始化的-最简单
 *
 * 静态代码快-随着类的加载而加载
 *
 * @author wencheng
 * @create 2022/2/26 20:55
 */
public class Singleton03 {
    public static final Singleton03 INSTANCE;
    private String info;
    private Singleton03(String info){
        this.info = info;
    }

    static {
        Properties properties = new Properties();
        try {
            properties.load(Singleton03.class.getClassLoader().getResourceAsStream("/config/singleton03.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        INSTANCE = new Singleton03(properties.getProperty("info"));
    }

    public String getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return "Singleton03{" +
                "info='" + info + '\'' +
                '}';
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

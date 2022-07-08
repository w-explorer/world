package com.learn.world.common.utils;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * @author wencheng
 * @create 2022/7/8 10:50
 */
public class FileUtil {

    public static String getFilePath(String filePath) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource(filePath);
        return classPathResource.getURL().getPath();
    }

}

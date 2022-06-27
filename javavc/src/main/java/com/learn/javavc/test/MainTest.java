package com.learn.javavc.test;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.io.File;

/**
 * @author wencheng
 * @create 2022/6/17 17:34
 */
public class MainTest {

    public static void main(String[] args) {
        // 这个必须要写,不写报java.lang.UnsatisfiedLinkError
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        File imgFile = new File("C:/Users/admin/Desktop/open/test.png");
        String dest = "C:/Users/admin/Desktop/open";
//        Mat src = Imgcodecs.imread(imgFile.toString(), Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);

        Mat dst = new Mat();

//        Imgproc.adaptiveThreshold(src, dst, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY, 13, 5);
        Imgcodecs.imwrite(dest + "/AdaptiveThreshold" + imgFile.getName(), dst);
    }
}

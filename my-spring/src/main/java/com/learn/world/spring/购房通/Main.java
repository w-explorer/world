package com.learn.world.spring.购房通;

import org.apache.commons.codec.digest.DigestUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

/**
 * @author wencheng
 * @create 2022/2/20 9:23
 */
public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {

//        String filepath = "C:\\Users\\86135\\Desktop\\temp\\购房通\\quiz5-tobe.png";
        String filepath = "C:\\Users\\86135\\Desktop\\temp\\购房通\\2.png";
        int[][] imageGRB = getImageGRB(filepath);
        StringBuffer goalBuffer = new StringBuffer();
        forDebug(imageGRB);


        for (int[] a : imageGRB) {
            int count =0;
            StringBuffer buffer = new StringBuffer();
            for (int b : a) {
                buffer.append(b);
                count++;
                if(count%8==0){
                    char c = (char)Integer.parseInt(buffer.toString(), 2);
                    goalBuffer.append(c);
                    buffer = new StringBuffer();
                }
            }
            goalBuffer.append("\n");
        }

        // ISO8859-1:ASCII的扩充，可以编码一些较为生僻的拉丁字符
        System.out.println(new String(goalBuffer.toString().getBytes("ISO8859-1"),"UTF-8"));

        System.out.println("校验和:"+DigestUtils.md5Hex(goalBuffer.toString()));

    }

    public static long getCRC32Checksum(byte[] bytes) {
        Checksum crc32 = new CRC32();
        crc32.update(bytes, 0, bytes.length);
        return crc32.getValue();
    }

    private static void forDebug(int[][] imageGRB) {
        //比特流数组
        for (int[] a : imageGRB) {
            for (int b : a) {
                System.out.print(b);
            }
            System.out.println();
        }


        //二进制数组
        for (int[] a : imageGRB) {
            int count =0;
            StringBuffer buffer = new StringBuffer();
            for (int b : a) {
                buffer.append(b);
                count++;
                if(count%8==0){
                    System.out.print(Integer.parseInt(buffer.toString(),2)+" ");
                    buffer = new StringBuffer();
                }
            }
            System.out.println();
        }
    }

    /**
     * 获取图片像素点数组
     * @param filePath
     * @return
     */
    public static int[][] getImageGRB(String filePath) {
        File file = new File(filePath);
        int[][] result = null;
        if (!file.exists()) {
            return null;
        }
        try {
            BufferedImage bufImg = ImageIO.read(file);
            int height = bufImg.getHeight();
            int width = bufImg.getWidth();
            result = new int[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    //使用getRGB(i,j)获取的该点的颜色值是ARGB，而在实际应用中使用的是RGB，所以需要将ARGB转化成RGB，即bufImg.getRGB(i, j) & 0xFFFFFF
                    //十进制代码颜色 ：白色  16777215  黑色 0
                    result[i][j] = (bufImg.getRGB(j, i) & 0xFFFFFF) == 0?1:0;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }

}

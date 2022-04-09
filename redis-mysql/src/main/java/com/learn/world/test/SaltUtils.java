package com.learn.world.test;

import java.security.SecureRandom;
import java.util.Random;

/**
 * @author 86135
 */
public class SaltUtils {
    public static String getSalt(int n){
        char[] chars = ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz" +
                "1234567890").toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            //Random().nextInt()返回值为[0,n)
            char aChar = chars[new Random().nextInt(chars.length)];
            sb.append(aChar);
        }
        return sb.toString();
    }
    /**
     * 获取16进制随机数
     * @param len
     * @return
     */
    public static String randomHexString(int len)  {
        StringBuffer result = new StringBuffer();
        for(int i=0;i<len;i++) {
            result.append(Integer.toHexString(new Random().nextInt(16)));
        }
        return result.toString().toUpperCase();
    }

    public static String getSecureRandom(int n) {
        byte[] vls = new byte[n/2];
        SecureRandom random = new SecureRandom();
        random.nextBytes(vls);
        return hexEncode(vls);
    }

    /**
     * @param aInput
     * @return
     */
    private static String hexEncode(byte[] aInput) {
        StringBuilder result = new StringBuilder();
        char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
                'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        for (byte b : aInput) {
            result.append(digits[(b & 0xf0) >> 4]);
            result.append(digits[b & 0x0f]);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String secureRandom = getSecureRandom(32);
        System.out.println(secureRandom);
        System.out.println(secureRandom.length());
    }
}

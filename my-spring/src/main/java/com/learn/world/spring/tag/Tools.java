package com.learn.world.spring.tag;

/**
 * @author wencheng
 * @create 2022/4/24 14:04
 */
public class Tools {

    /**
     * <p>
     * isNotNull.
     * </p>
     *
     * @param str a {@link String} object.
     * @return a boolean.
     */
    public static boolean isNotNull(String str) {
        return str != null && !"".equals(str.trim());
    }
}

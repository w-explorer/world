/*
 *
 * Copyright 2014 CDSF Corporation, Inc. All rights reserved.
 */
package com.learn.world.spring.test;

/**
 * <p>
 * Title: Tools.java
 * </p>
 * <p>
 * Description: 工具类
 * </p>
 * <p>
 * Copyright:Copyright(c)2014
 * </p>
 * <p>
 * Company: 成都四方
 * </p>
 * <p>
 * CreateTime:Jun 16, 2014 2:28:00 PM
 * </p>
 *
 * @author wangshuang
 * @version 1.0
 */
public final class Tools {


	private Tools(){
		
	}
	/**
	 * 获取字段展示名，规则：中文名(英文名) | 英文名
	 * @param fieldCode 字段英文名
	 * @param fieldName 字段中文名
	 * @return
	 */
	public static String getFieldShowName(String fieldCode, String fieldName) {
		return Tools.isNull(fieldName) ? fieldCode : fieldName + "(" + fieldCode + ")";
	}

	/**
	 * <p>isNull.</p>
	 *
	 * @param str a {@link String} object.
	 * @return a boolean.
	 */
	public static boolean isNull(String str) {
		return str == null || "".equals(str.trim());
	}

}

package com.yfhl.util;

import java.io.UnsupportedEncodingException;

public class StringChangeCode {
	
	/**
	 * get传参 中文转码
	 * @param s 转码之前的中文
	 * @return 转码之后的中文
	 */
	public static String getNewString (String s) {
		String newString ="";
		try {
			if(s != null){
				newString=new String(s.getBytes("iso-8859-1"),"utf-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return newString;
	}
}

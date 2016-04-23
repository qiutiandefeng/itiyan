package com.yfhl.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Expand;

/**
 * 
 * @author MAjb
 *解压文件
 */
public class DeCompressUtil {
	/**
	 * 解压缩文件
	 * @param sourceFile 压缩文件绝对路径
	 * @param destDir 解压目录，解压后的文件将会放入此目录中，请使用绝对路径
	 * 只支持zip和rar格式的压缩包！ 
	 * @throws Exception
	 */
	public static void deCompress(String sourceFile, String destDir)
			throws Exception {
		// 保证文件夹路径最后是"/"或者"\"
		char lastChar = destDir.charAt(destDir.length() - 1);
		if (lastChar != '/' && lastChar != '\\') {
			destDir += File.separator;
		}
		// 根据类型，进行相应的解压缩
		String type = sourceFile.substring(sourceFile.lastIndexOf(".") + 1);
		if (type.toLowerCase().equals("zip")) {
			DeCompressUtil.unzip(sourceFile, destDir);
		}  else {
			throw new Exception("只支持zip格式的压缩包！");
		}
	}
	
	/**
	 * 解压zip格式压缩包 
	 * 对应的是ant.jar
	 */
	private static void unzip(String sourceZip, String destDir)
			throws Exception {
		try {
			Project p = new Project();
			Expand e = new Expand();
			e.setProject(p);
			e.setSrc(new File(sourceZip));
			e.setOverwrite(false);
			e.setDest(new File(destDir));
			/*
			 * ant下的zip工具默认压缩编码为UTF-8编码， 而winRAR软件压缩是用的windows默认的GBK或者GB2312编码
			 * 所以解压缩时要制定编码格式
			 */
			e.setEncoding("utf-8");
			e.execute();
		} catch (Exception e) {
			throw e;
		}
	}


	
	/**
	 * 判断是否为中文
	 * @param str
	 * @return
	 */
	public static boolean existZH(String str) {
		String regEx = "[\\u4e00-\\u9fa5]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		while (m.find()) {
			return true;
		}
		return false;
	}

}

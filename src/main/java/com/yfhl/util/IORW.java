package com.yfhl.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;

public class IORW {

	public static void write(String str){
		FileOutputStream fos=null;
		
		try {
			fos = new FileOutputStream("E:\\log\\"+StringUtil.getTitleNO()+".txt",true);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//创建一个Hello.txt文本文件在F盘，也可以自己随便设定，文件名字true表示可以追加写入 
		 PrintStream ps = new PrintStream(fos); 
		 System.setOut(ps);//System 是 java.lang包里的，将流做转向，即将下面要往控制台输出的转向到写入到文件中 
		 System.out.println(str);//把控制台得到的数据写入文件 
		
	}
	public static void main(String[] args) {
		String mess="我是个好人";
		write(mess);
	}
}

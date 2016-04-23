package com.yfhl.util;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

/**
 *@Description:
 *
 *@version:v1.0
 *@author:shaowen
 */
public class IOWrite {
	
	 public static void write(String path,String content){
		 BufferedWriter bufw = null; 
		 try {
			 bufw = new BufferedWriter(new FileWriter(path,true));
			//将读取到缓冲区的数据通过line存入写入流中  
             bufw.write(content);  
             //换行符方法  
             bufw.newLine();  
             //将数据刷新到指定文件中  
             bufw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(bufw != null){
				try {
					bufw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	 }
}

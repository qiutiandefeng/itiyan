package com.yfhl.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IO {

	 public static String readerFile(String path)
	 {
		 
		 File file = new File(path);
		 
	  StringBuffer sb = new StringBuffer();
	  if (file.isFile())
	  {
	   FileInputStream fileInputStream = null;
	   try
	   {
	    fileInputStream = new FileInputStream(file);
	    // fileInputStream.available()获取文件的字节数
	    byte[] b = new byte[fileInputStream.available()];
	    int read = fileInputStream.read(b);
	    while (read != -1)
	    {
	     sb.append(new String(b));
	     read = fileInputStream.read(b);
	    }
	   } catch (FileNotFoundException e)
	   {
	    e.printStackTrace();
	   } catch (IOException e)
	   {
	    e.printStackTrace();
	   } finally
	   {
	    try
	    {
	     fileInputStream.close();
	    } catch (IOException e)
	    {
	     e.printStackTrace();
	    }
	   }
	   return sb.toString();
	  }
	  return null;
	 }
}

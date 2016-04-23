package com.yfhl.util;

import java.io.File;

public class Rename {

	public static void reName(String path, String from, String to) {  
	    File f = new File(path);  
	    
	      if (f.isDirectory()) {  
	        reName(f.getPath(), from, to);  
	      } else {  
	        String name = f.getName();  
	        if (name.endsWith(from)) {  
	          f.renameTo(new File(f.getParent() + "/" + name.substring(0, name.indexOf(from)) + to));  
	        }  
	      } 
	  }
	
	public static void main(String[] args) {
		String url="H:\\apache-tomcat-7.0.57\\webapps\\examSystem\\tempaa\\5.tq";
		reName(url, "tq", "zip");
	}
}

package com.yfhl.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author 作者 Chris li E-mail: lj520212@gmail.com
 * @version 创建时间：2015年11月12日 下午2:37:09
 * 类说明
 */
public class SystemProperties {
	
	static Properties props=System.getProperties(); //系统属性
	
	/**
	 * Java的运行环境版本
	 * @author Chris li
	 */
	public static String JAVA_VERSION = props.getProperty("java.version");
	
	/**
	 * Java的运行环境供应商
	 * @author Chris li
	 */
	public static String JAVA_VENDOR = props.getProperty("java.vendor");
	
	/**
	 * Java供应商的URL
	 * @author Chris li	
	 */
	public static String JAVA_VENDOR_URL = props.getProperty("java.vendor.url");
	
	/**
	 * Java的安装路径
	 * @author Chris li
	 */
	public static String JAVA_HOME = props.getProperty("java.home");
	
	/**
	 * Java的虚拟机规范版本
	 * @author Chris li
	 */
	public static String JAVA_VM_SPECIFICATION_VERSION = props.getProperty("java.vm.specification.version");
	
	/**
	 * /Java的虚拟机规范版本
	 * @author Chris li
	 */
	public static String JAVA_VM_SPECIFICATION_VENDOR = props.getProperty("java.vm.specification.vendor");
	
	/**
	 * /Java的虚拟机规范版本
	 * @author Chris li
	 */
	public static String JAVA_VM_SPECIFICATION_NAME = props.getProperty("java.vm.specification.name");
	
	/**
	 * Java的虚拟机实现版本
	 * @author Chris li
	 */
	public static String JAVA_VM_VERSION = props.getProperty("java.vm.version");
	
	/**
	 * Java的虚拟机实现供应商
	 * @author Chris li
	 */
	public static String JAVA_VM_VENDOR = props.getProperty("java.vm.vendor");
	
	/**
	 * Java的虚拟机实现名称
	 * @author Chris li
	 */
	public static String JAVA_VM_NAME = props.getProperty("jjava.vm.name");
	
	/**
	 * Java运行时环境规范版本
	 * @author Chris li
	 * 
	 */
	public static String JAVA_SPECIFICATION_VERSION = props.getProperty("java.specification.version");
	
	/**
	 * Java运行时环境规范供应商
	 * @author Chris li
	 */
	public static String JAVA_SPECIFICATION_VENDOR = props.getProperty("java.specification.vender");
	
	/**
	 * Java运行时环境规范名称
	 * @author Chris li
	 */
	public static String JAVA_SPECIFICATION_NAME = props.getProperty("java.specification.name");
	
	/**
	 * Java的类格式版本号
	 * @author Chris li
	 */
	public static String JAVA_CLASS_VERSION = props.getProperty("java.class.version");
	
	/**
	 * Java的类路径
	 * @author Chris li
	 * 
	 */
	public static String JAVA_CLASS_PATH = props.getProperty("java.class.path");
	
	/**
	 * 加载库时搜索的路径列表
	 * @author Chris li
	 */
	public static String JAVA_LIBRARY_PATH = props.getProperty("java.library.path");
	
	/**
	 * 默认的临时文件路径
	 * @author Chris li
	 */
	public static String JAVA_IO_TMPDIR = props.getProperty("java.io.tmpdir");
	
	/**
	 * 一个或多个扩展目录的路径
	 * @author Chris li
	 */
	public static String JAVA_EXT_DIRS = props.getProperty("java.ext.dirs");
	
	/**
	 * 操作系统的名称
	 * @author Chris li
	 */
	public static String OS_NAME = props.getProperty("os.name");
	
	/**
	 * 操作系统的构架
	 * @author Chris li
	 */
	public static String OS_ARCH = props.getProperty("os.arch");
	
	/**
	 * 操作系统的版本
	 * @author Chris li
	 */
	public static String OS_VERSION = props.getProperty("os.version");
	
	/**
	 * 文件分隔符
	 * @author Chris li
	 */
	public static String FILE_SEPARATOR = props.getProperty("file.separator");
	
	/***
	 * 路径分隔符
	 * @author Chris li
	 */
	public static String PATH_SEPARATOR = props.getProperty("path.separator");
	
	/**
	 * 行分隔符
	 * @author Chris li
	 */
	public static String LINE_SEPARATOR = props.getProperty("line.separator");
	
	/**
	 * 用户的账户名称
	 * @author Chris li
	 */
	public static String USER_NAME = props.getProperty("user.name");
	
	/**
	 * 用户的主目录
	 * @author Chris li
	 */
	public static String USER_HOME = props.getProperty("user.home");
	
	/**
	 * @author Chris li
	 */
	public static String USER_DIR = props.getProperty("name.dir");
	
	public static  String MYSQL_URL;    
	public static  String MYSQL_USER;
	public static  String MYSQL_PWD;
	public static  String MYSQL_DRIERCLASS;
	//数据库
//	static  {    
//        Properties prop =  new  Properties();    
//        InputStream in = Object. class .getResourceAsStream( "//property/init.properties" );    
//         try  {    
//            prop.load(in);    
//            MYSQL_DRIERCLASS = prop.getProperty( "jdbc.dbcp.dataSource.driverClassName" ).trim();
//            MYSQL_URL = prop.getProperty( "jdbc.dbcp.dataSource.url" ).trim();    
//            MYSQL_USER = prop.getProperty( "jdbc.dbcp.dataSource.username" ).trim();    
//            MYSQL_PWD = prop.getProperty( "jdbc.dbcp.dataSource.password" ).trim();
//            
//         }  catch  (IOException e) {    
//            e.printStackTrace();    
//        }    
//    } 
	
	public static void main(String args[])
	{
		
//		Set<Object> keySet = sysProperty.keySet();
	//  for (Object object : keySet) {
	//   String property = sysProperty.getProperty(object.toString());
	//   System.out.println(object.toString()+" : "+property);
	//  }
		
		Map<String, String> getenv = System.getenv();
		
		   System.out.println("Java的运行环境版本："+props.getProperty("java.version"));
		   System.out.println("Java的运行环境供应商："+props.getProperty("java.vendor"));
		   System.out.println("Java供应商的URL："+props.getProperty("java.vendor.url"));
		   System.out.println("Java的安装路径："+props.getProperty("java.home"));
		   System.out.println("Java的虚拟机规范版本："+props.getProperty("java.vm.specification.version"));
		   System.out.println("Java的虚拟机规范供应商："+props.getProperty("java.vm.specification.vendor"));
		   System.out.println("Java的虚拟机规范名称："+props.getProperty("java.vm.specification.name"));
		   System.out.println("Java的虚拟机实现版本："+props.getProperty("java.vm.version"));
		   System.out.println("Java的虚拟机实现供应商："+props.getProperty("java.vm.vendor"));
		   System.out.println("Java的虚拟机实现名称："+props.getProperty("java.vm.name"));
		   System.out.println("Java运行时环境规范版本："+props.getProperty("java.specification.version"));
		   System.out.println("Java运行时环境规范供应商："+props.getProperty("java.specification.vender"));
		   System.out.println("Java运行时环境规范名称："+props.getProperty("java.specification.name"));
		   System.out.println("Java的类格式版本号："+props.getProperty("java.class.version"));
		   System.out.println("Java的类路径："+props.getProperty("java.class.path"));
		   System.out.println("加载库时搜索的路径列表："+props.getProperty("java.library.path"));
		   System.out.println("默认的临时文件路径："+props.getProperty("java.io.tmpdir"));
		   System.out.println("一个或多个扩展目录的路径："+props.getProperty("java.ext.dirs"));
		   System.out.println("操作系统的名称："+props.getProperty("os.name"));
		   System.out.println("操作系统的构架："+props.getProperty("os.arch"));
		   System.out.println("操作系统的版本："+props.getProperty("os.version"));
		   System.out.println("文件分隔符："+props.getProperty("file.separator"));   //在 unix 系统中是＂／＂
		   System.out.println("路径分隔符："+props.getProperty("path.separator"));   //在 unix 系统中是＂:＂
		   System.out.println("行分隔符："+props.getProperty("line.separator"));   //在 unix 系统中是＂/n＂
		   System.out.println("用户的账户名称："+props.getProperty("user.name"));
		   System.out.println("用户的主目录："+props.getProperty("user.home"));
		   System.out.println("用户的当前工作目录："+props.getProperty("user.dir"));
	}
}

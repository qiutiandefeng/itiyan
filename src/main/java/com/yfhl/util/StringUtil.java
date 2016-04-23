package com.yfhl.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * 
 * 
 * @Description string工具类.
 */
public class StringUtil {
    
    /**
     * 
     * @Description 判断对象是否为空
     */
    public static boolean isEmpty(Object object) {
        return object == null || "".equals(object);
    }
    
    /**
     * 
     * @Description 判断对象是否不为空
     */
    public static boolean isNotEmpty(Object object) {
        return object != null && !"".equals(object);
    }
    /**
     * 生成string类型的题号
     * @author MAjb
     */
    public static String getTitleNO(){
    	//method 1  
        Calendar nowtime = new GregorianCalendar();  
        String strDateTime=String.format("%04d", nowtime.get(Calendar.YEAR))+  
                String.format("%02d", nowtime.get(Calendar.MONTH)) +  
                String.format("%02d", nowtime.get(Calendar.DATE)) +  
                String.format("%02d", nowtime.get(Calendar.HOUR)) +  
                String.format("%02d", nowtime.get(Calendar.MINUTE)) +  
                String.format("%02d", nowtime.get(Calendar.SECOND)) +  
                String.format("%03d", nowtime.get(Calendar.MILLISECOND));  
        //System.out.println(strDateTime);  
          
     
        String msg="";  
        Date date = new Date();  
        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmss");  
        msg+=sdf.format(date);  
        System.out.println(msg);  
    	return msg;
    }
    
    public static String arrayToString(String[] arr){
    	  String res="";
    	  for (String i:arr) {
    	   res+=i+"->";
    	  }
    	  return res.substring(0,res.length()-2);
    	 }
    public static void main(String[] args) {
    	String s = getTitleNO();
    	System.out.println("s="+s);
	}
   
}

package com.yfhl.interceptor;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.yfhl.util.IOWrite;
import com.yfhl.util.StringDateTool;

/**
 *@Description:处理异常
 *
 *@version:v1.0
 *@author:shaowen
 */
public class ExceptionHandler implements HandlerExceptionResolver  {

	
    public ModelAndView resolveException(HttpServletRequest request,  
            HttpServletResponse response, Object handler, Exception ex) {  

    	String serverUrl = request.getSession().getServletContext().getRealPath("/");
    	//serverUrl=serverUrl.replaceAll("\\", "\\\\");
    	String path = serverUrl+"exceptionInfo.txt";
    	// 获取当前时间
    	Date date = new Date();
    	String time = StringDateTool.date2Str(date,"yyyy-MM-dd HH:mm:ss");
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		String content = time+"\r\n"+sw.toString();
		IOWrite.write(path,content);
    	return new ModelAndView("exception/error");  
    }  
}

package com.yfhl.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;






public class ContextUtil {

    
    /**
     * @Description 得到request
     * @return
     */
    public static HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    /** 
     * @Description 得到session
     * @return
     */
    public static HttpSession getSession() {
        HttpSession session = getRequest().getSession();
        return session;
    }
 
    /**
     * 
     * @Description 从session中取得登录用�?
     * @return
     */
    public static Object getUser() {
    	Object user = getSession().getAttribute("user");
        return user;
    }
}

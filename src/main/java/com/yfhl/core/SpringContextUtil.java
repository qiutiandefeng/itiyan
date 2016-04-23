package com.yfhl.core;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author Chris li E-mail:lj520212@gmail.com
 * @version 创建时间：2015年12月9日 下午9:44:41
 * 类说明
 */
public class SpringContextUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext; // Spring应用上下文环境
	 
    // 下面的这个方法上加了@Override注解，原因是继承ApplicationContextAware接口是必须实现的方法
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }
 
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
 
    public static Object getBean(String name) throws BeansException {
        return applicationContext.getBean(name);
    }
 
    public static Object getBean(String name, Class requiredType)
            throws BeansException {
        return applicationContext.getBean(name, requiredType);
    }
 
    public static boolean containsBean(String name) {
        return applicationContext.containsBean(name);
    }
 
    public static boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
        return applicationContext.isSingleton(name);
    }
 
    public static Class getType(String name)    throws NoSuchBeanDefinitionException {
        return applicationContext.getType(name);
    }
 
    public static String[] getAliases(String name) throws NoSuchBeanDefinitionException {
        return applicationContext.getAliases(name);
    }
}
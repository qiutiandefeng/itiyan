package com.yfhl.util;

import java.util.Date;

/** 
 * 缓存实体 
 *  
 * @author home 
 * 
 * @param <T> 
 */  
public class LastCache<T> {  
      
    /** 
     * 上次缓存的数据 
     */  
    private T data;  
      
    /** 
     * 最后刷新时间 
     */  
    private long refreshtime;  
      
    public LastCache(T data) {  
        this(data, new Date().getTime());  
    }  
      
    public LastCache(T data, long refreshtime) {  
        this.data = data;  
        this.refreshtime = refreshtime;  
    }  
      
    public T getData() {  
        return data;  
    }  
      
    public void setData(T data) {  
        this.data = data;  
    }  
      
    public long getRefreshtime() {  
        return refreshtime;  
    }  
      
    public void setRefreshtime(long refreshtime) {  
        this.refreshtime = refreshtime;  
    }  
}  

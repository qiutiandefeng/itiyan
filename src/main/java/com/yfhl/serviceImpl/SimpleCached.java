package com.yfhl.serviceImpl;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.yfhl.service.CacheService;
import com.yfhl.util.LastCache;

/** 
 * 简单的缓存模型 
 *  
 * @author home 
 * 
 * @param <T> 
 */  

@Service
public class SimpleCached<T> implements CacheService<T> {  
  
    /** 
     * 缓存数据索引 
     */  
    private Map<String, LastCache<T>> cache = new ConcurrentHashMap<String, LastCache<T>>();  
      
    /** 
     * 缓存超时时间，单位：毫秒 
     */  
    private Long expired = 0L;  
      
    public SimpleCached() {  
        this(5 * 1000 * 6L);  
    }  
      
    public SimpleCached(Long expired) {  
        this.expired = expired;  
    }  
  
    public void refresh(String key, T target) {  
        if (cache.containsKey(key)) {  
            cache.remove(key);  
        }  
        cache.put(key, new LastCache<T>(target));  
    }  
  
    public T getCache(String key) {  
        if (!this.exist(key)) {  
            return null;  
        }  
          
        return cache.get(key).getData();  
    }  
  
    public Boolean isExpired(String key) {  
        if (!this.exist(key)) {  
            return null;  
        }  
          
        long currtime = new Date().getTime();  
        long lasttime = cache.get(key).getRefreshtime();  
          
        return (currtime - lasttime) > expired;  
    }  
  
    public void setExpired(Long millsec) {  
        this.expired = millsec;  
    }  
  
    public Boolean exist(String key) {  
        return cache.containsKey(key);  
    }  
      
}  

package com.yfhl.log4j;

import org.apache.log4j.Priority;
import org.apache.log4j.RollingFileAppender;

/**
 * 
 *
 * @Description 每天生成新文件,该类继承RollingFileAppender,将不同等级的Log日志文件记录到不同目录下
 *                  
 *                  
 *                  
 * @Review (审核人)
 */
public class MyRollingFileAppender extends RollingFileAppender {
    
    public boolean isAsSevereAsThreshold(Priority priority) {
        // 只判断是否相等，而不判断优先级
        return this.getThreshold().equals(priority);
    }
}
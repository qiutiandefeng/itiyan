package com.yfhl.log4j;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Priority;

/**
 * 
 *
 * @Description  每天生成新文件,该类继承DailyRollingFileAppender,将不同等级的Log日志文件记录到不同目录下
 *                  
 */
public class MyDailyRollingFileAppender extends DailyRollingFileAppender {
    
    public boolean isAsSevereAsThreshold(Priority priority) {
        // 只判断是否相等，而不判断优先级
        return this.getThreshold().equals(priority);
    }
}
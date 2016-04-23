package com.yfhl.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 作者 Chris li E-mail: lj520212@gmail.com
 * @version 创建时间：2015年11月12日 上午11:14:32
 * 类说明
 */
public class CustomDateUtil {
	
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
     * 根据日期获得所在周的日期 
     * @param mdate
     * @return
     */
    @SuppressWarnings("deprecation")
    public static List<Date> dateToWeek(Date mdate) {
        int b = mdate.getDay();
        Date fdate;
        List<Date> list = new ArrayList<Date>();
        Long fTime = mdate.getTime() - b * 24 * 3600000;
        for (int a = 1; a <= 7; a++) {
            fdate = new Date();
            fdate.setTime(fTime + (a * 24 * 3600000));
            list.add(a-1, fdate);
        }
        return list;
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        // 定义输出日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd EEE");
         
        Date currentDate = new Date();
         
        // 比如今天是2012-12-25
        List<Date> days = dateToWeek(currentDate);
        System.out.println("今天的日期: " + sdf.format(currentDate));
        for (Date date : days) {
            System.out.println(sdf.format(date));
        }
    }
}

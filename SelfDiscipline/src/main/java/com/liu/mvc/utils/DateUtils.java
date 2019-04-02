package com.liu.mvc.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	 /**
     * 计算时差，HH：mm
     * @param str1 时间参数 1 格式：1990-01-01 12:00:00
     * @param str2 时间参数 2 格式：2009-01-01 12:00:00
     * @return String 返回值为：xx天xx小时xx分xx秒
     */
    public static String gettimeDifference(String str1, String str2) {
    	  String format="HH:mm";
    	  String time="";
    	try {
			Date	date = new SimpleDateFormat(format).parse(str1);
			Date	date2 = new SimpleDateFormat(format).parse(str2);
			//System.out.println(date2.getTime()-date.getTime());
		    long a =date2.getTime()-date.getTime();
		    long t = (a/1000/60);
		    time = String.valueOf(t);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
       return time;
    }
    
    
    /**
     * 
     * 获取当前时间字符串
     */
    public static String getNewTime() {
    	 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		
       return df.format(new Date());
    }
    

}

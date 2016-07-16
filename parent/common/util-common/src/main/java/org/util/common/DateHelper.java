package org.util.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DateHelper {
	private static final Logger logger = LoggerFactory.getLogger(DateHelper.class);

	private static final String FORMAT_TIMESTAMP = "yyyy-MM-dd HH:mm:ss.SSS";
	private static final String order_TIMESTAMP = "yyyyMMddHHmmssSSS";
	private static final String FORMAT_TIME = "yyyy-MM-dd HH:mm:ss";
	private static final String TENCENT_TIME = "yyyy-MM-dd";
	private static final String TENCENT_TIME_DOT = "yyyy.MM.dd";

	public static String toTime(Date date){
		return new SimpleDateFormat(FORMAT_TIME).format(date.getTime());
	} 

	public static String toTimestamp(Date date){
		return new SimpleDateFormat(FORMAT_TIMESTAMP).format(date.getTime());
	}
	
	public static String toOrderNumber(Date date){
		return new SimpleDateFormat(order_TIMESTAMP).format(date.getTime());
	}
	
	public static String toTencent(Date date){
		return new SimpleDateFormat(TENCENT_TIME).format(date.getTime());
	}
	
	public static String toTencentDot(Date date){
		return new SimpleDateFormat(TENCENT_TIME_DOT).format(date.getTime());
	}
	
	public static String toDate(Calendar date){
		return new SimpleDateFormat("yyyy-MM-dd").format(date.getTime());
	}
	
	public static String toYYMMDD(Calendar date) {
		return new SimpleDateFormat("yyMMdd").format(date.getTime());
	}
	
	public static String toYYYY_MM_DD(Calendar date) {
		return new SimpleDateFormat("yyyy-MM-dd").format(date.getTime());
	}

	public static Calendar toCalnedar(Date date){
		Calendar result = Calendar.getInstance();
		result.setTime(date);
		return result;
	}

	/**
	 * 返回此日期的零点整，如2007-3-14 19:00:35 返回 2007-3-14 00:00:00
	 * 
	 * @param date
	 */
	public static Calendar getTheDayZero(Calendar date) {
		Calendar result = (Calendar) date.clone();
		result.set(Calendar.HOUR_OF_DAY, 0);
		result.set(Calendar.MINUTE, 0);
		result.set(Calendar.SECOND, 0);
		result.set(Calendar.MILLISECOND, 0);
		return result;
	}
	
	/**
	 * 返回此日期的午夜，如2007-3-14 19:00:35 返回 2007-3-14 23:59:59
	 * 
	 * @param date
	 */
	public static Calendar getTheDayMidnight(Calendar date) {
		Calendar result = (Calendar) date.clone();
		result.set(Calendar.HOUR_OF_DAY, 23);
		result.set(Calendar.MINUTE, 59);
		result.set(Calendar.SECOND, 59);
		result.set(Calendar.MILLISECOND, 999);
		return result;
	}
	
	public static String getBetw(Date beginDate,Date endDate){
		long beginTime = beginDate.getTime(); 
		long endTime = endDate.getTime(); 
		long betweenDays = (long)((endTime - beginTime));
		return (betweenDays/1000)+"";
		//return new SimpleDateFormat(FORMAT_TIME).format(betweenDays);
	}
	
	 /**
     * 解析日期与时间
     */
    public static Date parseDatetime(String str) {
        Date date = null;
        try {
            date = new SimpleDateFormat(FORMAT_TIME).parse(str);
        } catch (ParseException e) {
            logger.error("解析日期字符串出错！格式：yyyy-MM-dd HH:mm:ss", e);
        }
        return date;
    }

    /**
     * 解析日期
     */
    public static Date parseDate(String str) {
        Date date = null;
        try {
            date = new SimpleDateFormat(TENCENT_TIME).parse(str);
        } catch (ParseException e) {
            logger.error("解析日期字符串出错！格式：yyyy-MM-dd", e);
        }
        return date;
    }

    /**
     * 解析时间(年)
     */
    public static Date parseTime(String str) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy").parse(str);
        } catch (ParseException e) {
            logger.error("解析日期字符串出错！格式：HH:mm:ss", e);
        }
        return date;
    }

}

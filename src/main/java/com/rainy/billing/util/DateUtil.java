package com.rainy.billing.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/***
 * 
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 *
 * @2011-10-20
 * @author rainy
 * @version 1.0
 */
public final class DateUtil {

    /**
     * default date format pattern
     */
    public final static String DATE_FORMAT = "yyyy-MM-dd";
    public final static String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm";
    public final static String FULL_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public final static String TIME_FORMAT = "HH:mm";
    public final static String MONTH_DAY_HOUR_MINUTE_FORMAT = "MM-dd HH:mm";
    public final static String LOCATE_DATE_FORMAT = "yyyyMMddHHmmss";
    
    private static final int DAYS_OF_A_WEEK = 7;

    private DateUtil() {
    }

    /**
     * parse date with the default pattern
     * 
     * @param date string date
     * @return the parsed date
     */
    public static Date parseDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
        try {
            return format.parse(date);
        } catch (ParseException e) {
            return new Date();
        }
    }

    public static Date parseDate(String date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            return format.parse(date);
        } catch (ParseException e) {
            return new Date();
        }
    }

    /**
     * 获取增加小时后的 Date
     * 
     * @param date
     * @param i
     * @return squall add 20100225
     */
    public static Date addHour(Date date, int i) {
        Calendar calendar = getDefaultCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, i);
        return calendar.getTime();
    }

    /**
     * format date with the default pattern
     * 
     * @param date the date that want to format to string
     * @return the formated date
     */
    public static String formatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
        return format.format(date);
    }
    
    public static String formatCurrentDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        
        return format.format(new Date());
    }

    public static String formatTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(TIME_FORMAT);
        return format.format(date);
    }
    
    public static String formatDateTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(FULL_DATE_TIME_FORMAT);
        return format.format(date);
    }

    /**
     * format date with the given pattern
     * 
     * @param date the date that want to format to string
     * @param pattern the formated pattern
     * @return the formated date
     */
    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    /**
     * get current date
     * 
     * @return the string of current date
     */
    public static String getCurrentDateFormat() {
        return formatDate(new Date());
    }

    /**
     * get number of days between the two given date
     * 
     * @param fromDate the begin date
     * @param endDate the end date
     * @return the number of days between the two date
     */
    public static int getDateNum(Date fromDate, Date endDate) {
        long days = (endDate.getTime() - fromDate.getTime()) / (1000 * 60 * 60 * 24);
        return (int) days;
    }

    /**
     * add day to the date
     * 
     * @param date the added date
     * @param number the number to add to the date
     * @return the added date
     */
    public static Date addDate(Date date, int number) {
        Calendar calendar = getDefaultCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, number);
        return calendar.getTime();
    }
    
    public static Date addMonth(Date date, int number) {
        Calendar calendar = getDefaultCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, number);
        return calendar.getTime();
    }

    /**
     * get the default calendar
     * 
     * @return the calendar instance
     */
    public static Calendar getDefaultCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        return calendar;
    }

    /**
     * format the date into string value
     * 
     * @param calendar the formated calendar
     * @return the string date
     */
    public static String getStringDate(Calendar calendar) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return year + "-" + getNiceString(month) + "-" + getNiceString(day);
    }

    /**
     * according to the pattern yyyy-MM-dd
     * 
     * @param value the value
     * @return the formated value
     */
    public static String getNiceString(int value) {
        String str = "00" + value;
        return str.substring(str.length() - 2, str.length());
    }

    /**
     * get calendar from date
     * 
     * @param date the passing date
     * @return the calendar instance
     */
    public static Calendar getCalendarFromDate(Date date) {
        Calendar calendar = getDefaultCalendar();
        calendar.setTime(date);
        return calendar;
    }

    public static String getInterval(Date startDate, Date endDate) {
        long intervalTime = endDate.getTime() - startDate.getTime();
        return getInterval(intervalTime);
    }
    
    /*public static void main(String a[]){
        Date d1 = parseDate("2010-10-10 10:10:20:10", FULL_DATE_TIME_FORMAT);
        Date d2 = parseDate("2010-10-10 11:20:10:00", FULL_DATE_TIME_FORMAT);
        String s = String.valueOf( getIntervalSecond(d1, d2));
        System.out.println(s);
    }*/
    
    public static int getIntervalMinute(Date startDate, Date endDate){
        long intervalTime = endDate.getTime() - startDate.getTime();
        return (int) (intervalTime / (1000 * 60));
    }

    public static String getInterval(long intervalTime) {
        int hour = (int) (intervalTime / (1000 * 60 * 60));
        int minute = (int) (intervalTime / (1000 * 60) - hour * 60);
        int second = (int) ((intervalTime / 1000) - hour * 60 * 60 - minute * 60);
        if (hour > 0) {
            return hour + "小时 " + minute + "分 " + second + "秒";
        } else if (minute > 0) {
            return minute + "分钟 " + second + "秒";
        } else {
            return second + "秒";
        }
    }

    public static int getYear(Date date) {
        Calendar calendar = getCalendarFromDate(date);
        return calendar.get(Calendar.YEAR);
    }

    public static int getMonth(Date date) {
        Calendar calendar = getCalendarFromDate(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    public static int getDayOfMonth(Date date) {
        Calendar calendar = getCalendarFromDate(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static int getHour(Date now) {
        Calendar calendar = getCalendarFromDate(now);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public static int getWeekOfYear(Date date) {
        Calendar calendar = getCalendarFromDate(date);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        return calendar.get(Calendar.WEEK_OF_YEAR) - 1;
    }

    public static Date getCurrentDate() {
        Calendar calendar = getCalendarFromDate(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static Date getNextDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getCurrentDate());
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();
    }
    
    /**
     * 一周的日期
     * @param date
     * @return
     */
    public static List<Date> getWeekDayOfYear(Date date) {
        Calendar calendar = getCalendarFromDate(date);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setMinimalDaysInFirstWeek(DAYS_OF_A_WEEK);
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        int year = calendar.get(Calendar.YEAR);

        List<Date> result = new ArrayList<Date>();
        result.add(getDateOfYearWeek(year, week, Calendar.MONDAY));
        result.add(getDateOfYearWeek(year, week, Calendar.TUESDAY));
        result.add(getDateOfYearWeek(year, week, Calendar.WEDNESDAY));
        result.add(getDateOfYearWeek(year, week, Calendar.THURSDAY));
        result.add(getDateOfYearWeek(year, week, Calendar.FRIDAY));
        result.add(getDateOfYearWeek(year, week, Calendar.SATURDAY));
        result.add(getDateOfYearWeek(year, week, Calendar.SUNDAY));
        return result;
    }

    /**
     * 获取一年中某周,星期几的日期
     * @param yearNum
     * @param weekNum
     * @param dayOfWeek
     * @return
     */
    private static Date getDateOfYearWeek(int yearNum, int weekNum, int dayOfWeek) {
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK, dayOfWeek);
        cal.setMinimalDaysInFirstWeek(DAYS_OF_A_WEEK);
        cal.set(Calendar.YEAR, yearNum);
        cal.set(Calendar.WEEK_OF_YEAR, weekNum);
        /*cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);*/
        return cal.getTime();
    }
    
    /**
     * 获取指定日期是一周的第几天,星期日是第一天
     * @param date
     * @return
     */
    public static int getDayOfWeek(Date date) {
        Calendar calendar = getCalendarFromDate(date);
        calendar.setMinimalDaysInFirstWeek(DAYS_OF_A_WEEK);
        return calendar.get(Calendar.DAY_OF_WEEK) - 1;
    }

    public static Date parseDateE(String date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            return format.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException("date pattern should be " + pattern);
        }
    }
    
    public static Date getDefaultDate() {
        Calendar calendar = getCalendarFromDate(new Date());
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }
    
    public static Date addSecond(Date date, int number) {
        Calendar calendar = getDefaultCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, number);
        return calendar.getTime();
    }

    /**
     * 清空日期的时间
     * @param createdAt
     * @return
     */
    public static Date clearTime(Date date) {
        Calendar calendar = getCalendarFromDate(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }
    
    public static boolean betweenHour(Date date, int hour) {
        Calendar calendar = getCalendarFromDate(date);
        calendar.add(Calendar.HOUR, hour);
        Calendar now = getDefaultCalendar();
        return calendar.after(now);
    }
    
    public static boolean betweenMinute(Date date, int minute) {
        Calendar calendar = getCalendarFromDate(date);
        calendar.add(Calendar.MINUTE, minute);
        Calendar now = getDefaultCalendar();
        return calendar.after(now);
    }
    
    public static String getYesterdayFormat() {
        Date date = addDate(new Date(), -1);
        return formatDate(date);
    }

    /**
     * 日期间隔天数
     * @param reportDate
     * @param signDate
     * @return
     */
    public static int getInternalDay(String endDate, String beginDate) {
        long intervalTime = parseDate(endDate).getTime() - parseDate(beginDate).getTime();
        return (int) (intervalTime / (1000 * 24 * 60 * 60));
    }

    /**
     * 获得当年
     * @return
     */
    public static String getCurrentYear() {
        Calendar calendar = getDefaultCalendar();
        return "" + calendar.get(Calendar.YEAR);
    }
    
    public static List<String> getYearRange(int fromYear, int toYear) {
        List<String> result = new ArrayList<String>();
        for (int i=0; i<=toYear-fromYear; i++) {
            result.add("" + (toYear - i));
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(betweenMinute(parseDate("2010-12-13 14:20", "yyyy-MM-dd HH:mm"), 30));
    }
    
    public static String getDateStr(int year, int month) {
    	if(month > 12) {
    		year++;
    		month = 1;
    	}
    	StringBuilder str = new StringBuilder();
    	str.append(year);
    	str.append("-");
    	if(String.valueOf(month).length() == 1) {
    		str.append("0");
    		
    	}
    	str.append(month);
    	str.append("-01");
    	
    	return str.toString();
    }
    
    /**
     * 对字符串日期进行加天数运算
     * @param date
     * @param number
     * @return
     */
    public static String addDate(String date, int number) {
    	Date addedDate = parseDate(date);
        Calendar calendar = getDefaultCalendar();
        calendar.setTime(addedDate);
        calendar.add(Calendar.DATE, number);
        return formatDate(calendar.getTime());
    }
    
}

package com.zlyg.purchase.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author justin
 * 日期处理工具类
 *
 */
public class DateUtils {

	public final static String DEFAULT_DATETIME= "yyyyMMddHHmmss";
	
	public final static String DEFAULT_DATETIME_FMT = "yyyy-MM-dd HH:mm:ss";
	
	public final static String DEFAULT_DATE_FMT = "yyyy-MM-dd";

	public static String datetimeToString(String fmt, Date date) {
		return new SimpleDateFormat(fmt).format(date);
	}
	
	public static Long datetimeToLong(){
		//return Long.valueOf(new SimpleDateFormat(DEFAULT_DATETIME).format(new Date()));
		return datetimeToLong(new Date());
	}
	
	public static Long datetimeToLong(Date date){
		return Long.valueOf(new SimpleDateFormat(DEFAULT_DATETIME).format(date));
	}

	public static String datetimeToString(Date date) {
		return datetimeToString(DEFAULT_DATETIME_FMT, date);
	}

	public static String dateToString(Date date) {
		return datetimeToString(DEFAULT_DATE_FMT, date);
	}

	public static Date getDateZeroTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return cal.getTime();
	}

	public static Date getDateMidnight(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		cal.set(Calendar.HOUR, 24);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return cal.getTime();
	}

	public static int getWeekNameOrd(String weekDay) {
		if ("SUNDAY".equals(weekDay.toUpperCase())) {

			return Calendar.SUNDAY;
		} else if ("MONDAY".equals(weekDay.toUpperCase())) {

			return Calendar.MONDAY;
		} else if ("TUESDAY".equals(weekDay.toUpperCase())) {

			return Calendar.TUESDAY;
		} else if ("THURSDAY".equals(weekDay.toUpperCase())) {

			return Calendar.THURSDAY;
		} else if ("WEDNESDAY".equals(weekDay.toUpperCase())) {

			return Calendar.WEDNESDAY;
		} else if ("FRIDAY".equals(weekDay.toUpperCase())) {

			return Calendar.FRIDAY;
		} else if ("SATURDAY".equals(weekDay.toUpperCase())) {

			return Calendar.SATURDAY;
		} else {
			return Calendar.SUNDAY;
		}

	}

	public static Date getDate(Integer hour, Integer minute, Integer second) {
		Calendar cal = Calendar.getInstance();

		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, minute);
		cal.set(Calendar.SECOND, second);

		return cal.getTime();
	}

	public static Date addDate(Date date, int num) {
		Calendar cal = Calendar.getInstance();

		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, num);

		return cal.getTime();
	}
	public static Date addMonth(Date date, int num) {
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(date);
		cal.add(Calendar.MONTH, num);
		
		return cal.getTime();
	}
	public static Date addHour(Date date, int num) {
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(date);
		cal.add(Calendar.HOUR, num);
		
		return cal.getTime();
	}
	public static Date addSecond(Date date, int num) {
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(date);
		cal.add(Calendar.SECOND, num);
		
		return cal.getTime();
	}
	// 当前时间与参数传进来的时间的相差间隔 单位为秒
	public static Long getInterval(Date date) {
		Calendar cal = Calendar.getInstance();

		Long interval = cal.getTime().getTime() - date.getTime();

		return (Long) (interval / 1000);
	}

	public static int getIntervalDays(Date startDay, Date endDay) {
		// 确保startDay在endDay之前
		if (startDay.after(endDay)) {
			Date cal = startDay;
			startDay = endDay;
			endDay = cal;
		}

		startDay = getDateZeroTime(startDay);
		endDay = getDateZeroTime(endDay);

		long intrval = startDay.getTime() - endDay.getTime();
		// 根据毫秒数计算间隔天数
		return (int) (intrval / (1000 * 60 * 60 * 24));
	}
	
	/**
	 * 获取两个日期间隔的天数，当前日期必须小于结束日期
	 * @param currentDay
	 * @param endDay
	 * @return
	 */
	public static int getIntervalDaysNu(Date currentDay, Date endDay) {
		if(currentDay.after(endDay)){
			return -1;
		}
		currentDay = getDateZeroTime(currentDay);
		endDay = getDateZeroTime(endDay);

		long intrval = endDay.getTime() - currentDay.getTime();
		// 根据毫秒数计算间隔天数
		return (int) (intrval / (1000 * 60 * 60 * 24));
	}

	/**
	 * 判断一个日期是否在开始日期和结束日期之间。
	 * 
	 * @param srcDate
	 *            目标日期 yyyy/MM/dd 或者 yyyy-MM-dd
	 * @param startDate
	 *            开始日期 yyyy/MM/dd 或者 yyyy-MM-dd
	 * @param endDate
	 *            结束日期 yyyy/MM/dd 或者 yyyy-MM-dd
	 * @return 大于等于开始日期小于等于结束日期，那么返回true，否则返回false
	 */
	public static boolean isInStartEnd(String srcDate, String startDate,
			String endDate) {
		if (startDate.compareTo(srcDate) <= 0
				&& endDate.compareTo(srcDate) >= 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断一个日期是否在开始日期和结束日期之间。
	 * 
	 * @param srcDate
	 *            目标日期 yyyy/MM/dd 或者 yyyy-MM-dd
	 * @param startDate
	 *            开始日期 yyyy/MM/dd 或者 yyyy-MM-dd
	 * @param endDate
	 *            结束日期 yyyy/MM/dd 或者 yyyy-MM-dd
	 * @return 大于等于开始日期小于等于结束日期，那么返回true，否则返回false
	 */
	public static boolean isInStartEnd(Date srcDate, Date startDate,
			Date endDate) {
		if (startDate.compareTo(srcDate) <= 0
				&& endDate.compareTo(srcDate) >= 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 将日历转换成给定格式的日期字符串
	 * 
	 * @param c
	 * @param formart
	 * @return
	 */
	public static String getDateTimeString(Calendar c, String formart) {
		SimpleDateFormat sdf = new SimpleDateFormat(formart);
		return sdf.format(c.getTime());
	}

	/**
	 * 得到今天的日期
	 * 
	 * @param formart
	 * @return
	 */
	public static String getCurrentDate(String formart) {
		return getDateTimeString(Calendar.getInstance(), formart);
	}

	/**
	 * 取得给定字符串描述的日期对象，描述模式采用pattern指定的格式.
	 * 
	 * @param dateStr
	 *            日期描述 从给定字符串的开始分析文本，以生成一个日期。该方法不使用给定字符串的整个文本。 有关日期分析的更多信息，请参阅
	 *            parse(String, ParsePosition) 方法。一个 String，应从其开始处进行分析
	 * 
	 * @param pattern
	 *            日期模式
	 * @return 给定字符串描述的日期对象。
	 */
	public static Date getDateFromString(String dateStr, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date resDate = null;
		try {
			resDate = sdf.parse(dateStr);
		} catch (Exception e) {
			// log.error(ExceptionUtils.getStackTrace(e));
		}
		return resDate;
	}

	/**
	 * 根据获取一个唯一的序列号,组成=System.currentTimeMillis()+六位纳秒级的数字字符串
	 */
	public static long getSerialNo() {
		String naonTime = String.valueOf(System.nanoTime());
		String suffix = naonTime.substring(naonTime.length() - 6,
				naonTime.length());
		return Long.parseLong(System.currentTimeMillis() + suffix);

	}

	/**
	 * 获取DateUtils.getSerialNo()中产生的序列号产生的时间
	 */
	public static long serialNo2Date(long serialNo) {
		String s = String.valueOf(serialNo);
		return Long.parseLong(s.substring(0, s.length() - 6));

	}

	/**
	 * 得到当前日期的字符串格式
	 * 
	 * @param format
	 *            日期格式,例如: "yyyyMMddHHmmss"
	 * @return format格式的日期
	 */
	public static String getDate() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		return df.format(date);
	}

	/**
	 * 得到当前日期的字符串格式
	 * 
	 * @return "yyyy-MM-dd HH:mm:ss" 格式的日期
	 */
	public static String getDateTimeStr() {
//		Date date = new Date();
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		return df.format(date);
		return datetimeToString(new Date());
	}

	public static String parseCommonlyDateStr(String dateTimeStr) {
		if(null==dateTimeStr || dateTimeStr.isEmpty()){
			return "-";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateFormat df = new SimpleDateFormat("MM月dd日 HH时mm分");
		Date date = null;
		try {
			date = sdf.parse(dateTimeStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return df.format(date);
	}
	
	public static String parseDateHourStr(String dateTimeStr){
		if(null==dateTimeStr || dateTimeStr.isEmpty()){
			return "-";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateFormat df = new SimpleDateFormat("MM月dd日 HH时");
		Date date = null;
		try {
			date = sdf.parse(dateTimeStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return df.format(date);
	}

	public static Date parseDate(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	/**
	 * 
	*
	* @Title: parseDate 
	* @Description: String转换成date
	* @return Date 
	* @param dateStr
	* @param pattern
	* @return
	 */
	public static Date parseDate(String dateStr,String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	
	public static String format(Date time, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(time);
	}

	public static void main(String[] args) {
		System.out.println(datetimeToLong());
	}
	
	public static String toDateH(Date time){
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format1.format(time);
	}
}
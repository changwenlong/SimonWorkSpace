package edu.zju.chwl.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static junit.framework.Assert.*;

import org.junit.Test;

public class DateUtilTest {

	@Test(expected=ParseException.class)
	public void testSimpleDateFormatNotMatch() throws ParseException {
		new SimpleDateFormat("dd/MM/yyyy").parse("20150516");
	}
	
	@Test
	public void testSimpleDateFormat() throws ParseException {
		new SimpleDateFormat("dd/MM/yyyy").parse("16/05/2015");
	}
	
	@Test
	public void testSimpleDateFormatInvalidDay() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dateStr="44/05/2015";
		if(!dateFormat.format(dateFormat.parse(dateStr)).equals(dateStr)){
			System.out.println(dateStr+" is a illgel date as format "+"dd/MM/yyyy");
		}
	}
	
	@Test
	public void testCalendar() throws ParseException{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dateStr = "16/05/2015";
		Date date = dateFormat.parse(dateStr);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		assertEquals(2015, year);
		assertEquals("Month (Index from 0)",4, month);
		assertEquals(16, day);
		calendar.set(year, month,1);
		Date startDate = calendar.getTime();
		assertEquals("Start Date of Month","01/05/2015", dateFormat.format(startDate));
		int endDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(year, month,endDayOfMonth);
		Date endDate=calendar.getTime();
		assertEquals("End Date of Month","01/05/2015", dateFormat.format(startDate));
		assertTrue("Start Date is before End Date",startDate.before(endDate));
		assertTrue("End Date is after Start Date",endDate.after(startDate));
	}
	
	@Test
	public void testDateGetAndSet(){
		/*//获取当前时刻
		Calendar now = Calendar.getInstance();
		//指定时区和地区，也可以只输入其中一个参数
		//Calendar now = Calendar.getInstance(timeZone, locale); 
		//获取子类的实例
		//Calendar now = new GregorianCalendar();
		
		int year = now.get(Calendar.YEAR); //2016，当前年份
		int month = now.get(Calendar.MONTH) + 1; //1，当前月，注意加 1
		int day = now.get(Calendar.DATE); //18，当前日
		Date date = now.getTime(); //直接取得一个 Date 类型的日期
		
		//只设定某个字段的值 
		// public final void set(int field, int value)
		now.set(Calendar.YEAR, 2016);  
		//设定年月日或者年月日时分或年月日时分秒 
		// public final void set(int year, int month, int date[, int hourOfDay, int minute, int second])
		now.set(2016, 1, 1); 
		now.set(2016, 1, 1, 11, 1, 1); 
		//直接传入一个 Date 类型的日期 
		// public final void setTime(Date date)
		now.setTime(date);*/
		
	/*	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try { // 日期转字符串
			Calendar calendar = Calendar.getInstance();
			Date date = calendar.getTime();
			String dateStringParse = sdf.format(date);
			// 字符串转日期
			String dateString = "2016-01-01 11:11:11";
			Date dateParse = sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
		
		/*//根据现在时间计算
		Calendar now = Calendar.getInstance();  
		now.add(Calendar.YEAR, 1); //现在时间的1年后
		now.add(Calendar.YEAR, -1); //现在时间的1年前 
		//根据某个特定的时间 date (Date 型) 计算
		Calendar specialDate = Calendar.getInstance(); 
		specialDate.setTime(date); //注意在此处将 specialDate 的值改为特定日期
		specialDate.add(Calendar.YEAR, 1); //特定时间的1年后
		specialDate.add(Calendar.YEAR, -1); //特定时间的1年前*/	
		
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = "2016-01-01 11:11:11";
		Calendar calendar = Calendar.getInstance();
		long nowDate = calendar.getTime().getTime(); // Date.getTime() 获得毫秒型日期
		try {
			long specialDate = sdf.parse(dateString).getTime();
			long betweenDate = (specialDate - nowDate) / (1000 * 60 * 60 * 24); // 计算间隔多少天，则除以毫秒到天的转换公式
			System.out.print(betweenDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString_01 = "2016-01-01 11:11:11";
		String dateString_02 = "2016-01-02 11:11:11";
		try {
			Date date_01 = sdf.parse(dateString_01);
			Date date_02 = sdf.parse(dateString_02);
			System.out.println(date_01.before(date_02)); // true
			System.out.println(date_02.after(date_01)); // true
			System.out.println(date_01.compareTo(date_02)); // -1
			System.out.println(date_02.compareTo(date_01)); // 1
			System.out.println(date_02.compareTo(date_02)); // 0
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}

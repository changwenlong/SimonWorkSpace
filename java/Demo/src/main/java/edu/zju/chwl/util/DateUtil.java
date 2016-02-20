package edu.zju.chwl.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {	
	public static void dateUtil(String dateStr,String formatStr){
		SimpleDateFormat dateFormat = new SimpleDateFormat(formatStr);
		try {
			Date date = dateFormat.parse(dateStr);
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH);
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			System.out.println("Year:"+year);
			System.out.println("Month (Index from 0) :"+month);
			System.out.println("Day:"+day);
			calendar.set(year, month,1);
			Date startDate = calendar.getTime();
			System.out.println("The start Date of ("+dateStr+"):"+dateFormat.format(startDate));
			int endDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			calendar.set(year, month,endDayOfMonth);
			Date endDate=calendar.getTime();
			System.out.println("The end Date of ("+dateStr+"):"+dateFormat.format(endDate));
			System.out.println(dateFormat.format(startDate)+" is before "+dateFormat.format(endDate)+":"+startDate.before(endDate));
			System.out.println(dateFormat.format(startDate)+" is after "+dateFormat.format(endDate)+":"+startDate.after(endDate));
			
		} catch (ParseException e) {
			System.out.println(dateStr+" doesn't match the format:"+formatStr);
		}
		
	}
}

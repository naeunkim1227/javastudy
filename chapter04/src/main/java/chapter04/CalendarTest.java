package chapter04;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		printDate(cal);
		
	}

	public static void printDate(Calendar cal) {
		int year = cal.get(Calendar.YEAR);
		
		int month = cal.get(Calendar.MONTH);
		int date = cal.get(Calendar.DATE);
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int seconds = cal.get(Calendar.SECOND);
		

		System.out.println(
			year  + "-" + (month+1) + "-" + (date) + " " + hour + ":" + minute 
			+ ":" + seconds
		);
	}
}

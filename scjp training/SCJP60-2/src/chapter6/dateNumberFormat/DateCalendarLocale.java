package chapter6.dateNumberFormat;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateCalendarLocale {


	public static void main(String[] args) {
		
		Date date = new Date();
		System.out.println("new Date(): " + date);
		
		Locale locale = new Locale("en","us");
		
		Calendar calendar = Calendar.getInstance(locale);
		System.out.println("calendar time: " + calendar.getTime());
		
		System.out.println("default timezone: " + calendar.getTimeZone());
		
		System.out.println(Arrays.toString(TimeZone. getAvailableIDs()));
		
		for(String timeZoneId : TimeZone.getAvailableIDs()){
			TimeZone timeZone = TimeZone.getTimeZone(timeZoneId);			
			Calendar c = Calendar.getInstance(timeZone);
			
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			sdf.setTimeZone(timeZone);
			
			System.out.println("timezone: " + timeZone.getDisplayName() + ", date: " + sdf.format(c.getTime()));
		}
		
		
//		for(Locale l : locale.getAvailableLocales()){
//			Calendar c = Calendar.getInstance(l);			
//			System.out.println("locale: " + l.getDisplayCountry() + "time: " + new SimpleDateFormat("HH:mm",l).format(c.getTime()));			
//		}
		
		DateFormat df = DateFormat.getInstance();
		
		DateFormat df1 = DateFormat.getDateInstance();
		
		DateFormat df2 = DateFormat.getDateInstance(DateFormat.SHORT);
		DateFormat df3 = DateFormat.getDateInstance(DateFormat.MEDIUM);
		DateFormat df4 = DateFormat.getDateInstance(DateFormat.LONG);
		
		DateFormat df5 = DateFormat.getDateInstance(DateFormat.LONG,Locale.ITALIAN);
		System.out.println(df5.format(new Date()));
			
		
		NumberFormat nf = NumberFormat.getInstance();
		System.out.println("number format: " + nf.format(12345.123));
		
		NumberFormat nf1 = NumberFormat.getCurrencyInstance();
		System.out.println("currency: " + nf1.format(2.2));
		
		NumberFormat nf2 = NumberFormat.getPercentInstance();
		System.out.println("percent: " + nf2.format(0.762));
	}

}

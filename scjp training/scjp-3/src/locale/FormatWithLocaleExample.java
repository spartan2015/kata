package locale;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class FormatWithLocaleExample {
	public static void main(String[] args){
		Locale locale = new Locale("ro","RO");
		TimeZone timeZone = TimeZone.getTimeZone("GMT+3");
		
				
		Calendar calendar = Calendar.getInstance(timeZone, locale);
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
		
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, locale);
		
		System.out.println("df.format(new Date()) + " + df.format(new Date()));
		System.out.println("DateFormat.getDateTimeInstace(DateFormat.FULL,DateFormat.Full,new Locale(\"ro\",\"RO\"))" +  df.format(calendar.getTime()));
		df.setTimeZone(timeZone);
		System.out.println("TimeZone.getTimeZone(\"GMT+3\")" + df.format(calendar.getTime()));
		df.setTimeZone(TimeZone.getTimeZone("GMT"));
		System.out.println("TimeZone.getTimeZone(\"GMT\")" + df.format(calendar.getTime()));
		
		NumberFormat nf = NumberFormat.getInstance(locale);
		System.out.println("NumberFormat.getInstance(new Locale('ro','RO'))" + nf.format(1000.123456));
		
		NumberFormat nf_us = NumberFormat.getInstance(Locale.US);
		System.out.println("NumberFormat.getInstance(Locale.US): " + nf_us.format(1000.123456));
		
		NumberFormat nf_currency = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println("NumberFormat.getCurrencyInstance(Locale.US): " + nf_currency.format(1000.123456));
		
		NumberFormat nf_currency_ro = NumberFormat.getCurrencyInstance( new Locale("ro","RO"));
		System.out.println("NumberFormat.getCurrencyInstance( new Locale(\"ro\",\"RO\")): " + nf_currency_ro.format(1000.123456));
		
		
		Calendar c = Calendar.getInstance();
		System.out.println("default timezone on: Calendar.getInstance()" + c.getTimeZone().getID());
		System.out.println("c.get(c.DAY_OF_WEEK): " + c.get(c.DAY_OF_WEEK));
		System.out.println("df.format(c.getTime()) - df was set to GMT: " + df.format(c.getTime()));
		c.add(c.MONTH, 3);
		System.out.println("c.add(c.MONTH, 3): " + df.format(c.getTime()));
		c.roll(c.MONTH, 12);
		System.out.println("c.roll(c.MONTH, 12): " + df.format(c.getTime()));
		c.roll(c.YEAR, 1);
		System.out.println("c.add(c.YEAR, 1): " + df.format(c.getTime()));
		
				
	}
}

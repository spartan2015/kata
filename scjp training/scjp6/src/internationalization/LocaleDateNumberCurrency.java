package internationalization;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class LocaleDateNumberCurrency {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		
		Calendar c = Calendar.getInstance();
		// calendar is always initialized with OS default timezone - locale - ours is english
		
		
		
		System.out.println(DateFormat.getDateInstance(DateFormat.SHORT).format(c.getTime()));
		System.out.println(DateFormat.getDateInstance(DateFormat.MEDIUM).format(c.getTime()));
		System.out.println(DateFormat.getDateInstance(DateFormat.LONG).format(c.getTime()));
		System.out.println(DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime()));
		
		
		System.out.println();
		
		Calendar c1 = Calendar.getInstance(Locale.ITALIAN);
		System.out.println(DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL,Locale.ITALIAN).format(c1.getTime()));
		System.out.println(DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL,Locale.GERMANY).format(c1.getTime()));
		
		System.out.println(Arrays.toString(TimeZone.getAvailableIDs()));
		
		Calendar c2 = Calendar.getInstance(TimeZone.getTimeZone("PST"),Locale.ITALIAN);
		System.out.println(DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL,Locale.ITALIAN).format(c2.getTime()));
		System.out.println(DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL,Locale.GERMANY).format(c2.getTime()));
		System.out.println();
		System.out.println(DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL,Locale.CANADA).format(c2.getTime()));
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		
		
		System.out.println("System time zone: " + c2.getTimeZone());		
		System.out.println("system time: " + sdf.format(c2.getTime()));
		
		
		System.out.println("Time offset (difference from GMT or UTC) " + " offset is: " + ((c2.get(Calendar.ZONE_OFFSET) + c2.get(Calendar.DST_OFFSET))/(60 * 60 * 1000)));
		
//		for(String timeZoneString : TimeZone.getAvailableIDs()){
//			sdf.setTimeZone(TimeZone.getTimeZone(timeZoneString));
//			System.out.println(timeZoneString + " " + sdf.format(c2.getTime()));
//		}
		
		// PST ora 4
		sdf.setTimeZone(TimeZone.getTimeZone("PST"));
		Date pstDate = sdf.parse("04:00:00");
		
		System.out.println(pstDate);
		
		//System.out.println(c1.);
		//System.out.println(c.get);
		
		
		// you can see how the country or language name looks like in another language (locale)
		Locale it = Locale.ITALIAN;
		
		System.out.println(it.getDisplayCountry());
		System.out.println(it.getDisplayLanguage());
		
		System.out.println(it.getDisplayCountry(Locale.GERMAN));
		System.out.println(it.getDisplayLanguage(Locale.GERMAN));
		
	}

}

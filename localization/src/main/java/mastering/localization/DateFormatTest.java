package mastering.localization;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

public class DateFormatTest {

	@Test
	public void preJava8DateNumberFormat() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2016);
		calendar.set(Calendar.MONTH, 8);
		calendar.set(Calendar.DATE, 10);
		calendar.set(Calendar.HOUR, 14);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		Date date = calendar.getTime();

		// default: date time format
		DateFormat df = DateFormat.getInstance();
		assertEquals("9/10/16 2:00 PM", df.format(date));

		// date format
		// style
		df = DateFormat.getDateInstance(DateFormat.SHORT);
		assertEquals("9/10/16", df.format(calendar.getTime()));
		df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		assertEquals("Sep 10, 2016", df.format(calendar.getTime()));
		df = DateFormat.getDateInstance(DateFormat.LONG);
		assertEquals("September 10, 2016", df.format(calendar.getTime()));
		df = DateFormat.getDateInstance(DateFormat.FULL);
		assertEquals("Saturday, September 10, 2016", df.format(calendar.getTime()));

		// style, locale
		df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.GERMAN);
		assertEquals("10.09.16", df.format(calendar.getTime()));

		// time format
		// default
		df = DateFormat.getTimeInstance();
		assertEquals("2:00:00 PM", df.format(date));
		// style
		df = DateFormat.getTimeInstance(DateFormat.SHORT);
		assertEquals("2:00 PM", df.format(date));
		// style, locale
		df = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.GERMAN);
		assertEquals("14:00", df.format(date));

		// date time format
		df = DateFormat.getDateTimeInstance();
		assertEquals("Sep 10, 2016 2:00:00 PM", df.format(date));
		// style
		df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.LONG);
		assertEquals("9/10/16 2:00:00 PM EEST", df.format(date));
		// style, locale
		df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.LONG, Locale.GERMAN);
		assertEquals("10.09.16 14:00:00 OESZ", df.format(date));

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		assertEquals("2016-09-10 02:00:00", sdf.format(date));
		
		// number format
		double aNumber = 12345.123456;
		NumberFormat nf = NumberFormat.getInstance();
		assertEquals("12,345.123", nf.format(aNumber));
		nf = NumberFormat.getInstance(Locale.GERMAN);
		assertEquals("12.345,123", nf.format(aNumber));
		nf.setMaximumFractionDigits(2); // PAY ATTENTION TO ROUNDING
		assertEquals("123,46", nf.format(123.456));
		double parsedDouble;
		try {
			parsedDouble = nf.parse("123,456").doubleValue(); // MAXIMUM
																// FRACTION
																// DIGITS DOES
																// NOT APPLY TO
																// PARSING
			assertTrue(parsedDouble == 123.456);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		nf = NumberFormat.getCurrencyInstance();
		assertEquals("$12,345.12", nf.format(aNumber));
		nf = NumberFormat.getCurrencyInstance(Locale.GERMAN);
		assertEquals("¤ 12.345,12", nf.format(aNumber));

		nf = NumberFormat.getPercentInstance();
		assertEquals("1,234,512%", nf.format(aNumber));
		nf = NumberFormat.getPercentInstance(Locale.GERMAN);
		assertEquals("1.234.512%", nf.format(aNumber));
	}

	@Test
	public void java8() {
		LocalDate date = LocalDate.of(2015, 12, 1);		
		assertEquals("2015-12-01", date.format(DateTimeFormatter.ISO_LOCAL_DATE));		
		assertEquals(date, LocalDate.parse("2015-12-01"));
		
		LocalTime time = LocalTime.of(11, 12, 34);
		assertEquals("11:12:34",time . format (DateTimeFormatter.ISO_LOCAL_TIME));
		assertEquals(time,LocalTime.parse("11:12:34"));
		
		LocalDateTime dateTime = LocalDateTime . of (date, time);
		assertEquals("2015-12-01T11:12:34",dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		assertEquals(dateTime,LocalDateTime.parse("2015-12-01T11:12:34"));
		
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT); 
		assertEquals("12/1/15", dtf.format(date));	
		assertEquals(date, dtf.parse("12/1/15"));
		
		dtf = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT); 
		assertEquals("11:12 AM", dtf.format(time));
		
		dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT); 
		assertEquals("12/1/15 11:12 AM", dtf.format(dateTime));
		
		dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
		assertEquals("2015/12/01 11:12:34", dtf.format(dateTime));
	
		DateTimeFormatter dtf1 = new DateTimeFormatterBuilder().appendText(ChronoField.YEAR).appendLiteral("/")
				.appendText(ChronoField.MONTH_OF_YEAR).appendLiteral("/").appendText(ChronoField.DAY_OF_MONTH)
				.parseCaseInsensitive().toFormatter(Locale.FRENCH);

		assertEquals("2015/décembre/1", dateTime.format(dtf1));
		
	}

}

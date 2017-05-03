package java8.datetime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.chrono.Era;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

public class DateFormatTest {

	@Test
	public void createDates() {
		// LocalDate d = new LocalDate(); // DOES NOT COMPILE
		// LocalDate.of(2015, Month.JANUARY, 32) // throws DateTimeException

		LocalDate localDate = LocalDate.now();
		localDate = LocalDate.of(2016, Month.DECEMBER, 20);
		localDate = LocalDate.of(2016, 12, 20);

		LocalTime localTime = LocalTime.now();
		localTime = LocalTime.of(12, 35);
		localTime = LocalTime.of(12, 35, 59);
		localTime = LocalTime.of(12, 35, 59, 1_000_000);

		localTime.getHour();
		localTime.getMinute();
		localTime.getSecond();
		localTime.getNano(); // NANO !

		LocalDateTime localDateTime = LocalDateTime.now();
		localDateTime = LocalDateTime.of(localDate, localTime);
		localDateTime = LocalDateTime.of(2016, Month.DECEMBER, 20, 12, 35, 59);
		localDateTime = LocalDateTime.of(2016, 12, 20, 12, 35, 59);

		localDateTime = LocalDateTime.of(2016, 12, 20, 12, 35);
		localDateTime = LocalDateTime.of(2016, 12, 20, 12, 35, 59);
		localDateTime = LocalDateTime.of(2016, 12, 20, 12, 35, 59, 1_000_000);

	}

	@Test
	public void zonedDateTime() {
		ZonedDateTime zonedDateTime0 = ZonedDateTime.now();
		ZonedDateTime zonedDateTime1 = ZonedDateTime.of(LocalDate.of(2016, 9, 22),LocalTime.of(12, 35), ZoneId.of("GMT"));
		ZonedDateTime zonedDateTime2 = ZonedDateTime.of(LocalDateTime.of(2016, 9, 22, 12, 35), ZoneId.of("GMT"));
		ZonedDateTime zonedDateTime3 = ZonedDateTime.of(2016, 9, 22, 12, 35,59,1_000_000, ZoneId.of("GMT"));
		
		ZoneId zoneId1 = ZoneId.of("GMT");
		ZoneId zoneId2 = ZoneId.of("US/Pacific");
		ZoneId zoneId3 = ZoneId.of("US/Eastern");
		
	}

	@Test
	public void manipulatingDates() {
		LocalDate localDate = LocalDate.now(); // IMMUTABLE
		localDate = localDate.plusDays(1); // returns a new LocalDate based on
											// previous + days
		localDate = localDate.plusWeeks(1);
		localDate = localDate.plusMonths(1);
		localDate = localDate.plusYears(1);
		localDate = localDate.plus(1, ChronoUnit.DAYS);

		LocalDateTime localDateTime = LocalDateTime.of(2016, Month.JANUARY, 1, 12, 35);
		localDateTime = localDateTime.minusSeconds(1);
		localDateTime = localDateTime.minusMinutes(1);
		localDateTime = localDateTime.minusHours(1);
		localDateTime = localDateTime.minusDays(1);
		localDateTime = localDateTime.minusMonths(1);
		localDateTime = localDateTime.minusYears(1);

		localDateTime = localDateTime.minusDays(1).minusMinutes(2).minusSeconds(10);

	}

	@Test
	public void java8Parsing() {
		LocalDate date = LocalDate.of(2015, 12, 1);

		int day = date.getDayOfMonth();
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		Month month = date.getMonth();
		int monthFrom1to12 = date.getMonthValue();
		int year = date.getYear();
		Era era = date.getEra();
		date.get(ChronoField.DAY_OF_MONTH);

		assertEquals("2015-12-01", date.format(DateTimeFormatter.ISO_LOCAL_DATE));
		assertEquals(date, LocalDate.parse("2015-12-01"));

		LocalTime time = LocalTime.of(11, 12, 34);
		assertEquals("11:12:34", time.format(DateTimeFormatter.ISO_LOCAL_TIME));
		assertEquals(time, LocalTime.parse("11:12:34"));

		LocalDateTime dateTime = LocalDateTime.of(date, time);
		assertEquals("2015-12-01T11:12:34", dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		assertEquals(dateTime, LocalDateTime.parse("2015-12-01T11:12:34"));

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		assertEquals("12/1/15", dateTimeFormatter.format(date));
		assertEquals(date, dateTimeFormatter.parse("12/1/15"));

		dateTimeFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		assertEquals("11:12 AM", dateTimeFormatter.format(time));

		dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		assertEquals("12/1/15 11:12 AM", dateTimeFormatter.format(dateTime));

		dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
		assertEquals("2015/12/01 11:12:34", dateTimeFormatter.format(dateTime));

		DateTimeFormatter dateTimeFormatter2 = new DateTimeFormatterBuilder().appendText(ChronoField.YEAR)
				.appendLiteral("/").appendText(ChronoField.MONTH_OF_YEAR).appendLiteral("/")
				.appendText(ChronoField.DAY_OF_MONTH).parseCaseInsensitive().toFormatter(Locale.FRENCH);
		assertEquals("2015/décembre/1", dateTime.format(dateTimeFormatter));

		dateTimeFormatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		assertEquals("2015-12-01", dateTime.format(dateTimeFormatter2));

	}

	@Test
	public void unixDate() {
		LocalDate localDate = LocalDate.of(2016, Month.JANUARY, 1);

		long daysSinceJan1st1970 = localDate.toEpochDay();

		LocalDateTime localDateTime = LocalDateTime.of(localDate, LocalTime.of(12, 35));
		long secondsSinceJan1st1970 = localDateTime.toEpochSecond(ZoneOffset.of("GMT"));

	}

	@Test
	public void workingWithPeriods() {

		LocalDate date = LocalDate.now();
		Period period = Period.ofMonths(1);

		date.plus(period);

		int years = 1;
		int months = 1;
		int days = 1;
		period = Period.of(years, months, days); // Period min is 1 Day

		period = Period.ofYears(1);
		assertEquals("P1Y",period.toString());;
		period = Period.ofMonths(1);
		assertEquals("P1M",period.toString());;
		period = Period.ofWeeks(1);
		assertEquals("P7D",period.toString());;
		period = Period.ofDays(1);
		assertEquals("P1D",period.toString());;

		// chaining does not work with Period
		// WRONG!
		// Period.ofDays(1).ofYears(1)

		// cannot add Period to LocalDateTime and LocalTime - RuntimeException

	}

	@Test
	public void workingWithDuration() {
		LocalTime localTime = LocalTime.of(12, 35);

		TemporalUnit unit = ChronoUnit.MINUTES;
		Duration duration = Duration.of(10, unit);
		
		assertTrue(60 == ChronoUnit.MINUTES.between(LocalTime.of(12,0), LocalTime.of(13, 00)));
		
		duration = Duration.ofDays(1); // yes DAYS is the largest Duration unit
		assertEquals("PT24H",duration.toString());
		
		duration = Duration.ofHours(10);
		assertEquals("PT10H",duration.toString());
		
		duration = Duration.ofMinutes(10);
		assertEquals("PT10M",duration.toString());
		
		duration = Duration.ofSeconds(10);
		assertEquals("PT10S",duration.toString());
		
		duration = Duration.ofMillis(10);
		assertEquals("PT0.01S",duration.toString());
		
		duration = Duration.ofNanos(1_000_000);
		assertEquals("PT0.001S",duration.toString());
		

		localTime.plus(duration);

		// RuntimeException using Time with Period:
		// localTime.plus(Period.ofDays(1));
	}
	
	@Test
	public void workingWithInstant(){
		Instant raceStart = Instant.now();
		// RACE
		Instant raceEnd = Instant.now();
		
		Duration duration = Duration.between(raceStart,raceEnd);
		
		Instant instant = ZonedDateTime.of(LocalDate.now(), LocalTime.now(), ZoneId.systemDefault()).toInstant();
		// you cannot convert a LocalDateTime to instant
		instant = Instant.ofEpochSecond(100);
		instant = Instant.ofEpochSecond(100, 1_000_000);
		instant = Instant.ofEpochMilli(100);
		
		instant = instant.plus(1, ChronoUnit.DAYS); // YEARS AND MONTS DO NOT WORK
		instant = instant.plus(1, ChronoUnit.HOURS);
		instant = instant.minus(1, ChronoUnit.WEEKS);
		
	}
	
	@Test
	public void daylightSavings(){
		
		ZoneId zone = ZoneId.of("US/Eastern");
		ZonedDateTime dateTime = ZonedDateTime.of(LocalDate.of(2016, 3, 13), LocalTime.of(1, 30),zone);
		assertEquals("2016-03-13T01:30-05:00[US/Eastern]",dateTime.toString());
		dateTime = dateTime.plusHours(1); // add 1 hours
		assertEquals("2016-03-13T03:30-04:00[US/Eastern]",dateTime.toString()); // WHOOPS - 2 hours difference now - also see the zone offset changes
		
		dateTime = ZonedDateTime.of(LocalDate.of(2016, 11, 6), LocalTime.of(1, 30),zone);
		assertEquals("2016-11-06T01:30-04:00[US/Eastern]",dateTime.toString());
		dateTime = dateTime.plusHours(1); // add 1 hours
		assertEquals("2016-11-06T01:30-05:00[US/Eastern]",dateTime.toString()); // just the zone offset changes - the time is the same - fall back 1h
		
		
		//also Java knows that 2:30 am on march 13 2016 (US/Eastern) does not exist because of the hour springs forward
		dateTime = ZonedDateTime.of(LocalDate.of(2016, 03, 13), LocalTime.of(2, 30),zone); // want to set time tot 2:30
		assertEquals("2016-03-13T03:30-04:00[US/Eastern]",dateTime.toString()); // LOOK ITS 3:30 instead 
	}

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
}

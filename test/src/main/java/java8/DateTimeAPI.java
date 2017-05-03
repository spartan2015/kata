package java8;

import org.junit.Test;

import static org.junit.Assert.*;

import java.time.*;
import java.time.chrono.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.time.temporal.*;
import java.util.Locale;

/**
 8.1. Create and manage date-based and time-based events; including combination of date and time into a single object using LocalDate, LocalTime, LocalDateTime, Instant, Period, Duration
 8.2. Work with dates and times across time-zones and manage changes resulting from daylight savings
 8.3. Define and create timestamps, periods and durations; apply formatting to local and zoned dates and times

 */
public class DateTimeAPI {

    @Test
    public void date(){
        LocalDate localDate = LocalDate.of(2014,12,1);
        LocalDate.parse("2014-12-01");

        System.out.println(localDate);

        int year = localDate.getYear();

        Month month = localDate.getMonth();

        int day = localDate.getDayOfMonth();

        DayOfWeek dayOfYear = localDate.getDayOfWeek();

        int dayOfYear2 = localDate.getDayOfYear();

        boolean leap = localDate.isLeapYear();

        int lenghtOfMonth = localDate.lengthOfMonth();

        int lengthOfYear = localDate.lengthOfYear();

        LocalDate fromSystemClock = LocalDate.now();

        int year1 = localDate.get(ChronoField.YEAR);
        int month1 = localDate.get(ChronoField.MONTH_OF_YEAR);
        int day1 = localDate.get(ChronoField.DAY_OF_MONTH);

        localDate.withYear(2015);
        localDate.withMonth(12);
        localDate.withDayOfMonth(12);
        localDate.with(ChronoField.YEAR, 2015);
        localDate.with(TemporalAdjusters.firstDayOfMonth());

        localDate.plusDays(10);
        localDate.plus(10, ChronoField.DAY_OF_MONTH.getBaseUnit());

        localDate.minusDays(10);
        localDate.minus(10, ChronoField.DAY_OF_MONTH.getBaseUnit());
    }

    @Test
    public void time(){
        LocalTime localTime = LocalTime.of(13,45,20);
        LocalTime.parse("13:45:20");

        int hour = localTime.getHour();
        int minute = localTime.getMinute();
        int second = localTime.getSecond();

        localTime.withHour(12);
        localTime.withMinute(00);
        localTime.withSecond(60);

        localTime.plusHours(1);
        localTime.plus(1, ChronoField.HOUR_OF_DAY.getBaseUnit());

        localTime.minusHours(1);
        localTime.minus(1, ChronoField.HOUR_OF_DAY.getBaseUnit());
    }

    @Test
    public void localDateTime(){
        LocalDateTime localDateTime = LocalDateTime.of(2014,12,1,13,45,20);

        LocalDate localDate = LocalDate.of(2014,12,1);
        LocalTime localTime = LocalTime.of(13,45,20);
        LocalDateTime.of(localDate, localTime);

        LocalDateTime ldt1 = localDate.atTime(localTime);
        LocalDateTime ldt2 = localDate.atTime(13,45,20);
        LocalDateTime ld3 = localTime.atDate(localDate);

    }

    @Test
    public void instant(){
        Instant.ofEpochSecond(1);

        Instant.ofEpochSecond(1,1_000_000_000); // 2 seconds

        Instant.ofEpochSecond(1,-1_000_000_000); // 0 seconds

        int year = Instant.now().get(ChronoField.YEAR);
        int month = Instant.now().get(ChronoField.MONTH_OF_YEAR);
        int day = Instant.now().get(ChronoField.DAY_OF_MONTH);

    }

    @Test
    public void duration(){
        Duration d1 = Duration.between(LocalTime.of(12,00,00),LocalTime.of(13,0,0));
        Duration d2 = Duration.between(LocalDateTime.of(2014,12,1,12,00),LocalDateTime.of(2014,12,1,13,00));
        Duration d3 = Duration.between(Instant.ofEpochSecond(1), Instant.ofEpochSecond(2));
        Duration d4 = Duration.ofMinutes(10);
        Duration d5 = Duration.of(1, ChronoField.SECOND_OF_DAY.getBaseUnit());

        Period tenDays = Period.between(LocalDate.of(2014,12,1),LocalDate.of(2014,12,11));
        Period p1 = Period.of(1,2,3);// 1 year 2 months and 3 days
        Period p2 = Period.ofWeeks(1);
        Period p3 = Period.ofYears(1);

    }

    @Test
    public void temporalAdjustments(){

        LocalDate localDate = LocalDate.of(2015,12,1);

        localDate.with(TemporalAdjusters.firstDayOfMonth());
        localDate.with(TemporalAdjusters.firstDayOfNextMonth());

        localDate.with(TemporalAdjusters.lastDayOfMonth());
        localDate.with(TemporalAdjusters.lastDayOfYear());

        localDate.with(TemporalAdjusters.firstDayOfYear());
        localDate.with(TemporalAdjusters.firstDayOfNextYear());

        localDate.with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY));
        localDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.FRIDAY));

        localDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
        localDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));

        localDate.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
        localDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.FRIDAY));

    }

    @Test
    public void formatter(){
        LocalDate localDate = LocalDate.of(2015,12,1);        
        assertEquals("20151201", localDate.format(DateTimeFormatter.BASIC_ISO_DATE)); 
        assertEquals("2015-12-01", localDate.format(DateTimeFormatter.ISO_DATE));         

    }
    @Test
    public void parser(){
        String str = "";
        LocalDateTime ldt = LocalDateTime.of(2015,02,03,12,30,59);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");

        str = ldt.format(dtf);

        //ldt = LocalDateTime.parse("2015/12/01 12:30:59",dtf);

        str = ldt.format(dtf);

        DateTimeFormatter dtf1 = new DateTimeFormatterBuilder()
                .appendText(ChronoField.YEAR).appendLiteral("/")
                .appendText(ChronoField.MONTH_OF_YEAR).appendLiteral("/")
                .appendText(ChronoField.DAY_OF_MONTH)
                .parseCaseInsensitive()
                .toFormatter(Locale.FRENCH);

        str = ldt.format(dtf1);

        System.out.println(str);
    }

    @Test
    public void timeZones(){
        String str = "";
        ZoneId zoneId = ZoneId.of("GMT");
        zoneId = ZoneId.of("Europe/Rome");

        LocalDateTime ldt = LocalDateTime.now();
        str = ldt.format(DateTimeFormatter.ISO_DATE_TIME);

        ZonedDateTime zdt = ldt.atZone(zoneId);

        str = zdt.format(DateTimeFormatter.ISO_DATE_TIME);

        ZoneOffset zoneOffset = ZoneOffset.of("+01:00");
        OffsetDateTime offsetDateTime = ldt.atOffset(zoneOffset);

        str = offsetDateTime.format(DateTimeFormatter.ISO_DATE_TIME);

        zdt = offsetDateTime.atZoneSameInstant(ZoneId.of("Europe/Bucharest"));
        str = zdt.format(DateTimeFormatter.ISO_DATE_TIME);

        System.out.println(str);
    }

    @Test
    public void japaneseDate(){String str = "";
        LocalDate date = LocalDate.of(2014,12,1);
        JapaneseDate japaneseDate =JapaneseDate.from(date);

        str = japaneseDate.format(DateTimeFormatter.BASIC_ISO_DATE);

        ThaiBuddhistDate.from(date);
        MinguoDate.from(date);
        HijrahDate.from(date);

        Chronology d = Chronology.ofLocale(Locale.JAPAN);
        d.dateNow();

        System.out.println(str);

    }
}

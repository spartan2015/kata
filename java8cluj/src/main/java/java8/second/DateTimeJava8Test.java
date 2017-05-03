package java8.second;

import com.sun.media.jfxmedia.locator.LocatorCache;
import org.junit.Test;

import javax.xml.transform.sax.SAXSource;
import java.time.*;
import java.time.chrono.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

/**
 * Created by Battlestar on 2/24/2015.
 */
public class DateTimeJava8Test {

    @Test
    public void localDate(){
        LocalDate localDate = null;

        localDate = LocalDate.MIN;
        localDate = LocalDate.MAX;
        localDate = LocalDate.now();
        localDate = LocalDate.now(Clock.systemDefaultZone());
        localDate = LocalDate.now(Clock.system(ZoneId.of("+01:00")));
        localDate = LocalDate.of(2014,12,1);
        localDate = LocalDate.parse("2014-12-01");

        localDate = LocalDate.from(/*Any TemporalAccesor - all date times are temporal accessors - base interface*/localDate);
        localDate = LocalDate.from(LocalDateTime.now());

        localDate.getYear();
        localDate.getMonth();
        localDate.getDayOfMonth();

        localDate.getDayOfYear();
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        int year = localDate.get(ChronoField.YEAR);
        int month=localDate.get(ChronoField.MONTH_OF_YEAR);
        int day = localDate.get(ChronoField.DAY_OF_MONTH);

        int dayOfYear = localDate.get(ChronoField.DAY_OF_YEAR);
        localDate.get(ChronoField.DAY_OF_WEEK);

        localDate = localDate.withYear(1990); // changes just the year
        localDate = localDate.withMonth(12);
        localDate = localDate.withDayOfMonth(1);
        localDate = localDate.withDayOfYear(1);

        localDate = localDate.with(ChronoField.YEAR,2011);

        localDate = localDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.FRIDAY));
        localDate = localDate.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
        localDate = localDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.FRIDAY));
        localDate = localDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
        localDate = localDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        localDate = localDate.with(TemporalAdjusters.firstDayOfYear());
        localDate = localDate.with(TemporalAdjusters.firstDayOfMonth());
        localDate = localDate.with(TemporalAdjusters.firstDayOfNextMonth());
        localDate = localDate.with(TemporalAdjusters.firstDayOfNextYear());
        localDate = localDate.with(TemporalAdjusters.lastDayOfMonth());
        localDate = localDate.with(TemporalAdjusters.lastDayOfYear());

        // create your own TemporalAdjuster
        localDate.with(TemporalAdjusters.ofDateAdjuster((temporal)->temporal));
        localDate.with((temporal)->temporal); // same as above - is translated to temporalAdjuster functional interface

        //FORMAT
        String dateAsString = null;
        dateAsString = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate.parse("20141231",DateTimeFormatter.BASIC_ISO_DATE);
        dateAsString = localDate.format(DateTimeFormatter.ISO_DATE);
        LocalDate.parse("2014-12-31", DateTimeFormatter.ISO_DATE);
        dateAsString = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate.parse("2014-12-31", DateTimeFormatter.ISO_LOCAL_DATE);

        localDate = LocalDate.parse("2014-12-01"); // default DateTimeFormatter.ISO_LOCAL_DATE

        LocalDate.parse("2014-12-31", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @Test
    public void localTime(){
        LocalTime localTime = null;

        localTime = LocalTime.now();
        localTime = LocalTime.now(Clock.system(ZoneId.of("+01:00")));
        localTime = LocalTime.of(14,30);
        localTime = LocalTime.of(14,30,30);
        localTime = LocalTime.of(14,30,30,/*nanos*/1000);
        localTime = LocalTime.parse("14:30:30");

        int hour = localTime.getHour();
        int minute = localTime.getMinute();
        int second = localTime.getSecond();
        int nanos = localTime.getNano();

        hour = localTime.get(ChronoField.HOUR_OF_DAY);
        hour = localTime.get(ChronoField.HOUR_OF_AMPM);
        minute = localTime.get(ChronoField.MINUTE_OF_HOUR);
        minute = localTime.get(ChronoField.MINUTE_OF_DAY);
        second = localTime.get(ChronoField.SECOND_OF_MINUTE);
        second = localTime.get(ChronoField.SECOND_OF_DAY);

        // FORMAT
        String timeAsString = null;
        timeAsString = localTime.format(DateTimeFormatter.ISO_TIME);
        LocalTime.parse("12:30:59",DateTimeFormatter.ISO_TIME);
        timeAsString = localTime.format(DateTimeFormatter.ISO_LOCAL_TIME);
        LocalTime.parse("12:30:59",DateTimeFormatter.ISO_LOCAL_TIME);

        //LocalTime.parse("10:11:12:13",DateTimeFormatter.ofPattern("hh:mm:ss:"));
    }

    @Test
    public void localDateTime(){
        LocalDateTime localDateTime = null;
        localDateTime = LocalDateTime.of(2014,Month.APRIL,14,15,30);
        localDateTime = LocalDateTime.of(2014,Month.APRIL,14,15,30,31);
        localDateTime = LocalDateTime.of(2014,Month.APRIL,14,15,30,31,32);
        localDateTime = LocalDateTime.parse("2014-12-31T12:30:59");


        LocalDate localDate = LocalDate.of(2014,Month.FEBRUARY,28);
        LocalTime localTime = LocalTime.of(12,20);
        localDateTime = LocalDateTime.of(localDate,localTime );

        localDateTime = localDate.atTime(12,20);
        localDateTime = localDate.atTime(localTime);
        localDateTime = localTime.atDate(localDate);

        localDate = localDateTime.toLocalDate();
        localTime = localDateTime.toLocalTime();

        //FORMAT
        String dateTimeAsString = null;

        LocalDateTime.parse("2014-12-31T12:30:59"); // DateTimeFormatter.ISO_LOCAL_DATE_TIME
        //LocalDateTime.parse("2014-12-30T12:30:59", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm:ss"));

        dateTimeAsString = localDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
        localDateTime.parse("2014-02-28T12:20:00",DateTimeFormatter.ISO_DATE_TIME);

        dateTimeAsString = localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        localDateTime.parse("2014-02-28T12:20:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println(dateTimeAsString);

        dateTimeAsString = localDateTime.format(DateTimeFormatter.ISO_DATE);
        localDateTime.parse("2014-12-31",DateTimeFormatter.ISO_DATE);
        dateTimeAsString = localDateTime.format(DateTimeFormatter.ISO_TIME);
        localDateTime.parse("12:30:59", DateTimeFormatter.ISO_TIME);

    }

    @Test
    public void dateTimeFormatterBuilder(){
        DateTimeFormatter dateTimeFormatter = new DateTimeFormatterBuilder()
                .append(DateTimeFormatter.ofPattern("yyyy"))
            .appendLiteral('-')
            .appendValue(ChronoField.MONTH_OF_YEAR)
            .appendLiteral('-')
            .appendValue(ChronoField.DAY_OF_MONTH)
                .parseCaseSensitive()
                .parseCaseInsensitive()
            .toFormatter(Locale.getDefault());
        ;
        assertEquals("2014-12-30", LocalDate.of(2014, 12, 30).format(dateTimeFormatter));

        dateTimeFormatter = new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR).toFormatter(); //Appends the value of a date-time field to the formatter using a normal output style.
        assertEquals("2014", LocalDate.of(2014, 12, 30).format(dateTimeFormatter));
        dateTimeFormatter = new DateTimeFormatterBuilder().appendText(ChronoField.YEAR).toFormatter(); // Appends the text of a date-time field to the formatter using the ful text style.
        assertEquals("2014", LocalDate.of(2014, 12, 30).format(dateTimeFormatter));

    }

    @Test
    public void offset(){
        LocalTime localTime= LocalTime.of(12,30,40);
        OffsetTime offsetTime = localTime.atOffset(ZoneOffset.ofHours(1));
        offsetTime = localTime.atOffset(ZoneOffset.ofHoursMinutes(12, 20));

        Temporal temporal = (OffsetTime)ZoneOffset.ofHoursMinutes(12, 20).adjustInto(offsetTime);

        offsetTime = localTime.atOffset(ZoneOffset.ofHoursMinutesSeconds(12, 20, 30));
        offsetTime = localTime.atOffset(ZoneOffset.ofTotalSeconds(100));

        ZoneOffset zoneOffset = offsetTime.getOffset();

        OffsetDateTime offsetDateTime = offsetTime.atDate(LocalDate.of(2014, 01, 01));

        //FORMAT
        String offsetDateTimeAsString = null;
        offsetDateTimeAsString = offsetDateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);

        OffsetDateTime bucharest = OffsetDateTime.of(LocalDateTime.of(2014, 12, 30, 11, 12, 13), ZoneOffset.of("-05:00"));

        System.out.println(offsetDateTimeAsString);
    }

    @Test
    public void timeZone(){
        // ONLY WITH localDateTime - not LocalDate or LocalTime
        ZoneId.of("Europe/Rome"); // {area}/{city}
        ZoneId.of("GMT");
        ZoneId.of("UTC");
        ZoneId.of("UT");
        java.util.TimeZone.getDefault().toZoneId();

        ZoneId zoneId = ZoneId.of("+02:00");

        ZonedDateTime zonedDateTime = null;

        zonedDateTime = LocalDateTime.of(2012, 1, 1, 12, 30).atZone(zoneId); // ATTACHING A ZONE with atZONE does not change the time or date
        zonedDateTime = Instant.ofEpochSecond(100).atZone(zoneId);
        zonedDateTime = LocalDate.of(2014,Month.DECEMBER,30).atStartOfDay(zoneId);

        Instant instant = LocalDateTime.of(2012, 1, 1, 12, 30).atZone(zoneId).toInstant(); // zonedDateTime to Instant
        LocalDateTime.of(2012, 1, 1, 12, 30).toInstant(ZoneOffset.ofHours(2));

        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant,zoneId);

        System.out.println(zonedDateTime);
    }

    @Test
    public void otherCalendards(){
        LocalDate localDate = LocalDate.now();
        JapaneseDate japaneseDate = JapaneseDate.from(localDate);
        ThaiBuddhistDate thaiBuddhistDate = ThaiBuddhistDate.from(localDate);
        MinguoDate minguoDate = MinguoDate.from(localDate);
        HijrahDate hijrahDate = HijrahDate.from(localDate);

        Chronology japaneseChronology = Chronology.ofLocale(Locale.JAPANESE);
        ChronoLocalDate chronoLocalDate = japaneseChronology.dateNow();

    }

    @Test
    public void instant(){
        // for machines
        // no of seconds since 1 Jan 1970 midnight UTC

        Instant instant = null;

        instant = Instant.ofEpochSecond(1);
        instant = Instant.ofEpochSecond(0, 1_000_000_000);
        instant = Instant.ofEpochSecond(2, -1_000_000_000);


    }

    @Test
    public void duration(){
        Duration duration = null;

        LocalTime localTime1 = LocalTime.of(12,00);
        LocalTime localTime2 = LocalTime.of(13,00);

        duration = duration.between(localTime1, /*exclusive*/ localTime2); // SAME TYPE BOTH _ NO MIX ALLOWED - MUST CONTAIN TIME  !!! LocalDate WILL NOT WORK

        LocalDateTime localDateTime1 = LocalDateTime.of(2014,01,01,12,00);
        LocalDateTime localDateTime2 = LocalDateTime.of(2014,01,01,14,00);

        duration = duration.between(localDateTime1, localDateTime2);

        Instant instant1 = Instant.ofEpochSecond(100);
        Instant instant2 = Instant.ofEpochSecond(200);

        duration = Duration.between(instant1, instant2);

        duration.isZero();

        duration.isNegative();
        duration = duration.abs(); // same as Math.abs
        duration = duration.negated();

        Temporal temporal = (LocalTime)duration.addTo(localTime1);
        temporal = (LocalTime)duration.subtractFrom(localTime1);

        duration = duration.dividedBy(100);
        duration.multipliedBy(100);

        // parts of the Duration
        int nanos = duration.getNano();
        long seconds = duration.getSeconds();

        // actual duration values:
        long nanos1 = duration.toNanos();

        duration.toDays();
        duration.toHours();
        duration.toMinutes();
        duration.toMinutes();
        long milis = duration.toMillis();

        duration = duration.minus(duration);
        duration = duration.minus(100, ChronoUnit.DAYS);
        duration = duration.plus(100, ChronoUnit.DAYS);
        duration.plus(duration);

        duration = duration.minusDays(1);
        duration = duration.minusHours(1);
        duration = duration.minusMinutes(1);
        duration = duration.minusSeconds(1);
        duration = duration.minusMillis(1);

        duration = duration.withSeconds(100); // new duration will have the nanos of the initial duration
        duration = duration.withNanos(100); // new duration will have the seconds of the initial duration

        Duration.of(12, ChronoUnit.DAYS);
        Duration.ofDays(1);
        Duration.ofHours(1);
        Duration.ofMinutes(1);
        Duration.ofMillis(1000);
        Duration.ofSeconds(1);
        Duration.ofSeconds(1,1_000_000_000);

    }

    @Test
    public void period(){ // duration in terms of days, months, years
        Period period = null;
        LocalDate localDate1 = LocalDate.of(2014,01,01);
        LocalDate localDate2 = LocalDate.of(2014,01,02);
        period = Period.between(localDate1, localDate2);

        period = Period.from(Period.of(1,2,3));
        period = Period.from(Duration.of(12, ChronoUnit.DAYS));

        Period.ofDays(1);
        Period.ofMonths(1);
        Period.ofYears(1);
        Period.ofWeeks(1);

        /**
         * * For example, the following are valid inputs:
         * <pre>
         *   "P2Y"             -- Period.ofYears(2)
         *   "P3M"             -- Period.ofMonths(3)
         *   "P4W"             -- Period.ofWeeks(4)
         *   "P5D"             -- Period.ofDays(5)
         *   "P1Y2M3D"         -- Period.of(1, 2, 3)
         *   "P1Y2M3W4D"       -- Period.of(1, 2, 25)
         *   "P-1Y2M"          -- Period.of(-1, 2, 0)
         *   "-P1Y2M"          -- Period.of(-1, -2, 0)
         */
        Period.parse("P1Y");
        // contains same method as duration: minus, plus, divid, multiply, substract, add, negate, isZerom, is Negative

    }


}


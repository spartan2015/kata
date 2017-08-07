import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

/**
 * Created on 8/7/2017.
 */
public class ParseDateTime {
    @Test
    public void case1(){
        ZonedDateTime dateTime = ZonedDateTime.parse("2017-08-07T12:38:15z0300");
        assertEquals(15,dateTime.getSecond());
        assertEquals(38,dateTime.getMinute());
        assertEquals(12,dateTime.getHour());
    }
    @Test
    public void case2(){
        ZonedDateTime dateTime = ZonedDateTime.of(LocalDateTime.of(2017,01,02,12,15,30), ZoneId.of("+0300"));
        assertEquals("2017-01-02T12:15:30+03:00",dateTime.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
    }

}

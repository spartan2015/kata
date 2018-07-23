import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest
{
 @Test
  public void calendarFromDate(){
   Date date = new Date(84,02,28,14,25,59);
   Calendar calendar = Calendar.getInstance();
   calendar.setTime(date);
   Assert.assertEquals(1984, calendar.get(Calendar.YEAR));
   Assert.assertEquals(02, calendar.get(Calendar.MONTH));
   Assert.assertEquals(28, calendar.get(Calendar.DATE));
   Assert.assertEquals(2, calendar.get(Calendar.HOUR));
   Assert.assertEquals(25, calendar.get(Calendar.MINUTE));
   Assert.assertEquals(59, calendar.get(Calendar.SECOND));
 }
}

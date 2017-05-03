package test;

import static org.junit.Assert.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

public class DateParserTest {
	@Test
	public void t1() throws Exception{
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new SimpleDateFormat("yyyyMMddhhmmss'Z'").parse("20160210170000Z"));
		
		assertTrue(2016 == calendar.get(Calendar.YEAR));
		assertTrue(1 == calendar.get(Calendar.MONTH));
		assertTrue(10 == calendar.get(Calendar.DATE));
		
		assertTrue(5 == calendar.get(Calendar.HOUR));
		assertTrue(0 == calendar.get(Calendar.MINUTE));
		assertTrue(0 == calendar.get(Calendar.SECOND));
	}
	
	@Test
	public void t2(){
		String[] parts = {"CD",".OK"};
		File o1 = new File("CD2016.OK"); 
		String stringDate = o1.getName().substring(parts[0].length(),
                o1.getName().length() - parts[1].length());
		assertEquals("2016",stringDate);
	}
	
	@Test
	public void t3(){
		"CD*.OK".split("\\*");
	}
}

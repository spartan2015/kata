package test.date;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DateTest {

	@Test(expected=NullPointerException.class)
	public void testDateBefore() {
		Date date = Calendar.getInstance().getTime();

		try {
			date.before(null);
			fail();
		} catch (Exception e) {
			//expected
			throw e;
		}
	}
}

package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringTest {

	@Test
	public void t(){
		String[] result = "a".split(";");
		assertNotNull(result);
		assertEquals("a",result[0]);
	}
	
}

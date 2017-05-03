package strings.s2;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubstringWithRotation {

	@Test
	public void test(){
		assertTrue(isSubstring("bottle","tlewaterbot"));
	}

	private boolean isSubstring(String string, String string2) {
		return (string2+string2).contains("bottle");
	}
	
}

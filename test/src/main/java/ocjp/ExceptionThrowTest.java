package ocjp;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by Battlestar on 1/21/2015.
 */
public class ExceptionThrowTest {

	static String finallyMessage = "inFinally";

	@Test
	public void exceptionThrownInFinallyBlockOverridesPreviousThrownException(){
		try {
			methodThrowsException();
			fail();
		} catch (Exception ex) {
			assertEquals(finallyMessage, ex.getMessage());
		}
	}

	private void methodThrowsException() throws Exception {
		try {
			throw new Exception("inTry");
		} finally {
			throw new Exception(finallyMessage);
		}
	}

}

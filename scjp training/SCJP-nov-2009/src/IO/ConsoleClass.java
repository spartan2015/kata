package IO;

import java.io.Console;

public class ConsoleClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Console c = System.console();
		
		char[] passwordCHAR = c.readPassword("give password: %s", "NOW!!!");
		
		String simpleSTRSING = c.readLine("give string: %s", "str: ");

		c.format("%s", "asd"); // write a formatted string to this console
		
	}

}

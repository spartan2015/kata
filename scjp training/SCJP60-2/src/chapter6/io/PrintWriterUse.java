package chapter6.io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintWriterUse {
	
	public static void main(String[] args) {
		
		/**
		 * PrintWriter constructors:
		 * 1. String
		 * 2. File
		 * 3. FileWriter
		 * 4. OutputStream
		 * 
		 * Methods:
		 * 1. format
		 * 2. printf
		 * 3. print
		 * 4. println
		 * 
		 */
		
		PrintWriter pw = null;
		try{
			pw = new PrintWriter("c:\\test.test");
		}catch(FileNotFoundException fnfe){fnfe.printStackTrace();}
		
		pw.print("bunica");
		pw.println(" includes end of line");
		
		pw.printf("this %0$0,10.2f", -2.2);
		
		pw.flush(); // CLEAN
		pw.close(); // CLEAN
	}

}

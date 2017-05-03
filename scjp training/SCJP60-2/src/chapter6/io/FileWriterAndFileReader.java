package chapter6.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;

public class FileWriterAndFileReader {

	
	public static void main(String[] args) {
	

		File file = new File("c:\\test.test");

		/**
		 * FileReader and FileWriter constructors:
		 * 1. File
		 * 2. String
		 * 
		 * FileWriter methods:
		 * 1. write
		 * 2. flush
		 * 3. close
		 * 
		 * FileReader methods:
		 * 1. read
		 */
		
		try {
			FileWriter fw = new FileWriter(file); // throws IOException
			fw.write("forta\nprin\nodihna\nsuficienta"); // any write throws IOException
			
			fw.flush(); // throws IOException
			fw.close(); // throws IOException
			
		} catch (IOException e) {e.printStackTrace();}
		
		FileReader fr = null;
		
		try {
			fr = new FileReader(file); // throws FileNotFoundException
		} catch (FileNotFoundException e) {	e.printStackTrace();} 
		
		CharBuffer cb = CharBuffer.allocate(100);
		
		try {
			fr.read(cb); // throws IOException
		} catch (IOException e) {e.printStackTrace();}
		cb.position(0);		
		System.out.println(cb.toString());
	}

}

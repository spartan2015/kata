package chapter6.io;

import java.io.File;
import java.io.IOException;

public class FileUse {

	
	public static void main(String[] args) {
		
		/*
		 * Constructor arguments:
		 * 
		 * 1. String
		 * 2. String, String
		 * 3. File, String
		 * 
		 * Methods:
		 * 
		 * 1. boolean createNewFile() throws IOException 
		 * 2. boolean mkdir()
		 * 3. boolean delete()
		 * 4. String[] list()
		 * 5. File[] listFiles()
		 * 6. boolean renameTo(File)
		 * 7. boolean isFile()
		 * 8. boolean isDirectory()
		 * 9. boolean exists()		  
		 */
		File file = new File("c:\\test.test");
		
		
		// 1. createNewFile() throws IOException 
		try{
			boolean created = file.createNewFile();
			System.out.println("created: " + file + ": " + created);
		} catch(IOException e){e.printStackTrace();}
		
		
		// 2. mkdir() is clean
		File dir = new File("c:\\TESTER");
		boolean created = dir.mkdir();
		System.out.println("created dir " + dir + ": " + created);
				
		System.out.println("dir exists " + dir.exists());
		
		
	}

}

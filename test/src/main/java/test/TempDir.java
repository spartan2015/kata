package test;
import java.io.File;


public class TempDir {

	public static void main(String arg[]){
		
		System.out.println(System.getProperty("java.io.tmpdir"));
 File file = new File("c:\\test.txt");
 System.out.println(file.getAbsolutePath());
		
	}
	
}

package IO.copy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOClass {


	public static void main(String[] args) {
		
		try{
			FileWriter fw = new FileWriter(new File("c:/test.txt")); // the FileWriter contructor THROWS IOException
		}catch(IOException io){
			io.printStackTrace();
		}

		try{
			FileReader fl = new FileReader(new File("c:/test.txt")); // FileReader constructor THROWS FileNotFoundException;
		}catch(FileNotFoundException fnf){
			fnf.printStackTrace();
		}
	}

}

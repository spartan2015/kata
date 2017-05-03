package serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationClass {
	
	public static void main(String[] args) {
	
		FileOutputStream fos = null;
		try{
			fos = new FileOutputStream("c:/out.txt"); // FileNotFoundException
		}catch(FileNotFoundException fnf){fnf.printStackTrace();}
		
		
		ObjectOutputStream oos = null;
		try{
			oos = new ObjectOutputStream(fos);
		}catch(IOException ioe){ioe.printStackTrace();}
		
		try{
			oos.writeObject(new Cat());
		}catch(IOException ioe){ioe.printStackTrace();}
	}

}


class Cat implements Serializable{
	
}
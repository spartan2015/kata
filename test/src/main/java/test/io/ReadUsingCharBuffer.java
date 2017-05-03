package test.io;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;


public class ReadUsingCharBuffer {
	
	public static void main(String[] args) throws IOException{
		
		FileReader fr = new FileReader("E:/Documents/mseco/banca/RO05BRDE240SV31629622400_04_07_2011 (2).CSV");
		
		StringBuilder sb = new StringBuilder();
		
		CharBuffer cb = CharBuffer.allocate(1024);
		
		int a = 0;
		while( (a = fr.read(cb)) > 0){			
			cb.flip(); // position to 0, limit to earlier position (after last read char)
			sb.append(new String(cb.toString()));
		}
		
		
		String str = sb.toString();
		
		
		// am niste mici prob cu fisierul care il da brdnet - are niste \n in mijlocul unor stringuri si nu pot
		// face importul corect in excel - aici citesc fisierul si fac replace la locurile care au un \n 
		// in mijlocul unui string
		str = str.replace("\nD", "D");
		str = str.replace("\nU", "U");
		
		System.out.println(str);
	
		fr.close();
	}

}

package exceptions;

import java.io.IOException;

public class HandleDeclareNoThrow {
	
	public static void main(String[] args) throws Exception, IOException {
		try{
			System.out.println("ups no exception here");
		}catch(Exception ex){
			ex.printStackTrace();			
		}
	}
}

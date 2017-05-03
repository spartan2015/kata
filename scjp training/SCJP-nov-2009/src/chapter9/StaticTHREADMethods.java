package chapter9;

public class StaticTHREADMethods {

	public static void main(String[] args) {

		// STATIC THREAD METHODS:
		
		
		try{
					
			Thread.sleep(1000); // STATIC
			
		}catch(InterruptedException ex){}
		
		
		Thread.yield(); // STATIC
		
	}

}

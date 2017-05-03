package chapter9;

public class JoinMethod {

	public static void main(String[] args){
		
		/**
		 * JOIN() throw InterruptedException - takes the CURRENT THREAD and joins it at the end of the reference that called t.join(); joins it to t
		 */
		final Thread main = Thread.currentThread();
		
		Thread t1 = new Thread(){
			public void run(){
				try{
					Thread.sleep(1000);
					main.join();
				}catch(InterruptedException ex){ex.printStackTrace();}
				System.out.println("Thread 1");
			}
		};
			
					
		t1.start();		
		
		
		
		try{
			Thread.sleep(2000);
		}catch(InterruptedException ex){ex.printStackTrace();}
		
		System.out.println("MAIN");
		
		
		
	}
	
}

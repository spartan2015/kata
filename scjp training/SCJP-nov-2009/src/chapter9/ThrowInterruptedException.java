package chapter9;

public class ThrowInterruptedException {

	public static void main(String[] args) {

		try{

			Thread t1 = new Thread(){
				public void run(){
					System.out.println("t1");
				}
			};
			
			Thread t2 = new Thread(){
				public void run(){
					
					/**
					 * sleep() throws InterruptedException
					 */
					try{
						Thread.sleep(1000); // STATIC
					}catch(InterruptedException ex){}
					
					
					System.out.println("t2");
				}
			};
			
			/**
			 * JOIN() throws InterruptedException
			 */
			t1.join();			
			
			
			t1.start();
			t2.start();
			
			
			
		}catch(InterruptedException ex){
			System.out.println("We we're interrupted, MAAAN!!");
		}
		
	}

}

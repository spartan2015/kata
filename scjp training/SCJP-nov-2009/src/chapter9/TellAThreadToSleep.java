package chapter9;

public class TellAThreadToSleep {

	public static void main(String[] args) {

		/**
		 * Why:
		 *  - forces threads to take turns
		 *  - maybe you're donwloading stock prices and it makes sense to make a pause between downloads
		 */

		new Thread(){
			public void run(){
				for(int i = 0; i < 3; i++){
					System.out.println("i: " + i);
					try{
						Thread.sleep(1000); // STATIC CALL - at least 1 second but not guaranteed
					}catch(InterruptedException ex){ // SLEEP() throws InterruptedException
						System.out.println("I was interrupted !");
					}
					
				}
			}
		}.start();
	}

}

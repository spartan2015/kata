package threads;

public class BasicThreads {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Runnable r = new Runnable(){
			public void run(){
				System.out.println("job runned by: " + Thread.currentThread().getName());
			}
		};

		for(int i = 0; i < 10; i++){
			new Thread(r).start();
		}
		
		for(int i = 0; i < 10; i++){
			new Thread(r,"MyThread_"+i).start();
		}
	}

}

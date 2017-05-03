package chapter9;

public class FirstMethodOfThreadCreationExtending {

	public static void main(String[] args) {

		System.out.println(Thread.currentThread().getName());
				
		
		new Thread(){
			public void run(){
				System.out.println("Thread 1");
			}
		}.start();
		
		
		new Thread(new Runnable(){
			public void run(){
				System.out.println("Thread 2");
			}
		}).start();
	}

}

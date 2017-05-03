package chapter9;

public class MoreThanTwoThatIs {

	public static void main(String[] args) {

		Runnable r = new Runnable(){
			public void run(){
				for(int i = 0; i < 400; i++){
					System.out.println("Thread: " + Thread.currentThread().getName() + " i is: " + i);
				}
			}
		};
		
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		Thread t3 = new Thread(r);
		
		t1.start();
		t2.start();
		t3.start();
		
	}

}

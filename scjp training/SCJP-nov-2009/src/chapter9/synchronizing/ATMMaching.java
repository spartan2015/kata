package chapter9.synchronizing;

public class ATMMaching {

	public static void main(String[] args) throws Exception {

		final Account account = new Account();
		
		Runnable r = new Runnable(){
			public void run(){
				for(int i=0; i< 10; i++){
					makeWithdrawal();
				}
			}
			
			private synchronized void makeWithdrawal(){
				if (account.getBalance() >= 10){
					System.out.println(Thread.currentThread().getName() + " is withdrawing 10");
					try{
						Thread.sleep(500);
					}catch(InterruptedException ex){}
					account.withdraw(10);
				}else{
					System.out.println("Fred could not find suficient funds: " + account.getBalance());
				}
			}
		};
		
		Thread lucy = new Thread(r,"Lucy");		
		Thread fred = new Thread(r,"Fred");
		
		lucy.start();
		fred.start();
		
//		Thread.sleep(1000);
//		System.out.println("Final balance: " + account.getBalance());
	}

}

package threads;

public class BasicSynchronization {
		
	public static void main(String[] args){
		final Account a = new Account();
		Worker w = new Worker(a);
		new Thread(w,"Fred").start();
		new Thread(w,"Lucy").start();
	}
}

class Worker implements Runnable{
	Account account;
	Worker(Account a){ account = a ;}
	public void run(){
		for(int i = 0; i < 5; i++){
			withdraw(10);
		}
		if (account.getBalance() < 0){
			throw new RuntimeException("Account overdrawn: " + Thread.currentThread().getName() + ", balance is: " + account.getBalance());
		}
	}
	
	public synchronized void  withdraw(int amount){
		if (account.getBalance() >= amount){
			try{
			System.out.println(Thread.currentThread().getName()+" sees a good balance and prepares to withdraw");	
			Thread.currentThread().sleep(500);
			
			}catch(InterruptedException ie) {ie.printStackTrace();}
			account.withdraw(amount);
			System.out.println(Thread.currentThread().getName()+" finished the withdraw");
		}
	}
}

class Account{
	private int balance = 50;
	public int getBalance(){
		return balance;
	}
	public void withdraw(int amount){			
		balance-= amount;
	}
}


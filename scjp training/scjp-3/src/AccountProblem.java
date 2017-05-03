
public class AccountProblem {
	public static void main(String[] args){
		Withdrawer w = new Withdrawer(new Account());
		Thread lucy = new Thread(w,"Lucy");
		Thread fred = new Thread(w,"Fred");
		lucy.start();
		fred.start();
	}
}

class Withdrawer implements Runnable{
	public Account account;
	
	Withdrawer(Account account){
		this.account = account;
	}
	
	public void run(){
		
		for(int i = 0; i < 5; i++){
			withdraw(10);
		}
		
	}
	
	public synchronized void withdraw(int amount){
		System.out.println(Thread.currentThread().getName() + " checks the account...");
		if (account.getBalance() >= amount){
			System.out.println(Thread.currentThread().getName() + " sees that there are enough money to withdraw");
			try{
				Thread.sleep(500);
				System.out.println(Thread.currentThread().getName() + " is withdrawing ...");
				account.withdraw(amount);
			}catch(InterruptedException ie){
				ie.printStackTrace();
			} catch (Exception e) {				
				e.printStackTrace();
			}
		}else{
			System.out.println(Thread.currentThread().getName() + " doest not have enough money to withdraw...");
		}
	}
}

class Account{
	private int balance = 50;
	
	public int getBalance(){
		return balance;
	}
	
	public void withdraw(int amount) throws Exception{
		balance -= amount;
		if (balance < 0){
			throw new Exception("Account balance is negative !!!!!!!");
		}
	}
}

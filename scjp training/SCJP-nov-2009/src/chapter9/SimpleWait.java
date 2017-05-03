package chapter9;

public class SimpleWait {

	public static void main(String[] args){
		Operator operator = new Operator();
		Machine machine = new Machine();
		
		machine.operator = operator;
		
		operator.start();
		machine.start();
	}
	
}

class Operator extends Thread{
	public void run(){
		while(true){
			try{
				Thread.sleep(1000);// does not releseas lock, THROWS InterruptedException
			}catch(InterruptedException ex){ex.printStackTrace();}
			synchronized(this){
				// do calculations
				System.out.println("Operator designing");				
				this.notify();
			}
			try{
				Thread.sleep(3000);// does not releseas lock, THROWS InterruptedException
			}catch(InterruptedException ex){ex.printStackTrace();}
		}
	}
}

class Machine extends Thread {
	public Operator operator;

	public void run() {
		while (true) {
			try{
				Thread.sleep(1000);// does not releseas lock, THROWS InterruptedException
			}catch(InterruptedException ex){ex.printStackTrace();}
			synchronized (operator) {
				try{
					operator.wait();
				}catch(InterruptedException ex){ex.printStackTrace();}
				// daca am trecut de wait (print notify de la operator atunci e clar ca ne apucam de lucru)
				System.out.println("Machine Working!");
			}			 
		}
	}
}

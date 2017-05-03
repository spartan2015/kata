package chapter9.manyTomanyThreads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ManyToManyThreads {
	public static void main(String[] args) {
		List<String> work = new ArrayList<String>();
		List<Operator> operators = new ArrayList<Operator>();
		List<Worker> workers = new ArrayList<Worker>();
		
		for (int i = 0; i < 10; i++) {
			Worker worker = new Worker();
			worker.todo = work;
			workers.add(worker);
			worker.name = "Worker " + i;
			Thread thread = new Thread(worker, "Worker " + i);
			thread.start();
		}

		for (int i = 0; i < 10; i++) {
			Operator operator = new Operator();
			operator.work = work;
			operators.add(operator);
			Thread thread = new Thread(operator, "Operator " + i);
			thread.start();

			if (i == 9) {
				try {

					thread.join();
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		}
		
		try{
		Thread.sleep(3000);
		}catch(InterruptedException ex){ex.printStackTrace();}
		
		System.out.println("Worker status: ");
		
		for(Worker worker : workers){
			System.out.println(worker.name + " did " + worker.workDone);
		}
	}
}

class Operator implements Runnable {
	public List<String> work;
	public int workDone;
	public int doWork = 10;

	public void run() {
		while (doWork-- > 0) {
			try {
				Thread.sleep(random(1, 3) * 1000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}

			synchronized (work) {
				System.out.println(Thread.currentThread().getName()
						+ " is done.");
				work.add(Thread.currentThread().getName());
				work.notifyAll();
				workDone++;
			}

			
		}
	}
	
	private static Random random = new Random();
	public static int random(int min, int max){
		int dif = max - min;
		return min + random.nextInt(dif + 1);
	}
}

class Worker implements Runnable {
	public List<String> todo;
	public int workDone;
	public String name;
	public void run() {
		while (true) {
			try {
				Thread.sleep(Operator.random(1, 3) * 1000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			synchronized (todo) {
				while (todo.isEmpty()) {
					try {
						todo.wait();
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
				}

				System.out.println(Thread.currentThread().getName()
						+ " doing operator " + todo.get(0));
				todo.remove(0);
				workDone++;
			}
		}
	}
}
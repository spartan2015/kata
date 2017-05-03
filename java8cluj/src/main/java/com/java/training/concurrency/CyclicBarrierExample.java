package com.java.training.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import javax.swing.JButton;

public class CyclicBarrierExample {

	public static void await(CyclicBarrier cb){
		try {
			cb.await(); // throw InterruptedException and BrokenBarrierException
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			
		} catch (BrokenBarrierException e) {
			
			e.printStackTrace();
		}
	}
	//2125
	public static void main(String[] args){
		
		final CyclicBarrier cb = new CyclicBarrier(3,()->{
			System.out.println("Clean");
		});
		
		ExecutorService executorService = Executors.newScheduledThreadPool(2); // the number is fixed ! 
		
		IntStream.iterate(1, i->i+1).limit(12).forEach(i->{
			executorService.submit(()->{
				System.out.println("i " + i + Thread.currentThread().getName());
				await(cb);
			});
		});
		
		JButton button = new JButton();
		button.addActionListener(e->{
			System.out.println("Button pressed");
		});
		
		executorService.shutdown();
		// prediction - barrier opens at every 3 calls - outputs clean; // prob - 2 threads does it grow ? say no - it will not print anything and wait forever
		// I was correct;
		
	}
	
}





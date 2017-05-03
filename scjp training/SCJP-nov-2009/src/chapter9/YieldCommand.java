package chapter9;

public class YieldCommand {

	public static void main(String[] args){
		
		/**
		 * YIELD() - is connected with the concept of PRIORITIES - the Thread yields for a higher priority Thread to run
		 * 
		 * THE BEHAVIOUR IS NOT GUARANTEED
		 * 
		 * PRIORITY of a Thread:
		 * - it usualy has the same priority as the Thread that started it
		 * - it can be set using setPriority(8)
		 * 
		 */
		
		int p1 = Thread.MIN_PRIORITY;
		int p2 = Thread.NORM_PRIORITY;
		int p3 = Thread.MAX_PRIORITY;
		
	}
	
}

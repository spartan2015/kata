package utils;

import java.util.concurrent.Callable;

public class TimerUtils {
	public static <T> T timed(Callable<T> task){
		long start = System.currentTimeMillis();
		T result;
		try {
			result = task.call();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		System.out.println("Duration: " + (System.currentTimeMillis()-start));
		return result;
	}
	
	public static void timed(Runnable task){
		long start = System.currentTimeMillis();
		try {
			task.run();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		System.out.println("Duration: " + (System.currentTimeMillis()-start));
	}
	
}

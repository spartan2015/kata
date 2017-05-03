package java8.third;

import java.util.stream.IntStream;

public class Java8Catches {

	public Java8Catches() {
		
		//Object o = ()->{ System.out.print("");};
        
		//()->{"";};
		
		
		
	}

	public void t() {
		// effectively final
		int sum = 0;
//		IntStream.range(0, 1).forEach((e) -> sum += e); // final or effectively final
	}

	interface Act {
		void act();
	}

	public static void someM(Act a) {
	}

	public static void someM(Runnable a) {
	}

	public static void use() {
		//someM(() -> {}); // ambiguous
	}
}

package java8.third;

import java.util.stream.IntStream;

public class Java8Catches {

	public Java8Catches() {
		
		Object o = ()->{ System.out.print("");};
        
		()->{"";};
		
		
		
	}

	public void t() {
		// effectively final
		int sum = 0;
		IntStream.range(0, 1).forEach((e) -> sum += e); // final or effectively
														// final
	}
	
	public void t2(){
		double d = 4.; // COMPILES
		
	}
	
	public void ft(){
		float f1 = 102;
		float f2 = (int)102.2;
		float f3 = 1f * 0.0;
		
		float f41 = 1f * (float)0.0; // I WOULD HAVE NOT EXPECTED THIS TO WORK - anything but double will work here
		float f42 = 1f * (char)0.0; // I WOULD HAVE NOT EXPECTED THIS TO WORK - anything but double will work here
		float f43 = 1f * (short)0.0; // I WOULD HAVE NOT EXPECTED THIS TO WORK - anything but double will work here
		float f44 = 1f * (int)0.0; // I WOULD HAVE NOT EXPECTED THIS TO WORK - anything but double will work here
		float f45 = 1f * (long)0.0; // I WOULD HAVE NOT EXPECTED THIS TO WORK - anything but double will work here
		
		float f5 = 1f * (boolean)0;
		
	}

	public void switcFinal() {
		final String a;

		a = "b";

		switch ("") {
		case a: {

		}
		}
	}

	interface Act {
		void act();
	}

	public static void someM(Act a) {
	}

	public static void someM(Runnable a) {
	}

	public static void use() {
		someM(() -> {
		}); // ambiguous
	}

}

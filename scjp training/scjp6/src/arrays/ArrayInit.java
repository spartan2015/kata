package arrays;

import java.util.Arrays;

public class ArrayInit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 4;
		
		int[] ar = {1,2,3,i};
		
		int[][] ar2 = {{1,2},
					   {3,4}};
		
		for(int x : ar){
			System.out.println(x);
		}
		
		// or better
		System.out.println(Arrays.toString(ar));
		
		// WATCH FOR THIS !!! a short, byte, char array references cannot be assigned to a int[] array reference ! 
		//- weird stuff, in c ontrast with object arrays
		char[] ch = new char[2];
		int[] ints = new int[2];
		
		//ints = ch; // COMPILER ERROR, event if char can be promoted to int but with object there is a dif
		
		class Car{}
		class Ferrary extends Car{}
		
		Car[] cars = new Car[2];
		Ferrary[] fers = new Ferrary[2];
		
		cars = fers; // OK, CONTRAST to int[] a = new short[2] ERROR
		
		
		
		
	}

}

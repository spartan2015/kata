package bitwise;

/*
 * given a total that represents the sum a n consecutive numbers
 * from 0 to n - find out which number is missing - one operation
 * 
 * */
public class XorProblem {
	public static void main(String[] args){
		
		int[] numbers = {1,2,3};
		
		//System.out.println(Integer.toString(4, 2));
		//System.out.println(Integer.toString(4 , 2));
		
		int andul = 0 ; // t are toti bitii pe 1 - vezi cati biti are cel mai mare number - si fai pe toti
		int xor = 3;
		for(int x = 0; x< numbers.length; x++){
			//System.out.println("fin " + Integer.toString(fin,2) + " xoring with " +Integer.toString(numbers[x],2) );
			
			//System.out.println( Integer.toString(numbers[x] ^ 7,2));
			
			andul = andul | numbers[x];
			xor = xor ^ numbers[x];
		}
		
		
		System.out.println("andul: " + Integer.toString(andul , 2) + " wich is: " + andul);
		System.out.println("xorul: " + Integer.toString(xor , 2) + " wich is: " + xor);
		
		//System.out.println("fin " + (andul & 7));
		
		//System.out.println(Integer.toString(7 , 2));
		
		//System.out.println( "mising number is = " + fin); din bitul 111 care reprezin 7 vrei numai o data sa inlaturam bitii setati aceiasi -
		
		// NO SOLUTION WITH XOR
		
	}
}

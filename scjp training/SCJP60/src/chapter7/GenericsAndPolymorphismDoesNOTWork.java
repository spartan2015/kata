package chapter7;

import java.util.*;

public class GenericsAndPolymorphismDoesNOTWork {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Integer extends Number
		List<Number> list = new ArrayList<Integer>(); // Type mismatch: cannot convert from ArrayList<Integer> to List<Number>

		// BURN INTO MEMORY
		
		List<Object> list1 = new ArrayList<Double>(); // Type mismatch: cannot convert from ArrayList<Integer> to List<Number>
		
		// wildcard as a solution
		List<?> listOfAnything = new ArrayList<Integer>(); // this WORKS
		List<? extends Number> numbers = new ArrayList<Integer>(); // WORKS
		List<? extends Number> numbers1 = new ArrayList<Number>(); // WORKS
		List<? super Integer> ns = new ArrayList<Number>(); //WORKS		
		List<? super Integer> ns1 = new ArrayList<Integer>(); //WORKS
		
		
		List<Integer> integers = new ArrayList<Integer>();		
		get(integers); // - BAD - he method get(List<Number>) in the type GenericsAndPolymorphismDoesNOTWork is not applicable for the arguments (List<Integer>)
		
		
		// CONCLUSION: generic collections and polymorphism does NOT work - the declared type and the constructor type MUST BE IDENTICAL
		
		// GENERIC COLLECTIONS !BAD!=NOT! POLYMORPHISM
		
		
		// the WEIRD part is that arrays SUPPORT polymorphism
		
		Object[] os = new Integer[3]; // THIS WORKS 
		
		
		// THIS WORKS - this list can hold polymorphic objects 
		List<Number> numbers = new ArrayList<Number>();
		numbers.add(new Integer(1));
	
		got(numbers); // The method got(List<Object>) in the type GenericsAndPolymorphismDoesNOTWork is not applicable for the arguments (List<Number>)
	}
	
	public static void got(List<Object> list){}
	
	public static  void get(List<Number> numbers){
		
	}

}

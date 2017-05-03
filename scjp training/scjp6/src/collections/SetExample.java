package collections;

import java.util.HashSet;
import java.util.Set;

public class SetExample {
	
	public static void main(String[] args) {
		
		// HashSets do not guarantee any ordering.
		Set<String> set = new HashSet<String>();
		
		boolean b = set.add("1");
		System.out.println("adding 1: " + b);
		b = set.add("1");
		System.out.println("adding 1: " + b);
		
		// ALL ELEMENTS OF A SET MUST BE MUTUABLY COMPARABLE if you want SORT
		// set.add(new Integer(1)); // this would work if not for the generics restrictions on the compiler
		
	}

}

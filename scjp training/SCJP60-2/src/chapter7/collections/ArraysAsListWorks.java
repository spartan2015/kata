package chapter7.collections;

import java.util.Arrays;
import java.util.List;

public class ArraysAsListWorks {

	public static void main(String[] args) {
		
		String[] a = {"one","two","three"};
		List<String> al = Arrays.asList(a); // daca era primitiva n-ar fi mers
		
		System.out.println(al);
		
		for(String s : al){
			System.out.println(s);
		}

	}

}

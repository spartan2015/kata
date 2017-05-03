package myexperiments.generics;

import java.util.Arrays;
import java.util.List;

class Person {
	private String cnp;

	Person(String val) {
		cnp = val;
	}

	public String getCnp() {
		return cnp;
	}

	public boolean equals(Object o) {
		String[] sa = {"one", "two", "three", "four"};
		List<String> aList = Arrays.asList(sa); // make a List
		String[] ar = (String[])aList.toArray();
		
		return false;
		
	}
}

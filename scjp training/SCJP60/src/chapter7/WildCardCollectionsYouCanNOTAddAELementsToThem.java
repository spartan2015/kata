package chapter7;

import java.util.ArrayList;
import java.util.List;

public class WildCardCollectionsYouCanNOTAddAELementsToThem {

	
	public static void main(String[] args) {
		
		List<Integer> integers = new ArrayList<Integer>();
				
		get(integers);
	}
	
	static void get(List<? extends Number> list){
		list.add(null); // OK
		list.add(new Integer()); // BAD
	}

	static void got(List<? super Dog> animals){
		animals.add(new Dog());
	}
}

class Animal{}
class Dog extends Animal {}
class Cat extends Animal {}


package chapter7.collections;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ArrayListUsage {

	
	public static void main(String[] args) {
	
		List<String> list = new ArrayList<String>();
		
		list.add("a");
		list.add(0, "b");
		
		System.out.println(list);
		
		System.out.println(list.contains(42));
		
		list.remove(0); // index
		list.remove("a"); // Object
				
		System.out.println(list);
		
	}

}

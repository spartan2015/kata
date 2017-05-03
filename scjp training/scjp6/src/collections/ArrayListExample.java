package collections;

import java.util.*;

public class ArrayListExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		List<String> list = new ArrayList<String>();

		list.add("2");
		list.add(0,"1");
		int index = list.indexOf("1");
		System.out.println(index);
		
		System.out.println(list.get(0));;
		
		list.remove(1);
		list.remove("2");
		
		boolean b = list.contains("2");
		System.out.println(b);
	}

}

package chapter7GenericsAndCollections.collections;

import java.util.ArrayList;
import java.util.List;

public class Lists {

	
	public static void main(String[] args) {
		

		List<String> list = new ArrayList<String>();
		
		list.add("a");
		list.add(1,"b");
		
		System.out.println(list.get(1));
		
		System.out.println(list.indexOf("b"));
		
	}

}

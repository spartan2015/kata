package chapter7GenericsAndCollections.collections;

import java.util.Arrays;
import java.util.List;

public class JoinedAtTheHipArrayAndList {

	public static void main(String[] args){
		
		String[] ar = {"a","b","c"};
		
		List<String> list = Arrays.asList(ar);
		
		System.out.println(list);
		
		list.set(0, "x");
				
		System.out.println(Arrays.toString(ar));
		
		list.add("e");
		
		System.out.println(Arrays.toString(ar));
	}
	
}

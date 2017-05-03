package collections;

import java.util.Arrays;
import java.util.List;

public class JoinedAtTheHip {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] strs = {"1","2","3"};
		List<String> list = Arrays.asList(strs); // returns a fixed size list - no elements can be added - weird ha ? 

		System.out.println(list);
		strs[0]="11";
		System.out.println(list);		
		list.add("4");
		System.out.println(list); // Exception in thread "main" java.lang.UnsupportedOperationException
		
		String[] s2 = new String[2]; 
		s2 = list.toArray(s2);
	}

}

package chapter7GenericsAndCollections.generics;

import java.util.ArrayList;
import java.util.List;

public class WeirdGenericsReferences {

	public static void main(String[] args) {

		
		List<? extends Object> l1 = new ArrayList<String>();
				
		
		List<? extends Dog> l2 = new ArrayList<Dog>();
		
		
		List<? extends Dog> l3 = new ArrayList<Cat>();
		
		
		
		List<? super Dog> l4 = new ArrayList<Object>();
		
		
		List<? super Dog> l5 = new ArrayList<Dog>();
		
		
		List<? super Dog> l6 = new ArrayList<Animal>();
		
		final String z = "asd";
		
		class Inner {
			void man(){
				System.out.println(z);
			}
		}
	}

}

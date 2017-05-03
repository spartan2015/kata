package chapter7GenericsAndCollections.generics;

import java.util.List;

public class WildCardWithExtendsAndSuper {

	public static void main(String[] args) {

	}

	static void doer(List<? super Dog> list){
		
	}	
}


class Animal {}
class Dog extends Animal{}
class Cat extends Dog{}
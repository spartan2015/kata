package chapter4;

public class InstanceOf {

	
	public static void main(String[] args) {
	
		// 1. null instaceof Object = FALSE
		System.out.println(null instanceof Object);
		
		// 2. you can't se instanceof to compare on completly different hierachies - COMPILER ERROR
		Dog dog = new Dog();
		System.err.println(dog instanceof Cat); // incompatible conditionla operands 
		
		
	}

}


class Cat{}
class Dog{}
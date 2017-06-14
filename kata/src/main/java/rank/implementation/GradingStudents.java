package rank.implementation;

import java.util.Scanner;
import java.util.TreeSet;

public class GradingStudents {
	
	static TreeSet<Integer> multiplesOf5 = new TreeSet<Integer>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		for(int i = 1; i <=20; i++){
			multiplesOf5.add(5 * i);	
		}
		
		for(int i =0; i < n; i++){
			int grade = in.nextInt();
			System.out.println(round(grade));
		}
	}

	private static int round(int grade) {
		Integer nextHigher = multiplesOf5.higher(grade);
        if (nextHigher == null) return grade;
        
		if (nextHigher >= 40 && nextHigher - grade  < 3){
			return nextHigher;
		}else{
			return grade;
		}
	}
	
}

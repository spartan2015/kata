package hackerRank.recursive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class PasswordCrackerDynamicProgramming {

	@Test
	public void test(){
		isItPossible(3, new String[] {"ab","abcd","cd"}, new ComboFast(), "axbcd");
		
		
	}
	
	@Test
	public void test1(){
		isItPossible(6, new String[] {"because", "can","do","must", "we", "what"}, new ComboFast(), "wedowhatwemustbecausewecan");
	
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		
		for(int i =0; i< testCases; i++){
			
			check(in);
			
		}
	}

	private static void check(Scanner in) {
		int noPass = in.nextInt();
		String[] passes = new String[noPass];
		for(int i =0; i< noPass; i++){
			passes[i]= in.next();
		}
		String compareWith = in.next();
		
		ComboFast res = isItPossible(noPass,passes, new ComboFast(),compareWith);
		if (res == null){
			String def = "WRONG PASSWORD";
			System.out.println(def);
		}
		
	}

	static class ComboFast{
		List<String> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		int length = 0;
	}
	
	private static ComboFast isItPossible(int noPass,String[] passes , ComboFast currentCombo, String compareWith) {
		
		if (currentCombo.length == compareWith.length()){
			print(currentCombo.list);
			return currentCombo;
		}
		
		for(int i = 0; i < passes.length; i++){
			
			if ((currentCombo.length + passes[i].length()) <= compareWith.length() && startsWith(currentCombo, compareWith, passes[i])){
				ComboFast attempt = new ComboFast();
				attempt.list.addAll(currentCombo.list);
				attempt.list.add(passes[i]);
				attempt.sb.append(currentCombo.sb).append(passes[i]);
				attempt.length=currentCombo.length+passes[i].length();
				
				ComboFast result = isItPossible(noPass, passes, attempt , compareWith);
				if (result!=null) return result;
			}
			
		}
		
		return null;
	}

	private static boolean startsWith(ComboFast currentCombo, String compareWith, String newStr) {
		int index = 0;
		while(index < newStr.length()){
			if (compareWith.charAt(currentCombo.length + index) != newStr.charAt(index)){
				return false;
			}
			index++;
		}
		return true;
	}

	private static boolean match(ComboFast currentCombo , String compareWith) {
		String matchingWith = currentCombo.sb.toString();
		//System.out.println("testing with: " + matchingWith);
		return matchingWith.equals(compareWith);
	}

	private static void print(List<String> soFar) {
		for(String s: soFar){
			System.out.print(s + " ");
		}
		System.out.println();
	}
	
}

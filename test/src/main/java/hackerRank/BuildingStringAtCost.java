package hackerRank;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BuildingStringAtCost {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		for(int i =0; i< n; i++){
			System.out.println(buildingString(in));
		}
	}

	private static int buildingString(Scanner in) {
		return countLetters(in.nextLine()).size();
	}
	
	private static Map<String, Long>  countLetters(String a) {
		return Arrays.stream(a.split("")).filter(s->s.length()>0).collect(Collectors.groupingBy(s->s, Collectors.counting()));
	}
}

package hackerRank.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Gemstones {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();

		Set<String> gems = new HashSet();
		for (int i = 0; i < n; i++) {
			String str = in.next();
			if (i==0){
				gems.addAll(unique(str));
			}else{
				gems.retainAll(unique(str));
			}
		}
		
		System.out.println(gems.size());
	}

	private static Set unique(String str){
		return Arrays.stream(str.split("")).filter(s->s.length()==1).collect(Collectors.groupingBy(a->a)).keySet();
	}
}

package combinatorics.s2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

public class Permutations {

	@Test
	public void test(){
		List<String> permutations = permute("abc");
		permutations.forEach(System.out::println);
	}

	private List<String> permute(String string) {
		
		return permute(string,0);
	}

	private List<String> permute(String string, int index) {
		if (index == string.length()-1){
			return Arrays.asList(string.substring(string.length()-1));
		}else{
			List<String> permutations = new ArrayList<>();
			String s = ""+string.charAt(index);
			List<String> prevPermutations = permute(string, index+1);
			
			for(String perm : prevPermutations){
				permutations.addAll(combine(s, perm));
			}
			return permutations;
		}
	}

	private Collection<? extends String> combine(String s, String perm) {
		List<String> combinations = new ArrayList<>();
		for(int i =0; i<perm.length()+1; i++){
			combinations.add(perm.substring(0,i) + s + perm.substring(i));
		}
		return combinations;
	}
	
}

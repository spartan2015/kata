package combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PermutationsSecond {

	@Test
	public void test(){
		for(char[] ch : permute("abc".toCharArray(),2)){
			System.out.println(Arrays.toString(ch));
		}
	}

	private List<char[]> permute(char[] charArray, int index) {
		if (index == 0){
			return Arrays.asList(new char[]{charArray[0]});
		}else{
			List<char[]> permutations = permute(charArray, index-1);
			List<char[]> result = new ArrayList<>();
			char newChar = charArray[index]; 
			for(char[] permutation : permutations){
				int newLength = index+1;
				result.addAll(combineWithNewChar(newChar, permutation, newLength));
			}
			return result;
		}
	}

	private List<char[]> combineWithNewChar(char newChar, char[] permutation, int newLength) {
		List<char[]> result = new ArrayList<>();
		for(int i = 0; i< newLength; i++){
			char[] newPermutation = new char[newLength];
			newPermutation[i] = newChar;
			int permutationIndex = 0;
			for(int j = 0; j < newLength; j++){
				if (j!=i){
					newPermutation[j]=permutation[permutationIndex++];
				}
			}
			result.add(newPermutation);
		}
		return result;
	}
	
}

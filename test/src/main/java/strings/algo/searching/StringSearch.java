package strings;

import java.util.HashMap;
import java.util.Map;

public class StringSearch {

	public static void main(String[] args){
		System.out.println(searchNaive("truth","i am the truths inside"));
		System.out.println(searchBoyerMoorHorspool("truth","i am the truths inside"));
		
	}
	
	public static int searchNaive(String toFind, String toSearch){
		for(int i = 0; i <= toSearch.length() - toFind.length(); i++){
			for(int j = 0; j < toFind.length(); j++){
				if (toSearch.charAt(i + j) != toFind.charAt(j)){
					break;
				}
				if (j == toFind.length()-1){
					return i;
				}
			}
		}
		return -1;
	}
	
	public static int searchBoyerMoorHorspool(String toFind, String toSearch){
		int defaultSkip = toFind.length();
		Map<String, Integer> skipMap = new HashMap<>();
		for(int i = toFind.length() -2, j = 1; i>0 ; i--,j++){
			skipMap.put(toFind.charAt(i)+"", j);
		}	
		int currentIndex = defaultSkip -1;
		while(currentIndex < toSearch.length() - defaultSkip){
			for(int i = toFind.length()-1, j = 0; i>=0; i--, j++){				
				if (toSearch.charAt(currentIndex - j)!=toFind.charAt(i)){
					//System.out.printf("compare %s(%d) = %s(%d)",toSearch.charAt(currentIndex - j),currentIndex - j,toFind.charAt(i),i);
					currentIndex+=skipMap.getOrDefault(toSearch.charAt(currentIndex - j)+"", defaultSkip);
					break;
				}
				if (i ==0){
					return currentIndex - defaultSkip + 1;
				}
			}
		}
		return -1;
	}
	
}

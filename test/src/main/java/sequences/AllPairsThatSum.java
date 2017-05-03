package sequences;

import java.util.Arrays;

public class AllPairsThatSum {

	void find(int[] arr , int sum){
		Arrays.sort(arr);
		
		int first =0;
		int last = arr.length-1;
		
		while(first < last){
			int s = arr[first] + arr[last];
			if (s == sum){
				System.out.println(arr[first] + " + " + arr[last] + " = " + sum);
				++first;
				--last;
			}else{
				if (s < sum) first++;
				else last--;
			}
		}
	}
}

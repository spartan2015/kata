package sequences;

public class FindLargestSumInASequence {

	public int find(int[] arr){
		int maxsum = 0;
		int sum = 0;
		for(int i =0; i < arr.length; i++){
			sum+=arr[i];
			if (maxsum < sum){
				maxsum = sum;
			}else if (sum < 0){ // 
				sum = 0; // reset to 0 when it dropped
			}
		}
		return maxsum;
	}
	
}

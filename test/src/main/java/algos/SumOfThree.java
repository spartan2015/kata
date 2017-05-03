package algos;

import org.junit.Test;

public class SumOfThree {

	@Test
	public void t(){
		
		int N = 3; // (N * (n-1) * (N -2)) /6 = 3 * 2 * 1 + 
		int count = 0;
		
		for(int i = 0; i < N; i++)
			for(int j = i+1; j < N; j++)
				for(int k = j+1; k < N; k++)
					count++;
		System.out.println(count);
		
	}
	
}

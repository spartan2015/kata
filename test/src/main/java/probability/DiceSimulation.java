package probability;

import org.junit.Test;

public class DiceSimulation {
	int SIDES = 6;
	double[] dist = new double[2 * SIDES + 1];
	
	public DiceSimulation() {
		for (int i = 1; i <= SIDES; i++)
			for (int j = 1; j <= SIDES; j++)
				dist[i + j] += 1.0;
		
		for (int k = 2; k <= 2 * SIDES; k++)
			dist[k] /= SIDES * SIDES;		
	}
	
	public double prob(int value) {
		return dist[value];
	}
	
	@Test
	public void test(){
		for(int i = 2; i <= 2 * SIDES; i++){
			System.out.printf("%d with prob %.3f \n", i, prob(i));
		}
	}
	
}

package algos;

import org.junit.Test;

/**
 * Created by Battlestar on 2/6/2015.
 */
public class GreatestCommonDenominator {

    @Test
    public void t(){
        for(int i = 2; i < 1000; i*=i){
            int q = i + 16;
            System.out.println("gcp of " + i + "," +(q) + " = " + gcp(i, q));
        }
    }

    int gcp(int p, int q){
        return q == 0 ? p : gcp(q, p%q);
    }
}

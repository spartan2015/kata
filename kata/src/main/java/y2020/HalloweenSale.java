package y2020;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * HalloweenSale
 * /challenges/halloween-sale/problem
 */
public class HalloweenSale {


    static int howManyGames(int p, int d, int m, int s) {
        int count = 0;
        while(s >= m && p <=s){
            s-=p;
            p = Math.max(p-d, m);
            count++;
        }
        return count;
    }

    @Test
    public void t1(){

        assertEquals(5,howManyGames(20,3,6,70));

    }

}

package y2020;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * FlatlandSpaceStations
 *
 * /challenges/flatland-space-stations/problem
 *
 *
 */
public class FlatlandSpaceStations {

    static int flatlandSpaceStations(int n, int[] c) {
        Arrays.sort(c);
        int max = 0;
        max = Math.max(max, c[0] -0  );
        max = Math.max(max, n - c[c.length-1]-1 );

        for(int i = 1; i < c.length; i++){
            max = Math.max(max, (c[i]-c[i-1]) / 2);
        }

        return max;
    }

    @Test
    public void t1(){
        assertEquals(0,flatlandSpaceStations(6, new int[]{0,1,2,4,3,5}));
    }
    @Test
    public void t2(){
        assertEquals(2,flatlandSpaceStations(5, new int[]{0,4}));
    }


}

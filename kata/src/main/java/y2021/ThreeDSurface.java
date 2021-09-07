package y2021;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * /challenges/3d-surface-area/problem
 */
public class ThreeDSurface {

    public static int surfaceArea(List<List<Integer>> A) {

        int sum = 0;

        for (int row = 0; row < A.size(); row++) {
            for (int column = 0; column < A.get(row).size(); column++) {
                sum+=2; // up down
                int value= A.get(row).get(column);
                // side 1
                if (column == 0 ){
                    sum += value;
                } else {
                    if (value > A.get(row).get(column -1)){
                        sum += value - A.get(row).get(column -1);
                    }
                }
                // side 2
                if (row == 0 ){
                    sum += value;
                } else {
                    if (value > A.get(row-1).get(column)){
                        sum += value - A.get(row -1).get(column);
                    }
                }
                // side 3
                if (column == A.get(row).size() -1 ){
                    sum += value;
                } else {
                    if (value > A.get(row).get(column+1)){
                        sum += value - A.get(row).get(column+1);
                    }
                }
                // side 4
                if (row == A.size() -1 ){
                    sum += value;
                } else {
                    if (value > A.get(row+1).get(column)){
                        sum += value - A.get(row+1).get(column);
                    }
                }

            }
        }

        return sum;
    }

    @Test
    public void t1(){
        assertEquals(Integer.valueOf(6), (Integer)surfaceArea(Arrays.asList(Arrays.asList(1))));
    }

    @Test
    public void t2(){
        assertEquals(Integer.valueOf(60), (Integer)surfaceArea(
                Arrays.asList(
                        Arrays.asList(1,3,4),
                        Arrays.asList(2,2,3),
                        Arrays.asList(1,2,4)
                )
        ));
    }

}

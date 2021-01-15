package y2020;

import org.junit.Test;

import java.util.Arrays;

/**
 * Priyanka
 * /challenges/priyanka-and-toys
 */
public class Priyanka {
    @Test
    public void t1() {

    }

    static int toys(int[] w) {
        Arrays.sort(w);
        int cont = 1;
        int minIndex = 0;
        for(int i = 1; i < w.length; i++){
            if ( w[i] > 4 + w[minIndex] ){
                cont++;
                minIndex = i;
            }
        }
        return cont;

    }
}

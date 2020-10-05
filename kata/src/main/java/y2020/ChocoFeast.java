package y2020;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * /chocolate-feast/problem
 *
 */
public class ChocoFeast {

    @Test
    public void t1() {
        assertEquals(9, chocolateFeast(15,3,2));

    }

    // Complete the chocolateFeast function below.
    static int chocolateFeast(int n /*money*/, int c /*cost of chocoe*/, int m /*wrappers of choco he can turn to choco*/) {

        int total = n/c; // money to choco

        int wrappers = total;

        while( wrappers >= m){
            int newChocos = wrappers / m;
            total += newChocos;
            wrappers += newChocos;
            wrappers -= m * newChocos;
        }

        return total;

    }


}

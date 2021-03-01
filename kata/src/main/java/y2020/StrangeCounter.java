package y2020;

import org.junit.Test;

/**
 * /challenges/strange-code/problem
 */
public class StrangeCounter {

    // Complete the strangeCounter function below.
    static long strangeCounter(long t) {
        long cycle =
                Double.valueOf(
                        Math.ceil(
                            Math.log((new Double(t) + 3) / 3)
                                    / Math.log(2)
                )
                ).longValue();
        double p = Math.pow(2, cycle - 1);
        long start = 3 * new Double(p).longValue();
        long rem = t - (3 *
                (new Double(p).longValue() - 1)
        );
        return start - (rem - 1);
    }

    @Test
    public void t1(){
        strangeCounter(4);
    }

    long s1(long t){
        int r = 3;
        while( t > r){
            t-=r;
            r*=2;
        }
        return r - t + 1;
    }
}

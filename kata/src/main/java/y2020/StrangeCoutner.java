package y2020;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * /challenges/strange-code/problem
 */
public class StrangeCoutner {


   static long strangeCounter(long t) {
        double div = t/3;
       long pow = (int)Math.ceil(Math.log(div));
       long startT = (long) (3 * Math.pow(2, pow)) +1;
       //int endT = 3 * Math.pow(2, pow+1)-1;

       return  (long)(3 * Math.pow(2, pow+1)) -(t-startT);
    }

    @Test
    public void t1() {
        assertEquals(6, strangeCounter(4));
        assertEquals(5, strangeCounter(5));
        assertEquals(4, strangeCounter(6));

      /*  for(int t = 1; t < 10; t++){
            System.out.println(  Math.log(t/3) );
        }*/

    }


}

package algos;

import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;

/**
 * Created by Battlestar on 1/27/2015.
 */
public class Fibonaci {

    @Test
    public void test(){
        assertTrue(6 == factorial(3));
        System.out.println(fibonaci(3));

        assertTrue(1 ==fibonaciIncrement(0));
        assertTrue(1 ==fibonaciIncrement(1));
        assertTrue(2 ==fibonaciIncrement(2));
        assertTrue(3 ==fibonaciIncrement(3));
        assertTrue(5 ==fibonaciIncrement(4));
        assertTrue(8 ==fibonaciIncrement(5));
        assertTrue(13 ==fibonaciIncrement(6));
    }

    @Test
    public void generateFibonaci(){
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]}).limit(10).forEach(t -> {System.out.println(t[1]);});
    }

    int fibonaci(int i){
        if (i ==0 | i == 1){
            return 1;
        }
        return fibonaci(i-1)+fibonaci(i - 2);
    }

    int factorial(int i){
        if (i < 1){
            return 0;
        }
        return i == 1 ? 1 :  i*factorial(i-1);
    }

    int fibonaciIncrement(int k){
        if (k < 2 ) return 1;
        int f1 = 1;
        int f2 = 1;
        int i = 2;
        while(i <= k){
            int tmp = f1;
            f1 = f2;
            f2 = tmp + f2;
            i++;
        }
        return f2;
    }

    int fibonaciArray(int k){
        if (k < 2 ) return 1;
        int f1 = 1;
        int f2 = 1;
        int[] sumeFibonaci = {1,1};
        int i = 2;
        while(i <= k){
            sumeFibonaci [i] = sumeFibonaci[i-1] + sumeFibonaci[i-2] ;
            i++;
        }
        return sumeFibonaci[i-1];
    }
}
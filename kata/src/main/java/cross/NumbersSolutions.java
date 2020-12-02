package cross;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Purpose of NumbersSolutions is
 */
public class NumbersSolutions {

    public int solution(int N) {
        // there is a set of numbers - function is Math.pow(2,P)*Math.pow(3,Q) where p and q are positive integer
        // set start is 1,2,3,4,6,8,9,12
        //  given N, what is the value -> N = 4 -> 6
        // N between 0 and 200
        // the numbers in the set are some power of 2  * 3 to some power
        // but how can

        // a[0] = 1     0, 0  -> 1*1
        // a[1] = 2 -   1, 0     2*1
        // a[2] = 3-> , 0, 1     1*3
        // a[3] = 4-> , 2, 0     4*1
        // a[4] = 6-> , 1, 1     2*3 // breaks here (
        // a[5] = 8->   3, 0     8*1
        // a[6] = 9->   0, 2     1*9
        // a[7] = 12->  2, 1     4*3

        // so we can only assume that in the we include all no that are powers of that - first 200 -

        List<Integer> set = new ArrayList();
        int i = 0;
        while(set.size() < 200){
            i++;
            if (isPow(i)){
                System.out.println(i);
                set.add(i);
            }
        }


        return set.get(N);
    }

    public boolean isPow(int i){
        int pow2 = 0;
        while( i % 2 == 0){
            pow2++;
            i/=2;
        }
        int pow3=0;
        while( i % 3 ==0){
            pow3++;
            i/=3;
        }
        if (i == 1){
            return true;
        }else{
            return false;
        }
    }


    @Test
    public void t1(){
        System.out.println(solution(20));
    }
}

package rank.implementation;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created on 6/12/2017.
 *You are given an integer

 . Print the factorial of this number.

 Input
 Input consists of a single integer
 , where
 .
 Output
 Print the factorial of

 .
 * /challenges/extra-long-factorials/submissions
 */
public class ExtraLongFactorials {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        BigInteger bigInteger = BigInteger.valueOf(1);
        for(int i = 2; i <= n; i++){
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
        }
        System.out.println(bigInteger.toString());
    }
}

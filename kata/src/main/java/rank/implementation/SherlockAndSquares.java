package rank.implementation;

import org.junit.Test;

import javax.xml.transform.sax.SAXSource;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created on 6/12/2017.
 *
 * Watson gives two integers (

 and

 ) to Sherlock and asks if he can count the number of square integers between

 and

 (both inclusive).
 Note: A square integer is an integer which is the square of any integer. For example, 1, 4, 9, and 16 are some of the square integers as they are squares of 1, 2, 3, and 4, respectively.
 */
public class SherlockAndSquares {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int a = in .nextInt();
            int b = in.nextInt();
            int count = 0;
            System.out.println((int)Math.floor(Math.sqrt(b)) - (int)Math.ceil(Math.sqrt(a))+1);
        }
    }
}

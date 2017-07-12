package rank.implementation;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created on 7/12/2017.
 *
 * /challenges/kaprekar-numbers
 *
 * A modified Kaprekar number is a positive whole number  with  digits, such that when we split its square into two pieces - a right hand piece  with  digits and a left hand piece  that contains the remaining  or  digits, the sum of the pieces is equal to the original number (i.e.  +  = ).

 Note: r may have leading zeros.

 Here's an explanation from Wikipedia about the ORIGINAL Kaprekar Number (spot the difference!): In mathematics, a Kaprekar number for a given base is a non-negative integer, the representation of whose square in that base can be split into two parts that add up to the original number again. For instance, 45 is a Kaprekar number, because 45² = 2025 and 20+25 = 45.

 The Task
 You are given the two positive integers  and , where  is lower than . Write a program to determine how many Kaprekar numbers are there in the range between  and  (both inclusive) and display them all.

 Input Format

 There will be two lines of input: , P lowest value , Q highest value

 */
public class ModifiedKaprekarNumbers {
    public static void main(String[] args) {
        Scanner sc  =new Scanner(System.in);
        int p = sc.nextInt();
        int q = sc.nextInt();

        System.out.println(toString(kaprekar(p,q)));
    }

    private static String toString(List<Integer> list) {
        return list.size()==0 ? "INVALID RANGE":list.stream().map(i->i.toString()).collect(Collectors.joining( " "));
    }

    private static List<Integer> kaprekar(int p, int q) {
        List<Integer> list = new ArrayList();
        for(int i = p ; i <=q; i++){
            if (isKaprekar(i)){
                list.add(i);
            }
        }
        return list;
    }

    private static boolean isKaprekar(long n) {
        long doub = n * n;
        String asString =Long.toString(doub);
        if (doub == n){
            return true;
        }else {
                int i = BigDecimal.valueOf(asString.length()).divide(BigDecimal.valueOf(2), BigDecimal.ROUND_CEILING).intValue();
                Integer r = i<asString.length() ? Integer.valueOf(asString.substring(asString.length()-i)) : 0;
                int l1 = asString.length()-i >=1 ? Integer.valueOf(asString.substring(0, asString.length()-i)) : 0;
                //int l2 = i == 1 || i == 2 ? 0 : Integer.valueOf(asString.substring(1, i - 1));
                if (l1+r == n){
                    return true;
                }

        }
        return false;
    }

    @Test
    public void t1(){
        assertEquals("1 9 45 55 99",toString(kaprekar(1,100)));
    }

    @Test
    public void t3(){
        assertEquals("1 9 45 55 99 297 703 999 2223 2728 4950 5050 7272 7777 9999 17344 22222 77778 82656 95121 99999",toString(kaprekar(1,99999)));
    }

    @Test
    public void t2(){
        assertTrue(isKaprekar(297));
    }
}

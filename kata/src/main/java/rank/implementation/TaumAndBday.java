package rank.implementation;

import org.junit.Test;

import java.util.Scanner;

import static junit.framework.Assert.assertEquals;

/**
 * Created on 7/10/2017.
 *
 * /challenges/taum-and-bday
 *
 * Taum is planning to celebrate the birthday of his friend, Diksha. There are two types of gifts that Diksha wants from Taum: one is black and the other is white. To make her happy, Taum has to buy b number of black gifts and w number of white gifts.

 The cost of each black gift is x units.
 The cost of every white gift is y units.
 The cost of converting each black gift into white gift or vice versa is z  units.
 Help Taum by deducing the minimum amount he needs to spend on Diksha's gifts.

 Input Format

 The first line will contain an integer  which will be the number of test cases.
 There will be  pairs of lines. The first line of each test case will contain the values of integers and . Another line of each test case will contain the values of integers , , and .

 */
public class TaumAndBday {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long b = in.nextLong();
            long w = in.nextLong();

            long x = in.nextLong();
            long y = in.nextLong();

            long z = in.nextLong();

            long total = getTotal(b, w, x, y, z);
            System.out.println(total);
        }
    }

    private static long getTotal(long b, long w, long x, long y, long z) {
        return (x > y+z ? (b * y + b * z) : b*x)
                + (y > z+x ? (w * x + w * z) : w*y);
    }

    @Test
    public void t1(){
        assertEquals(Long.valueOf(37),Long.valueOf(getTotal(5,9,2,3,4)));
    }
}

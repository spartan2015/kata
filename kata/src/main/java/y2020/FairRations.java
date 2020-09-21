package y2020;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * /challenges/fair-rations/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 * <p>
 * You are the benevolent ruler of Rankhacker Castle, and today you're distributing bread. Your subjects are in a line, and some of them already have some loaves. Times are hard and your castle's food stocks are dwindling, so you must distribute as few loaves as possible according to the following rules:
 * <p>
 * Every time you give a loaf of bread to some person , you must also give a loaf of bread to the person immediately in front i+1 or i-1
 * After all the bread is distributed, each person must have an even number of loaves.
 * Given the number of loaves already held by each citizen,
 * <p>
 * find and print the minimum number of loaves you must distribute to satisfy the two rules above. If this is not possible, print NO.
 * <p>
 * For example, the people in line have loaves B=[4,5,6,7] we can first give a loaf to i=3, i=4 so B=[4,5,7,8]
 * <p>
 * next we give a loaf to i=2 and i = 3 and have B[4,6,8,8] which satisfies our condition. we had to distribute 4 loaves
 * <p>
 * Function Description
 * <p>
 * Complete the fairRations function in the editor below. It should return an integer that represents the minimum number of loaves required.
 * <p>
 * fairRations has the following parameter(s):
 * <p>
 * B: an array of integers that represent the number of loaves each persons starts with .
 * <p>
 * Constraints
 * 2 <= N <=1000
 * 1 <= B[i] <=10 where 1 <= i <=N
 * <p>
 * EVEN - meaning - divedes perfectly by 2
 * find first uneven - 5 -> 6-7-7 -> 8->8 - 4
 *
 * 1 testcase failed - 20 - unlock or think about it...
 * run in reverse - mine runs forward - which is correct
 */
public class FairRations {

    private ByteArrayOutputStream bo;

    @Before
    public void before() {
        bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));
    }

    @Test
    public void t1() {
        assertEquals(4, fairRations( new int[]{4, 5, 6, 7}));

        //String allWrittenLines = new String(bo.toByteArray());
        //assertTrue(allWrittenLines.contains("4"));
    }

    @Test
    public void t3() {
        assertEquals(4, fairRations(new int[]{2,3,4,5,6}));

    }

    @Test
    public void t2() {
        assertEquals(-1, fairRations(new int[]{1, 2}));
    }

    int fairRations(int[] B) {
        int[] copy = Arrays.copyOf(B,B.length);
        int count = 0;
        for (int i = 0; i < copy.length; i++) { // always a multiple of 2' - always for uneven - count unevens - yeah but also next to each other
            if (notEven(copy[i])) {
                copy[i]++;
                count++;
                if (i < copy.length - 1) {
                    copy[i + 1]++;
                    count++;
                } else {
                    count = -1;
                }
            }
        }

        copy = Arrays.copyOf(B,B.length);
        int count1 = 0;
        for (int i = copy.length-1; i >=0; i--) { // always a multiple of 2' - always for uneven - count unevens - yeah but also next to each other
            if (notEven(copy[i])) {
                copy[i]++;
                count1++;
                if (i-1 >= 0) {
                    copy[i - 1]++;
                    count1++;
                } else {
                    count1=-1;
                }
            }
        }

        return count!=-1 && count < count1 ? count : count1;
    }

    private boolean notEven(int i) {
        return i % 2 != 0;
    }

}

package rank.implementation;

import org.junit.Test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Created on 7/6/2017.
 *
 * /challenges/manasa-and-stones
 *
 * Manasa is out on a hike with friends. She finds a trail of stones with numbers on them. She starts following the trail and notices that two consecutive stones have a difference of either or . Legend has it that there is a treasure trove at the end of the trail and if Manasa can guess the value of the last stone, the treasure would be hers. Given that the number on the first stone was , find all the possible values for the number on the last stone.

 Note: The numbers on the stones are in increasing order.

 Input Format

 The first line contains an integer , i.e. the number of test cases.  test cases follow; each has 3 lines. The first line contains  (the number of stones). The second line contains , and the third line contains .


 input : no of test case
 testcase data: number of stones, a and b
 trail of stones
 */
public class ManasaandStones {
    @Test
    public void t(){
        assertEquals("2 3 4", posibilities3(3,1,2));
    }

    @Test
    public void t2(){
        assertEquals("30 120 210 300", posibilities3(4,10,100));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int testcases = in.nextInt();
        for(int i = 0; i < testcases; i++){
            int noOfStones = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            String result = posibilities3(noOfStones, a, b);
            System.out.println(result);
        }
    }

    private static String posibilities3(int noOfStones, long a, long b) {
        TreeSet<Long> finals = new TreeSet<>();
        int max = (1 << (noOfStones-1)) -1;
        for(int i = 0; i < noOfStones; i++){
            int bitcount = i;
            long resultValue = a * bitcount + b * (noOfStones - 1 - bitcount);
            finals.add(resultValue);
        }
        return finals.stream().map(x -> x.toString()).collect(Collectors.joining(" "));
    }

    private static String posibilities2(int noOfStones, long a, long b) {
        TreeSet<Long> finals = new TreeSet<>();
        int max = (1 << (noOfStones-1)) -1;
        for(int i = 0; i <= max; i++){
            int bitcount = Integer.bitCount(i);
            long resultValue = a * bitcount + b * (noOfStones - 1 - bitcount);
            finals.add(resultValue);
        }
        return finals.stream().map(x -> x.toString()).collect(Collectors.joining(" "));
    }

    private static String posibilities(int noOfStones, int a, int b) {
        TreeSet<Integer> finals = new TreeSet<>();
        computePosibilities(finals,0,noOfStones,a,b);
        return finals.stream().map(x -> x.toString()).collect(Collectors.joining(" "));
    }

    private static void computePosibilities(Set<Integer> finals,int value, int noOfStones, int a, int b) {
        if (noOfStones == 1){
            finals.add(value);
            return;
        }
        computePosibilities(finals, value+a, noOfStones-1, a,b);
        computePosibilities(finals, value+b, noOfStones-1, a,b);
    }

}

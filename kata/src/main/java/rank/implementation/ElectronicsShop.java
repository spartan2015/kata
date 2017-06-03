package rank.implementation;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

import javax.xml.transform.sax.SAXSource;

/**
 * Monica wants to buy exactly one keyboard and one USB drive from her favorite electronics store. The store sells

 different brands of keyboards and

 different brands of USB drives. Monica has exactly

 dollars to spend, and she wants to spend as much of it as possible (i.e., the total cost of her purchase must be maximal).
 Given the price lists for the store's keyboards and USB drives, find and print the amount money Monica will spend. If she doesn't have enough money to buy one keyboard and one USB drive, print -1 instead.
 Note: She will never buy more than one keyboard and one USB drive even if she has the leftover money to do so.
 Input Format
 The first line contains three space-separated integers describing the respective values of

 (the amount of money Monica has),

 (the number of keyboard brands) and

 (the number of USB drive brands).
 The second line contains

 space-separated integers denoting the prices of each keyboard brand.
 The third line contains

 space-separated integers denoting the prices of each USB drive brand.
 */
public class ElectronicsShop {
    @Test
    public void c1(){
        assertEquals(Integer.valueOf(100),Integer.valueOf(getMoneySpent(100, new int[]{100,99}, new int[]{1,100})));
    }

    @Test
    public void c2(){
        assertEquals(Integer.valueOf(9),Integer.valueOf(getMoneySpent(10, new int[]{3,1}, new int[]{5,2,8})));
    }

    @Test
    public void c3(){
        assertEquals(Integer.valueOf(-1),Integer.valueOf(getMoneySpent(5, new int[]{4}, new int[]{5})));
    }

    @Test
    public void t4(){
        assertEquals(Integer.valueOf(-1),Integer.valueOf(floor(new int[]{0,2,4,6,8}, -1)));
        assertEquals(Integer.valueOf(0),Integer.valueOf(floor(new int[]{0,2,4,6,8}, 0)));
        assertEquals(Integer.valueOf(0),Integer.valueOf(floor(new int[]{0,2,4,6,8}, 1)));
        assertEquals(Integer.valueOf(1),Integer.valueOf(floor(new int[]{0,2,4,6,8}, 2)));
        assertEquals(Integer.valueOf(1),Integer.valueOf(floor(new int[]{0,2,4,6,8}, 3)));
        assertEquals(Integer.valueOf(2),Integer.valueOf(floor(new int[]{0,2,4,6,8}, 4)));
        assertEquals(Integer.valueOf(2),Integer.valueOf(floor(new int[]{0,2,4,6,8}, 5)));
        assertEquals(Integer.valueOf(3),Integer.valueOf(floor(new int[]{0,2,4,6,8}, 6)));
        assertEquals(Integer.valueOf(3),Integer.valueOf(floor(new int[]{0,2,4,6,8}, 7)));
        assertEquals(Integer.valueOf(4),Integer.valueOf(floor(new int[]{0,2,4,6,8}, 8)));
        assertEquals(Integer.valueOf(4),Integer.valueOf(floor(new int[]{0,2,4,6,8}, 9)));
        assertEquals(Integer.valueOf(4),Integer.valueOf(floor(new int[]{0,2,4,6,8}, 1000)));
    }


    @Test
    public void t1(){
        assertEquals(Integer.valueOf(1),Integer.valueOf(floor(new int[]{0,1,2}, 1)));
    }

    @Test
    public void t11(){
        assertEquals(Integer.valueOf(1),Integer.valueOf(floor(new int[]{0,3,6}, 5)));
    }

    @Test
    public void t12(){
        assertEquals(Integer.valueOf(2),Integer.valueOf(floor(new int[]{0,3,6}, 7)));
    }

    @Test
    public void t2() {
        assertEquals(Integer.valueOf(0),Integer.valueOf(floor(new int[]{0, 2}, 1)));
    }
    @Test
    public void t3() {
        assertEquals(Integer.valueOf(-1),Integer.valueOf(floor(new int[]{0, 2}, -1)));
    }

    @Test
    public void case14(){
        Scanner in = new Scanner(this.getClass().getResourceAsStream("ElectronicShop.input-expected-729580.txt"));
        assertEquals(Integer.valueOf(729580), Integer.valueOf(readFrom(in)));
    }

    public static int floor(int[] ar, int val){
        int lo = 0;
        int hi = ar.length-1;
        while (hi >= lo){
            int mid = (lo + hi)/2;
            if (ar[mid]==val) return mid;
            else if (val < ar[mid]){
                if (mid-1 >= 0 && ar[mid-1] < val){
                    return mid-1;
                }else if (mid -1 < 0){
                    return -1;
                }
                hi = mid-1;
            }else{
                if (mid+1 <= ar.length-1 && val < ar[mid+1]){
                    return mid;
                }else if (mid+1 > ar.length-1){
                    return mid;
                }
                lo = mid+1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        readFrom(in);
    }

    private static int readFrom(Scanner in) {
        int maxBudget = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();

        int[] keyboards = readArray(in, n);
        int[] drives = readArray(in,m);

        return getMoneySpent(maxBudget, keyboards, drives);
    }

    private static int getMoneySpent(int maxBudget, int[] keyboards, int[] drives) {
        Arrays.sort(keyboards);
        int maxSum = -1;
        for(int drives_i=0; drives_i < drives.length; drives_i++){
            int drivePrice = drives[drives_i];
            if (maxBudget-drivePrice >= 1) {
                // 246404 + 483176 = 729580
                /*
                for(int keyboardPrice : keyboards){
                    int newSum = keyboardPrice + drivePrice;
                    if (newSum <=maxBudget ) {
                        if (newSum > maxSum) {
                            maxSum = newSum;
                            System.out.println(keyboardPrice + " + " + drivePrice + " = " + newSum);
                        }
                    }
                }
                */
                int index = floor(keyboards, maxBudget - drivePrice);
                if (index!=-1){
                    int newSum = keyboards[index]+drivePrice;
                    if (newSum > maxSum){
                        maxSum = newSum;
                    }
                }

            }
        }
        //  The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
        return maxSum;
    }

    private static int[] readArray(Scanner in, int n) {
        int[] newArray = new int[n];
        for(int index=0; index < n; index++){
            newArray[index] = in.nextInt();
        }
        return newArray;
    }
}
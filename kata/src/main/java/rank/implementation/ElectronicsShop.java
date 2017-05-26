package hackerr.implementation;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

public class ElectronicsShop {
    @Test
    public void c1(){
        assertEquals(Integer.valueOf(100),Integer.valueOf(getMoneySpent(new int[]{100,99}, new int[]{1,100}, 100)));
    }

    @Test
    public void c2(){
        assertEquals(Integer.valueOf(9),Integer.valueOf(getMoneySpent(new int[]{3,1}, new int[]{5,2,8}, 10)));
    }

    @Test
    public void c3(){
        assertEquals(Integer.valueOf(-1),Integer.valueOf(getMoneySpent(new int[]{4}, new int[]{5}, 5)));
    }

    @Test
    public void t4(){
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

    static int getMoneySpent(int[] keyboards, int[] drives, int s){
        Arrays.sort(keyboards);
        Arrays.sort(drives);
        return Math.max(maxPossible(keyboards, drives, s),maxPossible(drives, keyboards, s));
    }

    private static int maxPossible(int[] firstArr, int[] secondArr, int s) {
        int i = firstArr.length-1;
        while( firstArr[i] > s) i--;
        for(; i >=0; i--){
            int firstVal = firstArr[i];
            int secondArrIndex = floor(secondArr, s-firstVal);
            if (secondArrIndex >=0){
                return firstVal + secondArr[secondArrIndex];
            }
        }
        return -1;
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
        int s = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();
        int[] keyboards = new int[n];
        for(int keyboards_i=0; keyboards_i < n; keyboards_i++){
            keyboards[keyboards_i] = in.nextInt();
        }
        int[] drives = new int[m];
        for(int drives_i=0; drives_i < m; drives_i++){
            drives[drives_i] = in.nextInt();
        }
        //  The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
        int moneySpent = getMoneySpent(keyboards, drives, s);
        System.out.println(moneySpent);
    }
}

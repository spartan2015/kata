package rank.datastructures.arrays;

import java.util.Scanner;


/**
 * Created on 6/6/2017.
 *
 * An array is a type of data structure that stores elements of the same type in a contiguous block of memory. In an array, , of size , each memory location has some unique index,  (where ), that can be referenced as  (you may also see it written as ).

 Given an array, , of  integers, print each element in reverse order as a single line of space-separated integers.

 */
public class ArraysDS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] ar = readArray(sc);

        for(int i = 0; i < ar.length; i++){
            System.out.print(ar[ar.length-1-i] +" ");
        }
    }

    private static int[] readArray(Scanner sc) {
        int n = sc.nextInt();
        int[] ar = new int[n];
        for(int i = 0; i < n; i++){
            ar[i]=sc.nextInt();
        }
        return ar;
    }
}

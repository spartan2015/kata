package rank.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on 6/8/2017.
 * Consider an array of numeric strings, , where each string is a positive number with anywhere from  to  digits. Sort the array's elements in non-decreasing (i.e., ascending) order of their real-world integer values and print each element of the sorted array on a new line.

 Input Format

 The first line contains an integer, , denoting the number of strings in .
 Each of the  subsequent lines contains a string of integers describing an element of the array.
 Sample Input 0

 6
 31415926535897932384626433832795
 1
 3
 10
 3
 5

 Sample Output 0

 1
 3
 3
 5
 10
 31415926535897932384626433832795
 */
public class BigSorting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            unsorted[unsorted_i] = in.next();
        }
        Arrays.sort(unsorted, (s1, s2)->{
            if (s1.length() == s2.length()){
                return s1.compareTo(s2);
            }else{
                return s1.length()-s2.length();
            }
        });
        for(String s : unsorted){
            System.out.println(s);
        }
    }
}

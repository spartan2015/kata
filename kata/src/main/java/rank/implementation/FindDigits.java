package rank.implementation;

import java.util.Scanner;

/**
 * Created on 6/8/2017.
 *
 * Given an integer, , traverse its digits (1,2,...,n) and determine how many digits evenly divide  (i.e.: count the number of times  divided by each digit i has a remainder of ). Print the number of evenly divisible digits.
 *
 * Note: Each digit is considered to be unique, so each occurrence of the same evenly divisible digit should be counted (i.e.: for , the answer is ).

 Input Format

 The first line is an integer, , indicating the number of test cases.
 The  subsequent lines each contain an integer, .

 */
public class FindDigits {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i =0; i <n; i++){
            String s = in.next();
            int no = Integer.valueOf(s);

            int countRemainder = 0;
            for(int j = 0; j < s.length(); j++){
                Integer digit = Integer.valueOf(s.charAt(j) + "");
                if (digit !=0 && no % digit == 0){
                    countRemainder++;
                }
            }
            System.out.println(countRemainder);
        }
    }

}

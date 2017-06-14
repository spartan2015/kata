package rank.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on 6/14/2017.
 *
 * /challenges/grid-challenge
 *
 Given a squared sized grid  of size  in which each cell has a lowercase letter. Denote the character in the th row and in the th column as .

 You can perform one operation as many times as you like: Swap two column adjacent characters in the same row  and  for all valid .

 Is it possible to rearrange the grid such that the following condition is true?

 for  and
 for

 In other words, is it possible to rearrange the grid such that every row and every column is lexicographically sorted?
 */
public class GridChallenge {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for (int testCase = 0; testCase < testCases; testCase++) {
            char[][] ar = readMatrix(in);
            for(int i =0; i<ar.length;i++){
                Arrays.sort(ar[i]);
                System.out.println(ar[i]);
            }

            boolean can = true;
            ad: for(int i =1; i<ar.length;i++){
                for(int j =0; j < ar.length;j++){
                    if (ar[i-1][j]>ar[i][j]){
                        can = false;
                        break ad;
                    }
                }
            }
            if (can){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }

    private static char[][] readMatrix(Scanner sc) {
        int n = sc.nextInt();
        char[][] ar = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            ar[i] = s.toCharArray();
        }
        return ar;
    }

}

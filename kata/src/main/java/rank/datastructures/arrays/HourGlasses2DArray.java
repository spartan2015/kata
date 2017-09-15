package rank.datastructures.arrays;

import java.util.Scanner;

/**
 * challenges/2d-array
 *
 * compute max hourglass in a 6th dimensional array
 */
public class HourGlasses2DArray {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[][] m = readMatrix(in, 6);
        int maxSum = Integer.MIN_VALUE;
        for(int column =0; column+2 < 6; column++){
            for(int row = 0; row+2 < 6; row++){
             maxSum = Math.max(maxSum, computeHourGlass(column, row, m));
            }
        }
        System.out.println(maxSum);
    }

    private static int computeHourGlass(int column, int row, int[][] m) {
        return m[row][column] + m[row][column+1] +m[row][column+2] + m[row+1][column+1]+
                m[row+2][column] + m[row+2][column+1]+m[row+2][column+2];
    }

    public static int[] readArr(Scanner in, int n) {
        int[] ar = new int[n];
        for (int i = 0; n - i != 0; i++) {
            ar[i] = in.nextInt();
        }
        return ar;
    }

    public static int[][] readMatrix(Scanner in, int n){
        int[][] matrix = new int[n][n];
        for(int i =0; i<n;i++){
            matrix[i] = readArr(in, n);
        }
        return matrix;
    }

}

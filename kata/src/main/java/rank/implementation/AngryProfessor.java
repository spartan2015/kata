package rank.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on 6/11/2017.
 *
 * A Discrete Mathematics professor has a class of

 students. Frustrated with their lack of discipline, he decides to cancel class if fewer than

 students are present when class starts.
 Given the arrival time of each student, determine if the class is canceled.
 Input Format
 The first line of input contains

 , the number of test cases.
 Each test case consists of two lines. The first line has two space-separated integers,

 (students in the class) and

 (the cancelation threshold). The second line contains

 space-separated integers (










 ) describing the arrival times for each student.
 Note: Non-positive arrival times (




 ) indicate the student arrived early or on time; positive arrival times (




 ) indicate the student arrived


 minutes late.

 */
public class AngryProfessor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n  = in.nextInt();
            int k = in.nextInt();

            int[] arrivalTimes = readArray(in, n);
            long count = Arrays.stream(arrivalTimes).filter(a->a<=0).count();
            if (count >= k){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
        }
    }

    private static int[] readArray(Scanner sc, int n) {
        int[] ar = new int[n];
        for(int i = 0; i < n; i++){
            ar[i]=sc.nextInt();
        }
        return ar;
    }

}

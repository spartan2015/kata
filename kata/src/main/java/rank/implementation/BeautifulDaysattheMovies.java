package rank.implementation;

import org.junit.Test;

import java.util.Scanner;

/**
 * Created on 6/11/2017.
 */
public class BeautifulDaysattheMovies {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int start = in.nextInt();
        int end = in.nextInt();
        int k = in.nextInt();

        int count = 0;
        for(int test = start; test <=end; test++){
            if (isBeautiful(test,k)) count++;
        }

        System.out.println(count);
    }

    private static boolean isBeautiful(int test, int k) {
        return (Math.abs(test - reverse(test))) % k == 0;
    }

    private static int reverse(int test) {
        int result = 0;

        int digits = 1;
        while(test >= Math.pow(10, digits)){
            digits++;
        }

        int start = test;
        for(int i = 0; i < digits; i++, start /=10){
            result += Math.pow(10, digits - i - 1) *  (start - (start / 10)*10);
        }

        return result;

    }

    @Test
    public void t(){
        System.out.println(reverse(1));;
        System.out.println(reverse(12));;
        System.out.println(reverse(123));;
        System.out.println(reverse(1234));;
    }
}

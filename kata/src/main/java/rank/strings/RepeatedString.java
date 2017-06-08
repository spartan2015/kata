package rank.strings;

import java.util.Scanner;

/**
 * Created on 6/8/2017.
 */
public class RepeatedString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();


        int count =0;
        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i) == 'a'){
                count++;
            }
        }

        int countb = 0;
        for(int i = 0; i <  (n % s.length()); i++){
            if (s.charAt(i) == 'a'){
                countb++;
            }
        }

        System.out.println((n / s.length()) * count + countb );
    }

}

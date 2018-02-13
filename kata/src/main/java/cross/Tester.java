package cross;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import static org.junit.Assert.assertEquals;

public class Tester {

    /**
     * Complete the function below.
     * DO NOT MODIFY anything outside this method.
     */
    static String[] twins(String[] a, String[] b)
    {
        if (a == null || b == null) return null;

        String[] result = new String[a.length];

        for(int i = 0; i < a.length; i++){
            result[i] = arePairs(a[i],b[i]);
        }
        return result;
    }

    private static String arePairs(String s1, String s2) {
        StringBuilder s1Even =new StringBuilder();
        StringBuilder s1Odd =new StringBuilder();

        StringBuilder s2Even =new StringBuilder();
        StringBuilder s2Odd =new StringBuilder();

        for(int i = 0; i < s1.length(); i++){
            if (i%2 ==1){
                //odd
                s1Odd.append(s1.charAt(i));
                s2Odd.append(s2.charAt(i));
            }else{
                //even
                s1Even.append(s1.charAt(i));
                s2Even.append(s2.charAt(i));
            }
        }

        char[] s1OddChar = s1Odd.toString().toCharArray();
        Arrays.sort(s1OddChar);

        char[] s2OddChar = s2Odd.toString().toCharArray();
        Arrays.sort(s2OddChar);

        char[] s1EvenChar = s1Even.toString().toCharArray();
        Arrays.sort(s1EvenChar);

        char[] s2EvenChar = s2Even.toString().toCharArray();
        Arrays.sort(s2EvenChar);



        if (Arrays.equals(s1OddChar,s2OddChar) && Arrays.equals(s1EvenChar, s2EvenChar)){
            return "Yes";
        }else{
            return "No";
        }

    }

    @Test
    public void c1(){
        assertEquals("Yes", arePairs("abcd","cdab"));
        assertEquals("No", arePairs("bacd","cdab"));
    }


    /**
     * DO NOT MODIFY THIS METHOD!
     */
    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        String[] res;

        int _a_size = 0;
        _a_size = Integer.parseInt(in.nextLine().trim());
        String[] _a = new String[_a_size];
        String _a_item;
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            try {
                _a_item = in.nextLine();
            } catch (Exception e) {
                _a_item = null;
            }
            _a[_a_i] = _a_item;
        }


        int _b_size = 0;
        _b_size = Integer.parseInt(in.nextLine().trim());
        String[] _b = new String[_b_size];
        String _b_item;
        for(int _b_i = 0; _b_i < _b_size; _b_i++) {
            try {
                _b_item = in.nextLine();
            } catch (Exception e) {
                _b_item = null;
            }
            _b[_b_i] = _b_item;
        }

        res = twins(_a, _b);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }
    }
}

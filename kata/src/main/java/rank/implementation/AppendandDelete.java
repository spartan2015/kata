package rank.implementation;

import java.util.Scanner;

/**
 * Created on 6/12/2017.
 *
 * You have a string,

 , of lowercase English alphabetic letters. You can perform two types of operations on

 :
 Append a lowercase English alphabetic letter to the end of the string.
 Delete the last character in the string. Performing this operation on an empty string results in an empty string.
 Given an integer,

 , and two strings,

 and

 , determine whether or not you can convert

 to

 by performing exactly

 of the above operations on

 . If it's possible, print Yes; otherwise, print No.

 */
public class AppendandDelete {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        int k = in.nextInt();

        int i = 0;
        for (; i < s.length() && i < t.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {

                break;
            }
        }

        int ops = s.length() - s.substring(0, i).length() + t.substring(i).length();
        System.out.println(ops == k | (ops > 0 && ops < k && Math.abs(ops - k) % 2 == 0) | k > s.length() + t.length() || (ops == 0 && s.length() == t.length()) ? "Yes" : "No");
    }

}

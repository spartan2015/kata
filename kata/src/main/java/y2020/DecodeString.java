package y2020;

import org.junit.Test;

import java.util.Stack;

public class DecodeString {

    private static String secondDecode(String s) {
        StringBuilder sb = new StringBuilder();
        int pos = 0;
        int times = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c >='a' && c <='z'){ // some char
                sb.append(c);
                pos++;
            }else if (c == '['){
               times = Integer.valueOf(s.substring(pos, i));
                String decodeOnce = secondDecode(s.substring(i+1));
                for(int t = 0; t < times; t++){
                    sb.append(decodeOnce);
                }
                return sb.toString();
            }else if (c == ']'){
                return sb.toString();
            }
        }
        return sb.toString();
    }

    private static String decodeWithStack(String s) {
        Stack<String> elements = new Stack<>();

        int pos = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c >='0' && c <='9'){
                elements.push(s.substring(pos, i));
                pos = i;
            }else if (c == '['){
                elements.push(s.substring(pos, i));
                pos = i+1;
            }else if (c == ']'){
                if (pos!=i) {
                    String repl = s.substring(pos, i);
                    elements.push(repl);
                }

                pos = i+1;

                String repl = elements.pop();
                StringBuilder sb = new StringBuilder();
                int times = Integer.valueOf(elements.pop());
                sb.append(elements.pop());
                for(int x = 0; x < times; x++){
                    sb.append(repl);
                }
                // this one pushes - so
                elements.push(sb.toString());
            }
        }

        return elements.pop();

    }


    @Test
    public void t2(){
        System.out.println(decodeWithStack("2[x2[a2[c]]]")); // start is the number else just append
    }

    @Test
    public void t1(){
        System.out.println(secondDecode("x2[b2[a]]")); // start is the number else just append
    }


    private static String decodeString(String s, int start, int finish) {

        int pos = 0;
        int times = 0;
        StringBuilder sb = new StringBuilder();

        boolean inBrackets = false;
        for(int i = start; i < finish; i++){
            if (!inBrackets && s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                sb.append(s.charAt(i));
                pos++;
            }else if (s.charAt(i)=='['){
                inBrackets = true;
                times = Integer.valueOf(s.substring(pos, i));
                pos = i + 1;
            }else if (s.charAt(i)==']'){

                inBrackets = false;
                String sub = s.substring(pos, i);
                for(int t = 0; t < times; t++){
                    sb.append(sub);
                }
                pos = i + 1;
            }
        }

        return sb.toString();

    }

   /* public static void main(String[] args) {
        System.out.println(decodeString("3[a]"));               // "aaa"
        System.out.println(decodeString("11[a]"));              // "aaaaaaaaaaa"
        System.out.println(decodeString("3[a]2[bc]"));          // "aaabcbc
        System.out.println(decodeString("zxy2[abc]ef"));        // "zxyabcabcef"
        System.out.println(decodeString("3[a2[c]]"));           // "accaccacc"
        // 3[a2[c]] -> a2[c] -> c
    }*/

}

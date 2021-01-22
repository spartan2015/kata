package y2020;

import org.junit.Test;

/**
 * ReverseWords
 */
public class ReverseWords {

    public static char[] reverseWords(char [] input) {

        int start = 0;
        for(int i =0; i < input.length; i++){
            if (input[i] == ' '){
                reverse(input, start, i-1);
                start = i+1;
            }

        }
        reverse(input, start, input.length-1);

        return input;
    }

    private static void reverse(char[] input, int start, int end) {
        for(int i = start; i <= (start+end)/2; i++){
            swap(input, i, end--);
        }
    }

    private static void swap(char[] input, int i, int j) {
        char tmp = input[i];
        input[i] = input[j];
        input[j]=tmp;
    }

    @Test
    public void t(){
        System.out.println(reverseWords("I love you too".toCharArray()));;
    }

}

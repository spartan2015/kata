package y2020;

import org.junit.Test;

/**
 * /challenges/strong-password/problem
 */
public class StrongPassword {


    static int minimumNumber(int n, String password) {
        char[] chars = password.toCharArray();

        boolean[] needed = new boolean[5];

        for(int i = 0; i < chars.length; i++){
            needed[typeOf(chars[i])] = true;
        }

        int count = 0;
        for(int i =1; i < needed.length; i++){
            if (!needed[i]) count++;
        }

        return count + chars.length >= 6 ? count : count+(6 - (chars.length+count));

    }

    private static int typeOf(char aChar) {
       if (aChar >=48 && aChar <= 58){
           return 1;
        }else if (aChar >=65 && aChar <= 90){
           return 2;
        }else if (aChar >=97 && aChar <= 122){
           return 3;

        }else if (aChar == 45 || (aChar >=33 && aChar <= 43)){
           return 4;
        }
       return 0;
    }

    @Test
    public void t(){
        System.out.println((int)"-".charAt(0));

        System.out.println(minimumNumber(3, "AUzs-nV"));;
    }
}

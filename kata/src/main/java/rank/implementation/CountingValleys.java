package hackerr.implementation;

import java.util.Scanner;

public class CountingValleys {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int valleys = 0;
        int level = 0 ;
        String s = in.next();
        boolean valleyAlready = false;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == 'U'){
                level++;
            }else{
                level--;
            }
            if (level == -1){
                if (!valleyAlready) {
                    valleys++;
                    valleyAlready = true;
                }
            }
            if (level == 0){
                valleyAlready = false;
            }
        }
        System.out.println(valleys);
    }
}

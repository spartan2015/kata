package hackerr.implementation;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

public class BonAppetit {

    @Test
    public void case1(){
        assertEquals("5",fairCharge(1,new int[]{3,10,2,9}, 12));
    }

    @Test
    public void case2(){
        assertEquals("Bon Appetit",fairCharge(1,new int[]{3,10,2,9}, 7));
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int kth = in.nextInt();
        int[] c = new int[n];
        for (int i = 0; n - i > 0; i++) {
            c[i] = in.nextInt();
        }
        int charged = in.nextInt();

        System.out.println(fairCharge(kth, c, charged));
    }

    private static String fairCharge(int kth, int[] c, int charged) {
        int sharedCharge = 0;
        for(int i = 0; i<c.length;i++){
            if (i == kth){
                continue;
            }
            sharedCharge +=c[i];
        }

        if (charged == (sharedCharge/2)) {
            return "Bon Appetit";
        }else{
            return charged - (sharedCharge/2)+ "";
        }
    }

}

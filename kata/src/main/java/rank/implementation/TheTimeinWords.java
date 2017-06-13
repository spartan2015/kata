package rank.implementation;

import org.junit.Test;

import java.util.Scanner;

/**
 * Created on 6/13/2017.
 */
public class TheTimeinWords {

    @Test
    public void t1(){
        toWords(1,30);
        toWords(1,45);

        toWords(1,0);
        toWords(2,0);

        toWords(1,1);

        toWords(1,10);

        toWords(1,11);
        toWords(1,12);
        toWords(1,13);
        toWords(1,14);
        toWords(1,15);
        toWords(1,16);
        toWords(1,17);
        toWords(1,18);
        toWords(1,19);

        toWords(1,20);

        toWords(1,40);
        toWords(1,50);

        toWords(1,51);
        toWords(1,52);
        toWords(1,53);
        toWords(1,54);
        toWords(1,55);
        toWords(1,56);
        toWords(1,57);
        toWords(1,58);
        toWords(1,59);
    }

    static String[] hours = {"one","two", "three","four","five","six","seven","eight","nine","ten","eleven","twelve"};
    static String[] tenTo19 = {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
    static String[] tens = {"twenty","thirty","fourty","fifty"};


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int m = in.nextInt();

        toWords(h, m);
    }

    private static void toWords(int h, int m) {
        if (m ==0){
            System.out.println(hours[h-1] + " o' clock");
        }else{
            if (m == 1) {
                System.out.printf("%s minute past %s\n", minWords(m),hours[h - 1]);
            }else if (m == 15){
                System.out.printf("quarter past %s\n", hours[h-1]);
            }else if (m < 30){
                System.out.printf("%s minutes past %s\n", minWords(m) ,hours[h - 1]);
            }else if(m == 30){
                System.out.printf("half past %s\n", hours[h - 1]);
            }else if ( m == 45) {
                System.out.printf("quarter to %s\n", hours[h]);
            }else{
                System.out.printf("%s minutes to %s\n", minWords(60-m) ,hours[h]);
            }
        }
    }

    private static String minWords(int m) {
        if (m>=10 & m<20){
            return tenTo19[m-10];
        }else if (m < 10){
            return hours[m-1];
        }else{
            int subTen = m - ((m / 10)*10);
            if (subTen ==0) {
                return String.format("%s", tens[m / 10 - 2]);
            }else{
                return String.format("%s %s", tens[m / 10 - 2], hours[subTen-1]);
            }
        }
    }
}

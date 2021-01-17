package y2020;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

/**
 * Sherlock
 * /challenges/sherlock-and-the-beast/problem
 */
public class Sherlock {
    // Complete the decentNumber function below.
    // largest decent number having that number of digits
    // decent number - only 3 or 5
    // the number of 3 it contains is divisible by 5
    // the number of 5 is divisible by 3
    // it is the largest for the length
    // 555555 - is decent
    // 55533333 is decent
    static void decentNumber(int n) {
        if (n < 3) {
            System.out.println(-1);
            return;
        }
        int nmod3 = n%3;
        if(nmod3== 0){
           for(int i = 0; i < n;i++){
               System.out.print(5);
           }
       } else if (nmod3 == 1 || nmod3==2){
            int n5 = n / 3;
            int rest = n % 3;

            if (rest == 1){
                n5-=3;
                rest = 10;
            }else if (rest == 2){
                n5--;
                rest = 5;
            }
            if (n5 < 0){
                System.out.print(-1);

            }else {

                for (int i = 0; i < n5; i++) {
                    System.out.print(555);
                }
                for (int i = 0; i < rest / 5; i++) {
                    System.out.print(33333);
                }
            }
        } else if(n%5==0){
           for(int i = 0; i < n;i++){
               System.out.print(3);
           }
       }
       System.out.println();
    }

    @Test
    public void t(){
        for(int i = 1; i <= 10; i++)
        decentNumber(i);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine()
                .trim());

        IntStream.range(0, t)
                .forEach(tItr -> {
                    try {
                        int n = Integer.parseInt(bufferedReader.readLine()
                                .trim());

                        decentNumber(n);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

        bufferedReader.close();
    }
}

package rank.implementation;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Done
 *
 * Created on 6/11/2017.
 *
 * /challenges/jumping-on-the-clouds-revisited
 *
 * Aerith is playing a cloud game! In this game, there are

 clouds numbered sequentially from

  0 to n-1

 . Each cloud is either an ordinary cloud or a thundercloud.
 Aerith starts out on cloud

 with energy level



 . She can use

 unit of energy to make a jump of size

 to cloud

 , and she jumps until she gets back to cloud

 . If Aerith lands on a thundercloud, her energy (

 ) decreases by

 additional units. The game ends when Aerith lands back on cloud

 .
 Given the values of

 ,

 , and the configuration of the clouds, can you determine the final value of

 after the game ends?
 */
public class JumpingontheCloudsRevisited {

    @Test
    public void c1(){
        //assertEquals(Integer.valueOf(0), Integer.valueOf(jump()));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }

        System.out.println(jump(n, k, c));

    }

    private static int jump(int n, int k, int[] c) {
        int E = 100;
        int index = 0;
        do{
            index = ( index + k ) % n;
            E--;
            if (c[index] == 1){
                E-=2;
            }
        }while(index != 0);
        return E;
    }
}

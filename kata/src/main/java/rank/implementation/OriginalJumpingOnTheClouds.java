package rank.implementation;

import org.junit.Test;

import java.util.Scanner;

import static junit.framework.Assert.assertEquals;

/**
 * Created on 7/4/2017.
 *
 * challenges/jumping-on-the-clouds
 *
 * Emma is playing a new mobile game involving  clouds numbered from 0 to  n-1. A player initially starts out on cloud , and they must jump to cloud .
 * In each step, she can jump from any cloud i to cloud i+1  or cloud i+2.

 There are two types of clouds, ordinary clouds and thunderclouds. The game ends if Emma jumps onto a thundercloud, but if she reaches the last cloud (i.e., ), she wins the game!

 Can you find the minimum number of jumps Emma must make to win the game? It is guaranteed that clouds  and  are ordinary-clouds and it is always possible to win the game.

 0 means ordinary cloud
 */
public class OriginalJumpingOnTheClouds {

    @Test
    public void c1(){
        assertEquals(Integer.valueOf(4), Integer.valueOf(minJumps(new int[]{0,0,1,0,0,1,0})));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] c = readArr(in, in.nextInt());


        System.out.println(minJumps(c));
    }

    private static int minJumps(int[] c) {
        int jumps = 0;
        for(int i =0; i < c.length-1; ){
            if (i+2 < c.length && c[i+2]==0){
                i+=2;
            }else{
                i+=1;
            }
            jumps++;
        }
        return jumps;
    }

    public static int[] readArr(Scanner in, int n) {
        int[] ar = new int[n];
        for (int i = 0; n - i != 0; i++) {
            ar[i] = in.nextInt();
        }
        return ar;
    }
}

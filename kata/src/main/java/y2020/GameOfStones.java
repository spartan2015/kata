package y2020;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/*
/challenges/game-of-stones-1/problem
Two players called  and  are playing a game with a starting number of stones. Player  always plays first, and the two players move in alternating turns. The game's rules are as follows:

In a single move, a player can remove either , , or  stones from the game board.
If a player is unable to make a move, that player loses the game.
Given the starting number of stones, find and print the name of the winner.  is named First and  is named Second. Each player plays optimally, meaning they will not make a move that causes them to lose the game if a winning move exists.

For example, if ,  can make the following moves:

 removes  stones leaving .  will then remove  stones and win.
 removes  stones leaving .  cannot move and loses.
 would make the second play and win the game.
 */
public class GameOfStones {

    static int n = 0;

    static String gameOfStones(int n) {
        GameOfStones.n = n;
        if (n == 1 || n %7 == 0 || n% 7 ==1){
            return "Second";
        }else{
            return "First";
        }

    }

    /*
    // 2 3 5 - covered to 6 -
                if (n - 2 < 2) {
                    n -= 2;
                    System.out.println(String.format("Take %d leaves %d", 2, n));
                } else if (n - 3 < 2) {
                    n -= 3;
                    System.out.println(String.format("Take %d leaves %d", 3, n));
                } else if (n - 5 < 2) {
                    n -= 5;
                    System.out.println(String.format("Take %d leaves %d", 5, n));
                } else {
                    if (n-5 == 7) {
                        n -= 5;
                        System.out.println(String.format("Take %d leaves %d", 5, n));
                    }else if (n-2 == 7){
                        n -= 2;
                        System.out.println(String.format("Take %d leaves %d", 2, n));
                    }else if (n - 3  == 7){
                        n -= 3;
                        System.out.println(String.format("Take %d leaves %d", 3, n));
                    }else if (n - 2  == 9){
                        n -= 3;
                        System.out.println(String.format("Take %d leaves %d", 3, n));
                    }else if (n - 2  == 11){
                        n -= 5;
                        System.out.println(String.format("Take %d leaves %d", 3, n));

                }else if (n - 5  == 13){
                    n -= 3;
                    System.out.println(String.format("Take %d leaves %d", 3, n));
                }
                    else {
                        n -= 2;
                        System.out.println(String.format("Take %d leaves %d", 5, n));
                    }


                }
    */
    public static boolean take() {
        if (n < 2) {
            return false;
        } else {
            if (n - 2 < 2) {
                sub(2);
            } else if (n - 3 < 2) {
                sub(3);
            } else if (n - 5 < 2) {
                sub(5);
            } else {
               if (n -2 == 7){ // we alywas loose
                   sub(2);
               }else if (n-3 == 8){
                   sub(3);
               }else if (n - 5 == 7 || n -5 == 8){
                   sub(5);
               }else{
                   sub(2);
               }
            }
            return true;
        }
    }

    public static void sub(int i) {
        n -= i;
        System.out.println("taken " + i + " left " + n);
    }

    @Test
    public void t() {
        assertEquals("First", gameOfStones(4));
        assertEquals("First", gameOfStones(5));
        assertEquals("First", gameOfStones(6));
        assertEquals("Second", gameOfStones(7));
        assertEquals("First", gameOfStones(9));
        assertEquals("First", gameOfStones(10));
        assertEquals("First", gameOfStones(11));
        assertEquals("First", gameOfStones(12));
        assertEquals("First", gameOfStones(13));
    }

    @Test
    public void tx() {
        assertEquals("First", gameOfStones(18));


    }

    @Test
    public void t2() {
        String str = "1\n" +
                "2\n" +
                "3\n" +
                "4\n" +
                "5\n" +
                "6\n" +
                "7\n" +
                "8\n" +
                "9\n" +
                "10\n" +
                "11\n" +
                "12\n" +
                "13\n" +
                "14\n" +
                "15\n" +
                "16\n" +
                "17\n" +
                "18\n" +
                "19\n" +
                "20\n" +
                "21\n" +
                "22\n" +
                "23\n" +
                "24\n" +
                "25\n" +
                "26\n" +
                "27\n" +
                "28\n" +
                "29\n" +
                "30\n" +
                "31\n" +
                "32\n" +
                "33\n" +
                "34\n" +
                "35\n" +
                "36\n" +
                "37\n" +
                "38\n" +
                "39\n" +
                "40\n" +
                "41\n" +
                "42\n" +
                "43\n" +
                "44\n" +
                "45\n" +
                "46\n" +
                "47\n" +
                "48\n" +
                "49\n" +
                "50\n" +
                "51\n" +
                "52\n" +
                "53\n" +
                "54\n" +
                "55\n" +
                "56\n" +
                "57\n" +
                "58\n" +
                "59\n" +
                "60\n" +
                "61\n" +
                "62\n" +
                "63\n" +
                "64\n" +
                "65\n" +
                "66\n" +
                "67\n" +
                "68\n" +
                "69\n" +
                "70\n" +
                "71\n" +
                "72\n" +
                "73\n" +
                "74\n" +
                "75\n" +
                "76\n" +
                "77\n" +
                "78\n" +
                "79\n" +
                "80\n" +
                "81\n" +
                "82\n" +
                "83\n" +
                "84\n" +
                "85\n" +
                "86\n" +
                "87\n" +
                "88\n" +
                "89\n" +
                "90\n" +
                "91\n" +
                "92\n" +
                "93\n" +
                "94\n" +
                "95\n" +
                "96\n" +
                "97\n" +
                "98\n" +
                "99\n" +
                "100";
        String res = "Second\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "Second\n" +
                "Second\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "Second\n" +
                "Second\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "Second\n" +
                "Second\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "Second\n" +
                "Second\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "Second\n" +
                "Second\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "Second\n" +
                "Second\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "Second\n" +
                "Second\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "Second\n" +
                "Second\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "Second\n" +
                "Second\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "Second\n" +
                "Second\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "Second\n" +
                "Second\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "Second\n" +
                "Second\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "Second\n" +
                "Second\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "First\n" +
                "Second\n" +
                "Second\n" +
                "First";
        String[] reses = res.split("\n");
        String[] vals = str.split("\n");


        for (int i = 0; i < reses.length; i++) {
            System.err.println(vals[i] + " " + reses[i]);
            /*if (!gameOfStones(Integer.valueOf(vals[i])).equals(reses[i])) {
                System.err.println(vals[i] + " " + reses[i]);
                return;
            }*/
        }
    }
}

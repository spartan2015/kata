package y2020;

/**
 * /challenges/nim-game-1/problem
 *
 * Nim is the most famous two-player algorithm game. The basic rules for this game are as follows:
 *
 * The game starts with a number of piles of stones. The number of stones in each pile may not be equal.
 * The players alternately pick up 1 or more stones from  pile
 * The player to remove the last stone wins.
 *https://www.youtube.com/watch?v=ORaGSyewF9Q
 *
 * so if xoring shows even no of 11 in bits of the piles - than First lost - even odd -> he can make even
 * and whoever has even loses
 */
public class NimPowersOfTwo {

    // Complete the nimGame function below.
    static String nimGame(int[] pile) {
        int xor = 0;
        for(int i : pile){
            xor ^= i;
        }
        return xor == 0 ? "Second" : "First";

    }

}

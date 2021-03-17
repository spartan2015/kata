package y2020;

import org.junit.Test;

import java.util.Arrays;

/*
/challenges/tower-breakers-revisited-1/
 */
public class TowerBreakes {

    static int towerBreakers(int[] arr) {

        return nimGame(
                Arrays.stream(arr)
                        .map(i->primeFactorization(i)).toArray()
        );

    }

    static int primeFactorization(int n){
        if (n == 1) return 1;
        int count = 0;
        for(int i  = 2; i <= n; i++){
            while(n % i == 0) {count++; n=n/i;}
        }
        return count;
    }

    static int nimGame(int[] pile) {
        int xor = 0;
        for(int i : pile){
            xor ^= i;
        }
        return xor == 0 ? 2 : 1;

    }

    @Test
    public void t(){
        System.out.println(primeFactorization(9));
        System.out.println(primeFactorization(2));
        System.out.println(primeFactorization(3));
    }

}

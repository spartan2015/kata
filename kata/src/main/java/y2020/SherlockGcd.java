package y2020;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TransferQueue;

import static org.junit.Assert.assertEquals;

/**
 * SherlockGcd
 * /challenges/sherlock-and-gcd/
 */
public class SherlockGcd {

    // find subset of A with at least 1 element such as theere is no integer > 1 that divides all members of B
    // so they have no common divisor
    // there are no duplicates - unique
    // this is in nubmer thory math - not my thing

    static String solve1(int[] a) {
        Arrays.sort(a);
        int[] unique = new int[a.length];
        int uniqueIndex = 0;
        unique[uniqueIndex++] = a[0];
        for (int j = 1; j < a.length; j++) {
            if (a[j - 1] != a[j]) {
                unique[uniqueIndex++] = a[j];
            }
        }

        for(int d = 2; d<= unique[0]; d++) {

            int count = 0;
            for (int i = 0; i < uniqueIndex; i++) {
                if (unique[i] % d == 0)   {
                    count++;
                }
            }

            if (count == uniqueIndex){
                return "NO";
            }
        }
        return "YES";
    }

    static int gcd(int n1, int n2){
        while(n1 != n2)
        {
            if(n1 > n2)
                n1 -= n2;
            else
                n2 -= n1;
        }
        return n1;
    }

    static String solve(int[] a) {
        // unique elements - eliminate duplicates
        // if it contains 1 - then just return Yes - since there is a subset {1} non divisible by x > 1
        // again create the combinations  - or is there a way where you don't have to do this
        // find common divisor - for all elements - divide them by 2 to N/2, all elements at least 2 values -
        // if there is at least one element that cannot be divided then yes - and 1 is such a number
        Arrays.sort(a);
        if (a[0] == 1) {
            return "YES";
        }

        int[] unique = new int[a.length];
        int uniqueIndex = 0;
        unique[uniqueIndex++] = a[0];
        for (int j = 1; j < a.length; j++) {
            if (a[j - 1] != a[j]) {
                unique[uniqueIndex++] = a[j];
            }
        }

        // combinations
        // combinations of 1 test

        class Comb{
            int[] comb;
            TreeSet<Integer> divisors = new TreeSet<>();

            public Comb(int[] comb, TreeSet<Integer> divisors) {
                this.comb = comb;
                this.divisors = divisors;
            }
        }

        List<Comb> combs = new ArrayList<>();
        for (int i = 0; i < uniqueIndex; i++) {
            combs.add(new Comb(new int[]{i}, divisors(unique[i])));
        }

        // faster by knowing all previous common divisors already computed - so for first 2 0 maybe none - so just
        // compute
        // common divisor between existing elements - it could be a multiple of the second
        // at third staage 0 we know fist have none - so just divide the third by first 2 - much faster that way.
        for (int combinationNo = 2; combinationNo <= uniqueIndex; combinationNo++) {
            List<Comb> newCombs = new ArrayList<>();
            for (Comb comb : combs) {
                for (int j = comb.comb[comb.comb.length - 1] + 1; j < uniqueIndex; j++) {
                    int[] newComb = Arrays.copyOf(comb.comb, comb.comb.length + 1);
                    newComb[newComb.length - 1] = j;
                    Comb e = new Comb(newComb, common(comb.divisors, divisors(unique[j])));
                    newCombs.add(e);
                    if (e.divisors.isEmpty()) {
                        return "YES"; // what we need to solve is the opposite - is there a comb with no divisors
                    }
                }
            }
            combs = newCombs;
        }
        return "NO";

    }

    private static TreeSet<Integer> common(TreeSet<Integer> divisors, TreeSet<Integer> divisors1) {
        TreeSet newSet = new TreeSet<>();
        for(int i : divisors){
            if (divisors1.contains(i)){
                newSet.add(i);
            }
        }
        return newSet;
    }


    static TreeSet<Integer> divisors(int n) {
        TreeSet<Integer> divisors = new TreeSet<>();
        for (int i = 2; i <= n / 2; i++){
            if (n % i == 0){
                divisors.add(i);
            }
        }
        divisors.add(n);
        return divisors;
    }

    static boolean isThereADivisorOfAll(int[] indexes, int[] values) {
        // find at least on divisor of all

            for (int i = 2; i <= values[indexes[0]] / 2; i++) { // all divisors
                boolean allDivisible = true;
                for (int index : indexes) {
                    if (values[index] % i != 0) {
                        allDivisible = false;
                        break;
                    }
                }
                if (allDivisible) {
                    return true;
                }
            }


        for (int x = 1; x < indexes.length; x++) {
            boolean allDivisible = true;
            if (values[x] % values[indexes[0]] != 0) {
                allDivisible = false;
                break;
            }
            if (allDivisible){
                return true;
            }
        }


        return false;
    }

    @Test
    public void test(){
        assertEquals("YES", solve(new int[]{1,2,3}));
        assertEquals("NO", solve(new int[]{2,4}));
        assertEquals("NO", solve(new int[]{5,5,5}));

        assertEquals("NO", solve(stringToIntArray("74973 74973 74973 74973 74973 74973 74973 74973")));
        assertEquals("NO", solve(stringToIntArray("87196 87196 87196")));
        assertEquals("YES", solve(stringToIntArray("85390 7702 49731 70332 67910 48742 50887 44971 95400")));
        assertEquals("YES", solve(stringToIntArray("40259 67816 88585 6000 77003 75876 69638 32893 65536 25985 96305 16341 45743 69600 19252 52894 72430 38046 41155 85209 63454 89935 7899 91520 60042 71267 29507 6599 53511")));
        assertEquals("NO", solve(stringToIntArray("97706 48853")));
        assertEquals("NO", solve(stringToIntArray("63178 63178 63178 63178 63178 63178")));
        assertEquals("NO", solve(stringToIntArray("97290 32430 97290 97290 48645 48645 64860 97290 32430 97290 97290 64860 16215 48645 81075 48645 48645 32430 16215 16215 16215 48645 97290 64860 32430 81075 97290 97290 81075 64860 81075 32430 81075 48645 81075 81075 48645 97290 64860 16215 64860 48645 64860 97290 32430 97290 16215 64860 97290 81075 16215 64860 81075 97290 81075 48645 48645 64860 16215 16215 48645 81075 16215 97290 64860 64860 97290 16215 16215 16215 64860 81075 16215 32430 81075 97290 48645 16215 97290 81075 97290 16215 16215 16215 16215 81075 32430 97290 48645 32430")));
    }


    @Test
    public void test1(){
        assertEquals("YES", solve1(new int[]{1,2,3}));
        assertEquals("NO", solve1(new int[]{2,4}));
        assertEquals("NO", solve1(new int[]{5,5,5}));

        assertEquals("NO", solve1(stringToIntArray("74973 74973 74973 74973 74973 74973 74973 74973")));
        assertEquals("NO", solve1(stringToIntArray("87196 87196 87196")));
        assertEquals("YES", solve1(stringToIntArray("85390 7702 49731 70332 67910 48742 50887 44971 95400")));
        assertEquals("YES", solve1(stringToIntArray("40259 67816 88585 6000 77003 75876 69638 32893 65536 25985 96305" +
                " 16341 45743 69600 19252 52894 72430 38046 41155 85209 63454 89935 7899 91520 60042 71267 29507 6599 53511")));
        assertEquals("NO", solve1(stringToIntArray("97706 48853")));
        assertEquals("NO", solve1(stringToIntArray("63178 63178 63178 63178 63178 63178")));
        assertEquals("NO", solve1(stringToIntArray("97290 32430 97290 97290 48645 48645 64860 97290 32430 97290 97290 " +
            "64860 16215 48645 81075 48645 48645 32430 16215 16215 16215 48645 97290 64860 32430 81075 97290 97290 81075 64860 81075 32430 81075 48645 81075 81075 48645 97290 64860 16215 64860 48645 64860 97290 32430 97290 16215 64860 97290 81075 16215 64860 81075 97290 81075 48645 48645 64860 16215 16215 48645 81075 16215 97290 64860 64860 97290 16215 16215 16215 64860 81075 16215 32430 81075 97290 48645 16215 97290 81075 97290 16215 16215 16215 16215 81075 32430 97290 48645 32430")));
    }

    private int[] stringToIntArray(String string) {
        return Arrays.stream(string.split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
    }

}

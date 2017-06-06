package rank.searching;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created on 6/6/2017.
 *
 * 10
 203 204 205 206 207 208 203 204 205 206
 13
 203 204 204 205 206 207 205 208 203 206 205 206 204

 Output
 204 205 206

 Numeros, the Artist, had two lists  and , such that  was a permutation of . Numeros was very proud of these lists. Unfortunately, while transporting them from one exhibition to another, some numbers were left out of . Can you find the missing numbers?

 Notes

 If a number occurs multiple times in the lists, you must ensure that the frequency of that number in both lists is the same. If that is not the case, then it is also a missing number.
 You have to print all the missing numbers in ascending order.
 Print each missing number once, even if it is missing multiple times.
 The difference between maximum and minimum number in  is less than or equal to .

 */
public class MissingNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeMap<Integer, Integer> a = new TreeMap<>();
        for(int i = 0; i < n; i++){
            a.merge(sc.nextInt(), 1, Integer::sum);
        }
        int m = sc.nextInt();
        TreeMap<Integer, Integer> b = new TreeMap<>();
        for(int i = 0; i < m; i++){
            b.merge(sc.nextInt(), 1, Integer::sum);
        }
        for(Integer key : b.keySet()){
            int bFreq = b.getOrDefault(key,0);
            int aFreq = a.getOrDefault(key,0);
            if (aFreq!=bFreq){
                System.out.printf(key + " ");
            }
        }
    }

}

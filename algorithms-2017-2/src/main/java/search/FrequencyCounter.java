package search;

import java.util.Scanner;

/**
 * Created on 6/6/2017.
 */
public class FrequencyCounter {
    public static void main(String[] args) {
        ST<String, Integer> st = new SequentialSearchST<>();
        Scanner in = new Scanner(System.in);
        String word = null;
        while (!(word = in.next()).isEmpty()) {
            if (st.contains(word)) {
                st.put(word, st.get(word) + 1);
            } else {
                st.put(word, 1);
            }
        }

        String maxFreqWord = null;
        for (String key : st.keys()) {
            if (maxFreqWord == null || st.get(key) > st.get(maxFreqWord)) {
                maxFreqWord = key;
            }
        }
        System.out.printf("Max frequency %s with %d ", maxFreqWord, st.get(maxFreqWord));
    }
}

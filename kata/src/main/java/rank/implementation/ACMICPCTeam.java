package rank.implementation;

import org.junit.Test;

import java.util.BitSet;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Created on 7/4/2017.
 * challenges/acm-icpc-team
 * <p>
 * You are given a list of  people who are attending ACM-ICPC World Finals. Each of them are either well versed in a topic or they are not. Find out the maximum number of topics a 2-person team can know. And also find out how many teams can know that maximum number of topics.
 * <p>
 * Note Suppose a, b, and c are three different people, then (a,b) and (b,c) are counted as two different teams.
 * <p>
 * The first line contains two integers,  and , separated by a single space, where  represents the number of people, and  represents the number of topics.  lines follow.
 * Each line contains a binary string of length . If the th line's th character is , then the th person knows the th topic; otherwise, he doesn't know the topic.
 */
public class ACMICPCTeam {

    @Test
    public void c1() {
        MaxSubjects maxSubjects = new MaxSubjects(
                toBitSet(5, "10101"),
                toBitSet(5, "11100"),
                toBitSet(5, "11010"),
                toBitSet(5, "00101")
        ).invoke();
        assertEquals(Integer.valueOf(5), Integer.valueOf(maxSubjects.getMax()));
        assertEquals(Integer.valueOf(2), Integer.valueOf(maxSubjects.getCount()));
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int max = 0;
        int count = 0;

        BitSet[] people = new BitSet[n];
        for (int i = 0; i < n; i++) {
            String s = in.next();
            BitSet set = toBitSet(m, s);
            people[i] = set;
        }

        MaxSubjects maxSubjects = new MaxSubjects(people).invoke();
        max = maxSubjects.getMax();
        count = maxSubjects.getCount();

        System.out.println(max);
        System.out.println(count);
    }

    private static BitSet toBitSet(int m, String s) {
        BitSet set = new BitSet(m);
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '1') {
                set.flip(j);
            }
        }
        return set;
    }

    private static class MaxSubjects {
        private BitSet[] people;
        int max;
        int count;

        public MaxSubjects(BitSet... people) {
            this.people = people;
        }

        public int getMax() {
            return max;
        }

        public int getCount() {
            return count;
        }

        public MaxSubjects invoke() {
            for (int i = 0; i < people.length; i++) {
                for (int j = i + 1; j < people.length; j++) {
                    BitSet newB = new BitSet(people.length);
                    newB.or(people[i]);
                    newB.or(people[j]);
                    int bits = newB.cardinality();
                    if (bits > max) {
                        max = bits;
                        count = 1;
                    } else if (bits == max) {
                        count++;
                    }

                }
            }
            return this;
        }
    }
}

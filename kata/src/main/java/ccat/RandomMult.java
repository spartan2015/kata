package ccat;

import org.junit.internal.InexactComparisonCriteria;

import java.security.SecureRandom;
import java.util.Scanner;

/**
 * https://docs.google.com/document/d/1QHMvjFcCDKob_ON3pYE1YWhzLsB_yHZr6CGoYx0T9uY/edit
 */
public class RandomMult {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SecureRandom rand = new SecureRandom();
        long allStart = System.currentTimeMillis();
        String next = "";
        do {
            next = multiply(sc, rand);
            if ("q".equals(next)) break;
            next = nextLetter(sc, rand);
            if ("q".equals(next)) break;

        } while (!"".equals(next));

        System.out.println("All Duration: " + (System.currentTimeMillis() - allStart));

    }

    private static String nextLetter(Scanner sc, SecureRandom rand) {
        long startTime = System.currentTimeMillis();
        int space = 1+rand.nextInt(3);
        int start = rand.nextInt(25 - 3 * space);

        int space1 = 1+rand.nextInt(3);
        int start1 = rand.nextInt(25 - 3 * space1);

        StringBuffer sb = new StringBuffer();
        sb.append((char) (65 + start));
        sb.append((char) (65 + start1));
        sb.append(" ");
        sb.append((char) (65 + start + space));
        sb.append((char) (65 + start1 + space1));
        sb.append(" ");
        sb.append((char) (65 + start + 2 * space));
        sb.append((char) (65 + start1 + 2 * space1));
        sb.append(" ");

        System.out.println(sb);

        StringBuffer res = new StringBuffer();
        res.append((char) (65 + start + 3 * space));
        res.append((char) (65 + start1 + 3 * space1));

        String next = sc.next();
        if ("q".equals(next)) return next;

        if (res.toString().equals(next)) {
            System.out.println("yes");
        } else {
            System.out.println("No: " + res);
        }

        System.out.println("Duration: " + (System.currentTimeMillis() - startTime));
        return next;
    }


    private static String multiply(Scanner sc, SecureRandom rand) {
        String next;
        int first = rand.nextInt(300);
        int second = rand.nextInt(300);
        long start = System.currentTimeMillis();
        System.out.println(first + " " + second);

        next = sc.next();

        if ("q".equals(next)) return next;

        String res = String.valueOf(first * second);
        if (res.equals(next)) {
            System.out.println("Yes");
        } else {
            System.out.println("No: " + res);
        }
        System.out.println("Duration: " + (System.currentTimeMillis() - start));
        return next;
    }
}

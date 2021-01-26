package y2020;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * SeparateTheNumbers
 * /challenges/separate-the-numbers/problem
 */
public class SeparateTheNumbers {

    private ByteArrayOutputStream bo;

    @Before
    public void before() {
        bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));
    }

    static void separateNumbers(String s) {

        for (int size = 1; size <= s.length() / 2; size++) {
            long first = Long.valueOf(s.substring(0, size));
            int count = 1;

            boolean allGood = true;

            for (int index = size; index < s.length() ;) {
                Long nextExpected = first + 1 * count;

                int nextSize = nextExpected.toString()
                        .length();

                if (!s.substring(index, Math.min(s.length(), index + nextSize))
                        .equals(nextExpected.toString())) {
                    allGood = false;
                    break;
                }
                index += nextSize;

                count++;
            }

            if (allGood) {
                System.out.println("YES " + first);
                return;
            }
        }
        System.out.println("NO");
    }

    @Test
    public void t(){
        separateNumbers("123");
        assertEquals("YES 1\r\n",new String(bo.toByteArray()));
    }

    @Test
    public void t2(){
        separateNumbers("91011");
        assertEquals("YES 9\r\n",new String(bo.toByteArray()));
    }

    @Test
    public void t3(){
        separateNumbers("99100");
        assertEquals("YES 99\r\n",new String(bo.toByteArray()));
    }

    @Test
    public void t4(){
        separateNumbers("42949672954294967296429496729");
        assertEquals("NO\r\n",new String(bo.toByteArray()));
    }
}

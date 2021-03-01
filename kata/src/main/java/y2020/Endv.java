package y2020;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Endv {
    public boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        char[] ar = a.toCharArray();
        Arrays.sort(ar);
        char[] br = b.toCharArray();
        Arrays.sort(br);

        for (int i = 0; i < ar.length; i++) {
            if (ar[i] != br[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram1(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        List<String> ofA = Arrays.stream(a.split("")).sorted().collect(Collectors.toList());
        List<String> ofB = Arrays.stream(b.split("")).sorted().collect(Collectors.toList());

        for (int i = 0; i < a.length(); i++) {
            if (!ofA.get(i).equals(ofB.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testIsAnagram() {
        assertTrue(isAnagram("santa", "satan"));
        assertFalse(isAnagram("santa", "satai"));
    }

    @Test
    public void testIsAnagram1() {
        assertTrue(isAnagram1("santa", "satan"));
        assertFalse(isAnagram1("santa", "satai"));
    }
}

package y2020;

/**
 * /challenges/camelcase/problem
 */
public class CamelCase {

    static int camelcase(String s) {
        if (s.length() == 0) return 0;
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
                count++;
            }
        }
        return count;
    }


}

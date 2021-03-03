package y2020;
/*
/challenges/hackerrank-in-a-string/problem
*/
public class HackerrankInAString {

    // Complete the hackerrankInString function below.
    static String hackerrankInString(String s) {
        char[] hr = "hackerrank".toCharArray();
        int index = 0;

        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i) == hr[index]){
                index++;
            }
            if (index == hr.length){
                break;
            }
        }

        if (index == hr.length){
            return "YES";
        }else{
            return "NO";
        }

    }


}

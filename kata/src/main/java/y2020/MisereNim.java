package y2020;

/*
/challenges/misere-nim-1/problem

 */
public class MisereNim {

    // Complete the misereNim function below.
    static String misereNim(int[] s) {
        int xor =0;
        int sum =0;
        for(int i : s){
            xor^=i;
            sum+=i;
        }


        if (sum == s.length && s.length % 2 == 0){
            return "First";
        }else if (sum == s.length && s.length % 2 == 1){
            return "Second";
        }else if (xor != 0){
            return "First";
        }else{
            return "Second";
        }

    }

}

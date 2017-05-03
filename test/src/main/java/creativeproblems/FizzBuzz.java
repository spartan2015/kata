package creativeproblems;


// Write a program that prints the numbers from 1 to 100. 
//But for multiples of three print "Fizz" instead of the number and for 
//the multiples of five print "Buzz". 
//For numbers which are multiples of both three and five print "FizzBuzz".

import com.sun.org.apache.xalan.internal.xsltc.runtime.InternalRuntimeError;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzz {

    interface Formater{
        boolean format(int i);
    }

    @SuppressWarnings("unchecked")
	public static void main(String[] args) {

        print(1,150, new ArrayList(){
            {
                add((Formater) (int i) -> {
                    if (i % 3 == 0) {
                        System.out.println("Fizz");
                        return true;
                    } else {
                        return false;
                    }
                });
                add((Formater) (int i) -> {
                    if (i % 5 == 0) {
                        System.out.println("Buzz");
                        return true;
                    } else {
                        return false;
                    }
                });
                add((Formater) (int i) -> {
                    if (i % 7 == 0) {
                        System.out.println("Buzz7");
                        return true;
                    } else {
                        return false;
                    }
                });

            }
        });


    }

    static void print(int start, int end, List<Formater> formatters){

        for (int i = start; i <= end; i++) {
            boolean printed = false;
            for (Formater f : formatters) {
                if (f.format(i)) {
                    printed = true;
                    break;
                }
            }
            if (!printed){
                System.out.println(i);
            }
        }
    }




}
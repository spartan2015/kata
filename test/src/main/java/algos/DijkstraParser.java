package algos;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

import static org.junit.Assert.assertTrue;

/**
 * Created by Battlestar on 2/7/2015.
 */
public class DijkstraParser {
    Stack<String> operators = new Stack<>();
    Stack<String> operands = new Stack<>();

    @Test
    public void t(){
        assertTrue( 10 == parse("(1+1)*5"));

        assertTrue( 8 == parse("(2+2)*2"));

        assertTrue( 9 == parse("3*(2+1)"));

        assertTrue( 36 == parse("3*((2+1)*(2+2))"));
    }

    public int parse(String str){

        char[] chars = str.toCharArray();

        for(int i = 0 ; i < str.length(); i++){
           char c = chars[i];
           if (isOperator(c)){
                operators.push(c+"");
           }else if (c == ')'){
               operands.push(computeParenthesis().toString());
           }else if(c != '('){
               operands.push(c+"");
           }
        }

        while(operators.size() > 0){
            operands.push(computeParenthesis() + "");
        }

        return Integer.parseInt(operands.pop());

    }

    Integer computeParenthesis(){
        String operator = operators.pop();
        switch(operator){
            case "+":{
                return Integer.parseInt(operands.pop().toString()) + Integer.parseInt(operands.pop().toString());
            }
            case "*":{
                return Integer.parseInt(operands.pop().toString()) * Integer.parseInt(operands.pop().toString());
            }
            case "-":{
                Integer first = Integer.parseInt(operands.pop().toString());
                Integer second = Integer.parseInt(operands.pop().toString());
                return second - first;
            }
            default:{
                throw new RuntimeException("Unknown operator: " + operator);
            }
        }
    }

    boolean isOperator(char c){
         switch(c){
             case '+':
             case '-':
             case '*':
                 return true;
             default: return false;
         }
    }
}

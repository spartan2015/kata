package patterns;

import org.junit.Test;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Created by Battlestar on 2/11/2015.
 */
public class ChainOfResponsibility {

    static abstract class Processor<T>{
        protected Processor<T> successor;

        protected abstract T doWork(T input);

        public T handle(T input){
            T r = doWork(input);
            if (successor != null){
                return successor.handle(r);
            }
            return r;
        }
    }

    static class HeaderProcessor extends Processor<String>{
        @Override
        protected String doWork(String input) {
            return "Hello\n" + input;
        }
    }

    static class SpellcheckProcessor extends Processor<String>{
        @Override
        protected String doWork(String input) {
            return input.replace("labda", "lambda");
        }
    }

    @Test
    public void test(){
        Processor<String> first = new HeaderProcessor();
        Processor<String> second = new SpellcheckProcessor();

        first.successor = second; // chain them - ops that must happen one after another

        String r = first.handle("i love labda !");
        System.out.println(r);

    }

    @Test
    public void chainOfResponsiblityWithFunction(){
        Function<String, String> chainOfResponsability = (s)->{ return "Hello\n"+s;};
        //UnaryOperator<T>  extends Function<T,T> - provides some functionality plus identity
        chainOfResponsability = chainOfResponsability.andThen((s)->{ return s.replace("labda", "lambda");});
        String r = chainOfResponsability.apply("I love labda !");
        System.out.println(r);
    }
}

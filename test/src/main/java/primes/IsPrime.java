package primes;

import org.junit.Test;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.IntStream;

/**
 * Created by Battlestar on 2/6/2015.
 */
public class IsPrime {

    @Test
    public void clasicPrimeNumbersWithIteration(){
        for(int i = 1; i < 1000; i++){
            boolean secondTest = isPrimeLS(i);

            if (isPrime(i)) {
                System.out.println("" + i + " second LS is prime says: " + secondTest);
            }
        }
    }

    public static boolean isPrime(int n){
        if (n <= 3) return true;
        for(int i = 2; i*i <= n; i++){
            if (n % i == 0) return false;
        }
        return true;
    }


    @Test
    public void clasicPrimeNumbersWithStreams(){
        IntStream.rangeClosed(2, 1000).boxed().filter(IsPrime::isPrimeLS).forEach(System.out::println);
    }

    public static boolean isPrimeLS(int n){
        return IntStream.rangeClosed(2, (int)Math.sqrt(n)).noneMatch(i -> {
            System.out.println(String.format("%d mod %d",n,i)); return n % i == 0;});
    }

    /*
    * optimized prime number with stream - checking only against previously found primes
    * */
    @Test
    public void optimizedIsPrimeCollector(){
        IntStream.rangeClosed(2, 1000).boxed().collect(new Collector<Integer, List<Integer>,List<Integer>>(){

            List<Integer> primes = new ArrayList<>();{
                primes.add(2);
            }

            @Override
            public Supplier<List<Integer>> supplier() {
                return ()->primes;
            }

            @Override
            public BiConsumer<List<Integer>, Integer> accumulator() {
                // because of the isPrimeLSOptimizes - can't ran concurrently - because we compare with previous found primes = SERIAL
                return (list, value) -> { if (isPrimeLSOptimized(primes, value)) list.add(value); };
            }

            @Override
            public BinaryOperator<List<Integer>> combiner() {
                throw new UnsupportedOperationException("SERIAL COLLECTOR");
            }

            @Override
            public Function<List<Integer>, List<Integer>> finisher() {
                return Function.identity();
            }

            @Override
            public Set<Characteristics> characteristics() {
                return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
            }
        }).stream().forEach(System.out::println);
    }

    public static boolean isPrimeLSOptimized(List<Integer> primesSoFar, int n){
        int squareRoot = (int)Math.sqrt(n);
        return takeWhile(primesSoFar, (i)-> i<=squareRoot).stream().noneMatch(p -> n % p == 0);
    }

    // return sublist starting from 0 until the first element that does not match the predicate
    public static <A> List<A> takeWhile(List<A> list , Predicate<A> p){
        int i = 0;
        for (A item : list){
            if (!p.test(item)){
                return list.subList(0, i);
            }
            i++;
        }
        return list;
    }



}

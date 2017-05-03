package java8;

import org.junit.Test;

import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by Battlestar on 2/13/2015.
 */
public class FunctionalTest {

    @Test
    public void test() {
        Function<String, String> f = (s) -> s;

        Function<String, String> chain = f.andThen(FunctionalTest::addHeader)
                .andThen(FunctionalTest::spellCheck)
                .andThen(String::toUpperCase)
                .andThen(String::intern);
        chain = chain.compose((String s) -> s.replace("l", "X"));

        System.out.println(chain.apply("hello"));

        // Currying - reusing function call patterns - generic function + specific parameters = specific goal - reusing a generic function
        DoubleUnaryOperator celsiusToFahrenheit = transform(9 / 5, 32);
        DoubleUnaryOperator milesToKm = transform(1.6, 0);
        DoubleUnaryOperator usdToEur = transform(1.2, 0);

        double eur = usdToEur.applyAsDouble(100);
        double km = milesToKm.applyAsDouble(100);
        double fahrenheit = celsiusToFahrenheit.applyAsDouble(37);

    }

    public static String addHeader(String s) {
        return "Header-" + s;
    }

    public static String spellCheck(String s) {
        return s + "-spell";
    }

    DoubleUnaryOperator transform(double f, double b) {
        return (double x) -> x * f + b;
    }

    static class TrainJourney{
        String to;
        int price;
        TrainJourney next;

        TrainJourney(String to, int price, TrainJourney next){
            this.to = to;
            this.price = price;
            this.next = next;
        }
    }

    @Test
    public void functional1() {
        TrainJourney a = new TrainJourney("Bucuresti",10,null);
        TrainJourney b = new TrainJourney("Londra", 100, null);

        // imperative linking
        link(a,b);
    }

    /**
     * imperative linking - mutates initial journei A
     * @param a
     * @param b
     */
    public void link(TrainJourney a, TrainJourney b){
        TrainJourney t = a;
        while( (t = t.next) != null){
            t = t.next;
        }
        t.next = b;
    }

    /**
     * functional - does not change A - creates a completely new structure that will link to b
     * b journey stays the same, a the same - CREATES AN ENTIRE NEW STRUCTURE - NO SIDEEFECTS - FUNCTIONAL
     * THREAD SAFE IF ALL DO FUNCTIONAL AND NOWONE ATTEMPTS CHANGING an existing structure
     * @param a
     * @param b
     * @return
     */
    TrainJourney functionalLink(TrainJourney a, TrainJourney b){
        return a== null ? b : new TrainJourney(a.to, a.price, functionalLink(a.next,b));
    }

    @Test
    public void functional2(){

    }

    <T extends Comparable> void imperativeUpdate(Tree<T> tree, T key, Object value){
        if (tree == null) return;
        if (tree.key.equals(key)) tree.value = value;
        else imperativeUpdate(key.compareTo(tree.key) > 0 ? tree.right :tree .left, key, value);
    }

    <T extends Comparable> Tree<T> imperativeUpdateOrAdd(Tree<T> tree, T key, Object value){
        if (tree == null) return new Tree(key,value,null, null);
        if (tree.key.equals(key)) tree.value = value;
        else {
            if (key.compareTo(tree.key) > 0){
                tree.right = imperativeUpdateOrAdd(tree.right , key, value);
            }else{
                tree.left = imperativeUpdateOrAdd( tree .left, key, value);
            }
        }
        return tree;
    }

    /**
     * functional - no side effect, thread safe as long as all who use this tree work functional
     *
     * example of a persistent functional date structure
     *
     * @param tree
     * @param key
     * @param value
     * @param <T>
     * @return
     */
    <T extends Comparable> Tree<T> functionalUpdate(Tree<T> tree, T key, Object value){
        return tree == null ? new Tree(key, value, null, null) : tree.key.equals(key) ? new Tree(key,value, tree.left, tree.right) :
                key.compareTo(key) < 0 ?
                        new Tree(tree.key, tree.value, functionalUpdate(tree.left, key, value), tree.left.right) :
                        new Tree(tree.key, tree.value, tree.right.left, functionalUpdate(tree.right,key, value));
    }

    static class Tree<T extends Comparable>{
        T key;
        Object value;
        Tree left, right;

        Tree(T key, Object value, Tree l, Tree r){
            this.key = key; this.value = value; this.left = l; this.right = r;
        }
    }


    static interface MyList<T>{
        T head();
        MyList<T> tail();
        default boolean isEmpty(){
            return true;
        }

        default MyList<T> filter(Predicate<T> predicate){
            System.out.println("FILTER " + head());
            return isEmpty() ? this :
                    predicate.test(head()) ?
                            new MyLazyLinkedList<T>(head(), () -> tail().filter(predicate)) :
                            tail().filter(predicate);
        }
    }

    static class MyLazyLinkedList<T> implements MyList<T>{
        private final T head;
        private final Supplier<MyList<T>> tail;

        MyLazyLinkedList(T head, Supplier<MyList<T>> tail){
            System.out.println("MyLazyLinkedList head " + head);
            this.head = head;
            this.tail = tail;
        }

        @Override
        public T head() {
            return head;
        }

        @Override
        public MyList<T> tail() {
            System.out.println("TAIL()");
            return tail.get();
        }

        @Override
        public boolean isEmpty() {
            return false;
        }
    }

    static class Empty<T> implements MyList<T>{

        @Override
        public T head() {
            throw new UnsupportedOperationException();
        }

        @Override
        public MyList<T> tail() {
            throw new UnsupportedOperationException();
        }
    }

    @Test
    public void lazyList(){
        MyList<Integer> linkedList = new MyLazyLinkedList<>(5, ()->new MyLazyLinkedList<>(10, ()->new Empty<>()));

        MyList<Integer> one = from(1);
        Integer two = one.tail().head();
        Integer three = one.tail().tail().head();

        MyList<Integer> start = from(0);
        for(int i = 0; i < 5; i++){
            start = start.tail();
            System.out.println(start.head());
        }
    }

    MyList from(int n){
        return new MyLazyLinkedList<Integer>(n, ()->from(n+1));
    }

    @Test
    public void infinitePrimeNumbersGenerator(){
        MyList<Integer> start = primes(from(2));
        for(int i = 0; i < 2; i++){
            System.out.println(start.head());
            start = start.tail();
        }
    }

    MyList<Integer> primes(MyList<Integer> numbers){
        System.out.println("PRIMES: " + numbers.head());
        return new MyLazyLinkedList<Integer>(
                numbers.head(),
                ()-> primes(numbers.tail().filter(n-> {
                    System.out.printf("%d mod %d = %b", n, numbers.head(), n % numbers.head() != 0);
                    return n % numbers.head() != 0;}))
        );
    }

}
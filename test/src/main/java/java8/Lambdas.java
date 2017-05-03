package java8;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.junit.Test;

import javax.xml.transform.sax.SAXSource;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.System.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * 1.1. Describe Java inner classes and develop the code that uses Java inner classes (such as: nested class, static class, local class and anonymous classes)
 * 1.2. Define and write functional interfaces
 * 1.3. Describe a Lambda expression; refactor the code that use anonymous inner class to use Lambda expression; including type inference, target typing
 * 2.1. Describe the built in interfaces included in Java 8 – java.uilt.function package
 * 2.2. Develop code that uses Function interface
 * 2.3. Develop code that uses Consumer interface
 * 2.4. Develop code that uses Supplier interface
 * 2.5. Develop code that uses UnaryOperator interface
 * 2.6. Develop code that uses Predicate interface
 * 2.7. Develop the code that use primitive and binary variations of base interfaces of java.util.function package
 * 2.8. Develop the code that use method reference; including refactor the code that use Lambda expression to use method references
 * 3.1. Develop the code that iterates a collection by using forEach; including method chaining
 * 3.2. Describe the Stream interface and pipelines
 * 3.3. Filter a collection using lambda expressions
 * 3.4. Identify lambda operations that are lazy
 * 4.1. Develop the code to extract data from an object using map
 * 4.2. Search for data using search methods including: findFirst, findAny, anyMatch, allMatch, noneMatch.
 * 4.4. Perform calculations using methods: count, max, min, average, sum
 * 4.5. Sort a collection using lambda expressions
 * 4.6. Save results to a collection by using the collect method and Collector class; including methods such as averagingDouble, groupingBy, joining, partitioningBy
 * 5.1. Develop the code that use parallel streams -- hm...
 * 5.2. Implement decomposition, reduction, in streams
 * 6.4. Describe other stream sources: Arrays.stream(), IntStream.range()
 */
public class Lambdas {
    @ToString
    @EqualsAndHashCode
    static class Dish {
        public enum Type {MEAT, FISH, OTHER}

        private final String name;
        private final boolean vegetarian;
        private final int calories;
        private final Type type;

        public Dish(String name, boolean vegetarian, int calories, Type type) {
            this.name = name;
            this.vegetarian = vegetarian;
            this.calories = calories;
            this.type = type;
        }

        public Type getType() {
            return type;
        }

        public String getName() {
            return name;
        }

        public boolean isVegetarian() {
            return vegetarian;
        }

        public int getCalories() {
            return calories;
        }
    }

    List<Dish> dishes = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT), new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));


    static class Trader {
        private final String name;
        private final String city;

        public Trader(String n, String c) {
            this.name = n;
            this.city = c;
        }

        public String getName() {
            return this.name;
        }

        public String getCity() {
            return this.city;
        }

        public String toString() {
            return "Trader:" + this.name + " in " + this.city;
        }
    }

    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");
    Trader raoul = new Trader("Raoul", "Cambridge");

    List<Trader> traders = Arrays.asList(mario, alan, brian, raoul);

    static class Transaction {
        private final Trader trader;
        private final int year;
        private final int value;

        public Transaction(Trader trader, int year, int value) {
            this.trader = trader;
            this.year = year;
            this.value = value;
        }

        public Trader getTrader() {
            return this.trader;
        }

        public int getYear() {
            return this.year;
        }

        public int getValue() {
            return this.value;
        }

        public String toString() {
            return "{" + this.trader + ", " +
                    "year: " + this.year + ", " +
                    "value:" + this.value + "}";
        }
    }

    List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    /**
     * 1.1. Describe Java inner classes and develop the code that uses Java inner classes (such as: nested class, static class, local class and anonymous classes)
     * 1.2. Define and write functional interfaces
     * 1.3. Describe a Lambda expression; refactor the code that use anonymous inner class to use Lambda expression; including type inference, target typing
     * 2.8. Develop the code that use method reference; including refactor the code that use Lambda expression to use method references
     */
    @Test
    public void fileFilter() {

        new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        // vs lambda
        new File(".").listFiles(File::isHidden); // inference if the parameters (a File in this case) and of the result - boolean
        // inference done based on the functional interface
    }


    interface Predicate<T> {
        boolean test(T e);
    }

    public static boolean isHeavy(Integer i) {
        return i < 0;
    }

    @Test
    public void filtering() {

        List<Integer> list = Arrays.asList(1, 2, 2, 3);

        class FilterCollection<T> {
            List<T> filter(List<T> list, Predicate<T> predicate) {
                List<T> filteredList = new ArrayList<>();
                for (T e : list) {
                    if (predicate.test(e)) {
                        filteredList.add(e);
                    }
                }
                return filteredList;
            }
        }


        new FilterCollection<Integer>().filter(list, (e) -> {
            return e > 0;
        });

        new FilterCollection<Integer>().filter(list, Lambdas::isHeavy);

    }

    /*
     2.1. Describe the built in interfaces included in Java 8 – java.uilt.function package
     2.2. Develop code that uses Function interface
     2.3. Develop code that uses Consumer interface
     2.4. Develop code that uses Supplier interface
     2.5. Develop code that uses UnaryOperator interface
     2.6. Develop code that uses Predicate interface
     2.7. Develop the code that use primitive and binary variations of base interfaces of java.util.function package
    */
    @Test
    public void javaUtilFunctionPackage() {

        java.util.function.Predicate<String> predicate = (string)->true;
        java.util.function.IntPredicate intPredicate = (in)->true;
        java.util.function.LongPredicate longPredicate = (lon)->true;
        java.util.function.DoublePredicate doublePredicate = (db1)->true;

        java.util.function.Predicate<String> p;
        predicate.test("s");
        p = predicate.and((s)->true);
        p = predicate.or((s)->true);
        p = predicate.negate();

        java.util.function.BiPredicate<String,String> biPredicate = (str1,str2)->true;

        java.util.function.Function<String, String> function = (str)->str;
        Function<String,String> chain = function.andThen((s)->s).andThen((s)->s);
        Function<String,String> inverseChain = function.<String>compose((s)->s).<String>compose((s)->s);
        String result = function.apply("s");

        java.util.function.IntFunction<String> intFunction = (in)->"";
        java.util.function.IntToLongFunction intToLongFunction = (in)->1l;
        java.util.function.IntToDoubleFunction intToDoubleFunction = (in)->1.2;
        java.util.function.LongFunction<Boolean> longFunction = (lon)->true;
        java.util.function.LongToIntFunction longToIntFunction = (lon) -> 1;
        java.util.function.LongToDoubleFunction longToDoubleFunction = (lon)->1.2;
        java.util.function.DoubleFunction<Boolean> doubleFunction = (db1)->true;
        java.util.function.ToIntFunction<String> toIntFunction = (str)->1;
        java.util.function.ToLongFunction<String> toLongFunction = (str)->123L;
        java.util.function.ToDoubleFunction<String> toDoubleFunction = (str)->1.2;

        java.util.function.BiFunction<String,String,String> biFunction = (str1,str2)->"";
        java.util.function.ToIntBiFunction<String,String> toIntBiFunction= (str1,str2)->1;
        java.util.function.ToLongBiFunction<String,String> toLongBiFunction = (str1,str2)->1L;
        java.util.function.ToDoubleBiFunction<String,String> toDoubleBiFunction = (str1,str2)->1.2;

        java.util.function.UnaryOperator<String> unaryOperatorFunction = (str)->str+"1";
        java.util.function.UnaryOperator.identity();

        function = unaryOperatorFunction; // UnaryOperator extends Function
        java.util.function.IntUnaryOperator intUnaryOperator = (in)->in++;
        java.util.function.LongUnaryOperator longUnaryOperator = (lon)->lon++;
        java.util.function.DoubleUnaryOperator doubleUnaryOperator = (db)->db++;

        java.util.function.BinaryOperator<String> binaryOperator = (str1,str2)->str1+str2;
        BinaryOperator<String> min = java.util.function.BinaryOperator.minBy(String::compareTo);
        BinaryOperator<String> max = java.util.function.BinaryOperator.maxBy(String::compareTo);

        biFunction = binaryOperator; // BinaryOperator extends BiFunction
        java.util.function.IntBinaryOperator intBinaryOperator = (in1,in2)->in1+in2;
        java.util.function.LongBinaryOperator longBinaryOperator = (lon1,lon2)->lon1+lon2;
        java.util.function.DoubleBinaryOperator doubleOperator = (db1, db2)->db1;

        java.util.function.Consumer<String> consumer = (str)->{};
        java.util.function.Consumer<String> chainOfConsumersForSameValue = consumer.andThen((s)->{}).andThen((s)->{});

        java.util.function.IntConsumer intConsumer = (in)->{};
        java.util.function.LongConsumer longConsumer = (lon)->{};
        java.util.function.DoubleConsumer doubleConsumer = (double1)->{};

        java.util.function.BiConsumer<String, String> biConsumer = (str1,str2)->{};
        java.util.function.ObjIntConsumer objIntConsumer = (obj,in)->{};
        java.util.function.ObjLongConsumer objLongConsumer = (obj,lon)->{};
        java.util.function.ObjDoubleConsumer objDoubleConsumer = (obj,db)->{};

        java.util.function.Supplier<String> supplier = ()->"";
        java.util.function.IntSupplier intSupplier = ()->1;
        java.util.function.LongSupplier longSupplier = ()->1L;
        java.util.function.DoubleSupplier doubleSupplier = ()->1.2;
        java.util.function.BooleanSupplier booleanSupplier = ()->Boolean.FALSE;

        Runnable r = ()-> System.out.println("a"); // WORKS with STATEMENT - cause it returns void

        Consumer<String> c = (str)->new ArrayList().add(str); // add function return boolean so this is a statement - still works even without {}
        //Consumer<String> s = (str)->""; // incompatible return type string now - WTF ! Error:(303, 37) java: incompatible types: bad return type in lambda expression java.lang.String cannot be converted to void

        // can use local vars in lambada but they have to be EFFECTIVELLY FINAL
        String aLocalVar = "a";
        Runnable runnbale = ()-> { System.out.println(aLocalVar); }; // no changes to aLocalVar after this usage will compile - COMPILATION FAILURE HERE
        // CAN access an instance var even if that one is not final
        //aLocalVar = "b"; // this can cause compilation failure in the lambda above LINE
        //

    }

    /*
    * CAN ONLY BE CONSUMED ONCE
    * stream can only have one termianl operation - after that - exception: java.lang.IllegalStateException
    *
    * */

    public static class Apple{
        public Apple(){}
        public Apple(int weight){}
    }

    // method references
    @Test
    public void methodReferences(){

        //comparing(Function<? super T, ? extends U> keyExtractor)
        dishes.sort(Comparator.comparing(Dish::getName)); // so this is a shorthand for a lamba wih a single method call
        // so the compiler does a transformation to this
        dishes.sort(Comparator.comparing((dish)->dish.getName()));


        // reference to an instance - will translate to a function that receive the instance and executes on it
        //(instanceRef, params)->intanceRef.instanceMethod(params);
        // notice that the function receives as param the instance object upon wich to execute and the
        BiFunction<String, Integer, String> b1 = String::substring;
        BiFunction<String, Integer, String> b2 = (String str, Integer index)-> str.substring(index);

        // reference to an instance method of and existing object - only the parameter of the function is included in the lambda declaration,
        //(params)->existingObject.instanceMethod(params);
        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = (String str) -> System.out.println(str);

        Runnable r1 = Thread.currentThread()::getName; // Error:(324, 43) java: invalid method reference static bound method reference
        Runnable r2 = ()->{Thread.currentThread().getName();};


        // reference to a static
        // (params)->Class.staticMethod(params)
        IntFunction<Integer> f1 = Integer::valueOf;
        IntFunction<Integer> f2 = (i)-> Integer.valueOf(i);

        // constructor reference
        Supplier<String> s1 = String::new;

        Runnable r3 = this::t; //
                 r3 = ()->{ Lambdas.this.t();};
                 r3 = ()->{ this.t(); assertTrue(Lambdas.this == this); };
        Runnable r4 = super::notify;
                 r4 = ()-> {Lambdas.super.notify();};
                 r4 = ()-> {super.notify(); assertTrue(Lambdas.super.hashCode() == super.hashCode()); };



        // simple constructor invocation
        Supplier<Apple> sup = Apple::new;
        Apple a1 = sup.get();

        // reference to a constructor with parameters
        Function<Integer, Apple> af = Apple::new;
        Apple a2 = af.apply(10);

        Comparator<Dish> co1 = Comparator.<Dish,String>comparing(Dish::getName);
        Comparator<Dish> co2 = Comparator.comparing(Dish::getName);

        Comparator<Dish> co3 = co1.reversed();
        Comparator<Dish> compareByNameAndThenByDish = co1.thenComparing(Dish::getType);

        co1 = Comparator.comparingInt(Dish::getCalories);
        co1 = Comparator.comparingLong(Dish::getCalories);
        co1 = Comparator.comparingDouble(Dish::getCalories);

        Comparator<String> co5 = Comparator.<String>naturalOrder();

        Comparator<Dish> co6 = Comparator.nullsFirst(co1);
        Comparator<Dish> co7 = Comparator.nullsLast(co1);

    }

    /*
    * a FUNCTIONAL INTERFACE has ONLY ONE ABSTRACT METHOD-  more than that and is no longer a functional interface
    * */

    /*
        3.2. Describe the Stream interface and pipelines
    */



    /**
     * 3.1. Develop the code that iterates a collection by using forEach; including method chaining
     */

    @Test
    public void t1() {
        List<String> list = dishes.stream()
                .filter((d) -> d.calories > 100)
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());

        out.println(list);
    }

    @Test
    public void t2() {
        List<Dish> list = dishes.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());
        out.println(list);
    }

    @Test
    public void t3() {
        dishes.stream()
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void t4() {
        dishes.stream()
                .limit(3)
                .forEach(System.out::println);
    }

    @Test
    public void t5() {
        dishes.stream()
                .skip(3)
                .forEach(System.out::println);
    }

    @Test
    public void t6() {
        dishes.stream()
                .map(Dish::getName)
                .forEach(System.out::println);
    }

    @Test
    public void ArrayStreamAndGrouping() {
        Map<String, List<String>> map = Arrays.stream("".split("\\W*"))
                .collect(Collectors.groupingBy(String::toString));
    }

    @Test
    public void flatMap() {
        Arrays.asList("abc", "efg").stream()
                .map((s) -> {
                    return s.split("\\W*");
                })
                .flatMap(Arrays::stream) // converts array to stream of array elements
                .collect(Collectors.groupingBy(String::toString));
    }






    /*
    3.3. Filter a collection using lambda expressions
    * */
    @Test
    public void filter() {
        List<Transaction> list = transactions.stream()
                .filter((t) -> t.year == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .collect(Collectors.toList());

        List<String> cities = transactions.stream()
                .map(t -> t.trader.city)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(cities);

        List<Trader> traders = transactions.stream().map(t -> t.trader)
                .filter(t -> "Cambridge".equalsIgnoreCase(t.city))
                .sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());
        System.out.println(traders);

        List<String> traderNames = transactions.stream().map(t -> t.trader.getName()).sorted().collect(Collectors.toList());


        List<Integer> transactionValue = transactions.stream()
                .filter(t -> "Cambridge".equalsIgnoreCase(t.trader.city))
                .map(Transaction::getValue)
                .collect(Collectors.toList());
    }




    /*
    3.4. Identify lambda operations that are lazy
    * */





    /*
     4.1. Develop the code to extract data from an object using map
    * */
    @Test
    public void map() {
        List<String> cities = transactions.stream()
                .map(t -> t.trader.city)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(cities);

        List<String> traderNames = transactions.stream().map(t -> t.trader.getName()).sorted().collect(Collectors.toList());

        List<Integer> transactionValue = transactions.stream()
                .filter(t -> "Cambridge".equalsIgnoreCase(t.trader.city))
                .map(Transaction::getValue)
                .collect(Collectors.toList());
    }
    @Test
    public void combineTwoStreamAllCombinations() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);

        List<int[]> combinations = list1.stream()
                .flatMap(i -> list2.stream()
                        .map(j -> new int[]{i, j})).collect(Collectors.toList());
        combinations.stream().map(Arrays::toString).forEach(System.out::println);
    }




    /*
   4.2. Search for data using search methods including: findFirst, findAny, anyMatch, allMatch, noneMatch.
   */
    @Test
    public void findAny() {

        Optional<Dish> optionalDishFirst = dishes.stream().filter(Dish::isVegetarian).findFirst();
        optionalDishFirst.ifPresent(System.out::println);

        Optional<Dish> optionalDishAny = dishes.stream().filter(Dish::isVegetarian).findAny();
        optionalDishAny.ifPresent(System.out::println);

        transactions.stream().filter(t -> "Milan".equalsIgnoreCase(t.trader.city)).findAny().ifPresent(System.out::println);

        assertTrue(dishes.stream().anyMatch(Dish::isVegetarian));

        assertFalse(dishes.stream().allMatch(Dish::isVegetarian));

        assertFalse(dishes.stream().noneMatch(Dish::isVegetarian));

    }

    /*
        4.4. Perform calculations using methods: count, max, min, average, sum
    */
    @Test
    public void reduceSumProdMinMaxCount() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);

        // SUM
        Integer count = dishes.stream().map(d -> 1).reduce(0, Integer::sum);
        Integer result = list1.stream().reduce(0, (a, b) -> a + b);

        // PROD
        list1.stream().reduce(0, (a, b) -> a * b);

        // MIN
        list1.stream().reduce(Integer::min);
        Integer minTransactionValue = transactions.stream()
                .map(Transaction::getValue).min(Integer::compare).get();

        // MAX
        list1.stream().reduce(Integer::max);
        Integer maxTransactionValue = transactions.stream()
                .map(Transaction::getValue).max(Integer::compare).get();

        maxTransactionValue = transactions.stream()
                .map(Transaction::getValue).reduce(0, Integer::max);

        maxTransactionValue = transactions.stream()
                .map(Transaction::getValue).reduce(0, (a, b) -> a > b ? a : b);

    }

    /*
    4.5. Sort a collection using lambda expressions
    */
    @Test
    public void sort() {

        // now you can write
        List<Integer> list = Arrays.asList(1, 2, 3);

        list.sort(Integer::compare);

        IntFunction<Integer> f1 = (i) -> new Integer(1);

        Function<Integer, Integer> f = Integer::new;

        list.sort(Comparator.comparing(f));

        list.sort(Comparator.comparing(Integer::intValue));

    }

    @Test
    public void t() {
        String[] array = {"b", "c"};

        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });

        Arrays.sort(array, (String first, String second) -> first.compareTo(second));

        Arrays.sort(array, (first, second) -> first.compareTo(second));

        Arrays.sort(array, String::compareTo);

        String str = new String();

    }






    /*
    4.6. Save results to a collection by using the collect method and Collector class; including methods such as averagingDouble, groupingBy, joining, partitioningBy
    5.2. Implement decomposition, reduction, in streams
    */

    /**
     * counting
     * summingInt
     * averagingInt
     * IntSummaryStatistics summarizingInt(mapping function)
     * maxBy(comparingInt)
     * minBy(comparingInt)
     * Collectors.joining
     */
    @Test
    public void collectors() {
        dishes.stream().collect(Collectors.counting());

        dishes.stream().collect(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)));

        Integer totalCalories = dishes.stream().collect(Collectors.summingInt(Dish::getCalories));
        totalCalories = dishes.stream().map(d -> d.getCalories()).collect(Collectors.reducing(0, (i, j) -> i + j));
        totalCalories = dishes.stream().collect(Collectors.reducing(0, Dish::getCalories, (i, j) -> i + j));

        Double averageCalories = dishes.stream().collect(Collectors.averagingInt(Dish::getCalories));

        IntSummaryStatistics stats = dishes.stream().collect(Collectors.summarizingInt(Dish::getCalories));

        Optional<Dish> opt = dishes.stream().collect(Collectors.minBy(Comparator.comparingInt(Dish::getCalories)));
        opt.ifPresent(System.out::println);

        String s = dishes.stream().map(d -> d.getName()).collect(Collectors.joining(","));

    }

    @Test
    public void grouping() {
        // nested grouping
        Map<Dish.Type, Map<String, List<Dish>>> r = dishes.stream()
                .collect(Collectors.groupingBy(Dish::getType,
                        Collectors.groupingBy((Dish dish) -> {
                            return dish.getCalories() > 400 ? "fat" : "low-fat";
                        })));

        ;

        Map<Dish.Type, Long> a = dishes.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));


        Map<Dish.Type, Optional<Dish>> max = dishes.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))));
        // OR removing the optional returned by MAX collector
        Map<Dish.Type, Dish> max2 = dishes.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));

        Function<Dish, String> f = (Dish dish) -> {
            return dish.getCalories() > 400 ? "fat" : "low-fat";
        };

        // result is a mapping
        Map<Dish.Type, Set<String>> dishMapping = dishes.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(f, Collectors.toSet())));

    }

    @Test
    public void partitioning() {
        Map<Boolean, List<Dish>> list = dishes.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));

        Map<Boolean, Map<Dish.Type, List<Dish>>> l = dishes.stream().collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.groupingBy(Dish::getType)));

        Map<Boolean, Map<Boolean, List<Dish>>> partition = dishes.stream().collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.partitioningBy((Dish d) -> d.getCalories() > 500)));

        Map<Boolean, Long> map2 = dishes.stream().collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.counting()));

        System.out.println("");
    }

    @Test
    public void streamsTest() {
        List<Integer> list = Arrays.asList(1, 2, 2, 3);
        Map<Integer, List<Integer>> filteredAndGrouped = list.stream().filter((e) -> {
            return e > 1;
        }).map((e) -> {
            return e;
        }).collect(Collectors.groupingBy(Integer::intValue));

    }

    static class MyCollector<T> implements Collector<T, List<T>, List<T>> {

        @Override
        public Supplier<List<T>> supplier() {
            return ArrayList::new;
        }

        @Override
        public BiConsumer<List<T>, T> accumulator() {
            return List::add;
        }

        @Override
        public BinaryOperator<List<T>> combiner() {
            return (list1, list2) -> {
                list1.addAll(list2);
                return list1;
            };
        }

        @Override
        public Function<List<T>, List<T>> finisher() {
            return Function.identity();
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH, Characteristics.CONCURRENT));
        }
    }

    @Test
    public void ownCollector() {
        dishes.stream().collect(new MyCollector<Dish>());
        // or collector is equivlent to:
      //  dishes.stream().collect(ArrayList::new, List::add, List::addAll); // Function.identity(), Characteristics: IDENTITY_FINISH, CONCURRENT

    }



    /*
    5.1. Develop the code that use parallel streams
    */





    /*
        6.4. Describe other stream sources: Arrays.stream(), IntStream.range()
    */

    /**
     * mapToInt
     * IntStream: average, min, max, sum, count
     * <p>
     * findAny, findFirst - return Optional
     * min, max return Optional
     * <p>
     * intStream conversions: asDoubleStream, asLongStream
     * <p>
     * boxed()
     */
    @Test
    public void streamsOfNumbers() {

        dishes.stream().mapToInt(Dish::getCalories).sum();

        OptionalInt optionalInt = dishes.stream().mapToInt(Dish::getCalories).max();
        optionalInt.ifPresent(i -> {
        });
        int value = optionalInt.orElse(1);

        IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).average();
        IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).min();
        IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).max();
        IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).sum();
        IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).count();

        IntSummaryStatistics statistics = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).summaryStatistics();
        statistics.getCount();
        statistics.getAverage();
        statistics.getMin();
        statistics.getMax();
        statistics.getSum();

        IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).asDoubleStream();
        IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).boxed();
        IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).sorted(); // NO COMPARATOR NEEDED FOR PRIMITIVES!
        IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).peek(i -> {
        });

        // generic methods also found in IntStream:
        IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).findAny();
        IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).findFirst();

        IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).distinct();

        // mark stream for sequential or paralel processing - ONLY LAST FLAG WINS
        IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).sequential();
        IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).parallel();

    }

    @Test
    public void ranges() {
        IntStream evenNumbers = IntStream.rangeClosed(1, 100).filter(i -> i % 2 == 0);
        System.out.println(evenNumbers.count()); // 50
    }

    @Test
    public void pythagoreanNumbers() {
        IntStream.rangeClosed(5, 1000).filter(i -> i * i == (i - 1) * (i - 1) + (i - 2) * (i - 2)).boxed().map(i -> {
            return new int[]{i, i - 1, i - 2};
        }).forEach((ar) -> {
            System.out.println(Arrays.toString(ar));
        }); // valid only for consecutive pythgorean numbers - some are not at all

        Stream<int[]> pythagoreanNumbersStream = IntStream.rangeClosed(1, 100).boxed().flatMap(
                a -> IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));

        // or more optimal - remove a second sqrt computation
        IntStream.rangeClosed(1, 100).boxed().flatMap(
                a -> IntStream.rangeClosed(a, 100)
                        .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})).filter(i -> i[2] % 1 == 0);

        pythagoreanNumbersStream.limit(50).forEach(t -> System.out.println(Arrays.toString(t)));
    }

    @Test
    public void infiniteStreams() {
        Stream.iterate(0, n -> n + 2).limit(5).forEach(System.out::println);
    }


}

class A {
    void m() {
        out.println("A");
    }

    ;
}

class B extends A {
    void m() {
        out.println("B");
    }

    ;

    void m2() {
        super.m();

        new Thread(super::m);
        new Thread(this::m);

        new Thread(new Runnable() {
            @Override
            public void run() {
                B.super.m();
                B.this.m();
            }
        });
    }
}
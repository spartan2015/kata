package java8.second;

import algos.Utils;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.junit.Test;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * Created by Battlestar on 2/17/2015.
 */
public class ExerciseTest {
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

    @Data
    static class Transaction {
        private final Trader trader;
        private final int year;
        private final int value;
        private String currencty = "USD";

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


    @ToString
    @EqualsAndHashCode
    public static class Dish {
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


    @Test
    public void test1() {

        dishes.sort(Comparator.comparing(Dish::getName));

    }

    @Test
    public void filter() {
        dishes.stream().filter(Dish::isVegetarian).count();
        dishes.stream().distinct().count();
        dishes.stream().skip(10).count();
        dishes.stream().limit(10).count();
    }

    @Test
    public void mapping() {
        List<String> names = dishes.stream()
                .map((d) -> d.getName())
                .collect(Collectors.toList());
    }

    @Test
    public void stream() {
        Arrays.asList(1, 2, 3).stream()
                .map((i) -> Arrays.asList(4, 5, 6).stream().
                        map((j) -> new int[]{i, j}))
                .flatMap((intStream) -> intStream).forEach((intsArray) -> System.out.println(Arrays.toString(intsArray)));

        System.out.println("hello");
    }

    @Test
    public void find() {
        Optional<Dish> op1 = dishes.stream().findAny();
        Optional<Dish> op2 = dishes.stream().findFirst(); // findFirst imposes additional constraints on PARALELISM - use findAny if you don't care for order - can be optimized better

        op1.ifPresent((dish) -> {
        });
        op1.isPresent();
        op1.filter((dish) -> true);

        Dish dish1 = op1.get(); // DON'tUSE - throws runtime exception if value is null
        Dish dish2 = op1.orElse(dishes.get(0)); // DEFAULT VALUE


        Function<Dish, String> f = Dish::getName;
    }

    @Test
    public void match() {
        boolean m1 = dishes.stream().allMatch((dish) -> true);
        boolean m2 = dishes.stream().anyMatch((dish) -> true);
        boolean m3 = dishes.stream().noneMatch((dish) -> true);

    }

    @Test
    public void reducing() {
        //Optional<Dish>  = dishes.stream().reduce(BinaryOperator<Dish>)
        //Dish = dishes.stream().reduce(Dish identity, BinaryOperator<Dish>)

        long aCount1 = IntStream.rangeClosed(0, 10).count();
        long aCount2 = IntStream.rangeClosed(0, 10).reduce(0, (prev, current) -> prev + 1);

        int aSum = IntStream.rangeClosed(0, 10).reduce(0, (prev, current) -> prev + current);
        Optional<Integer> optInt = IntStream.rangeClosed(0, 10).boxed().reduce((prev, current) -> prev + current);

        int aSum1 = IntStream.rangeClosed(0, 10).reduce(0, Integer::sum);

        int aProd = IntStream.rangeClosed(0, 10).reduce(1, (prev, current) -> prev * current); // START FROM 1 when makind the PRODUCT OF NUMBER - ELSE GET 0

        int aMin1 = IntStream.rangeClosed(0, 10).reduce(0, (prev, current) -> Math.min(prev, current));
        int aMin2 = IntStream.rangeClosed(0, 10).reduce(0, Math::min);
        int aMin3 = IntStream.rangeClosed(0, 10).reduce(0, Integer::min);

        //Dish d = dishes.stream().reduce(U identity, BiFunction<U identity, Dish dish, U final> acumulator, combiner)
        Long value = dishes.stream().
                reduce(/**/0L,
                        /*accumulator*/(current, dish) -> current + dish.getCalories(),
                        /*combiner*/(i, j) -> i + j);
        System.out.println(value);

        dishes.stream().map(Dish::getCalories).count();

        Integer intVal = dishes.stream().map(Dish::getCalories).collect(Collectors.summingInt(Integer::intValue));
        Long longVal = dishes.stream().map(Dish::getCalories).collect(Collectors.summingLong(Integer::intValue));
        Double doubleVal = dishes.stream().map(Dish::getCalories).collect(Collectors.summingDouble(Integer::intValue));

        Double d1 = dishes.stream().map(Dish::getCalories).collect(Collectors.averagingInt(Integer::intValue));
        Double d2 = dishes.stream().map(Dish::getCalories).collect(Collectors.averagingLong(Integer::intValue));
        Double d3 = dishes.stream().map(Dish::getCalories).collect(Collectors.averagingDouble(Integer::intValue));

        Optional<Integer> op1 = dishes.stream().map(Dish::getCalories).collect(Collectors.maxBy(Integer::compare));
        Optional<Integer> op2 = dishes.stream().map(Dish::getCalories).collect(Collectors.minBy(Integer::compare));

        int s1 = IntStream.rangeClosed(0, 10).sum();
        OptionalInt s2 = IntStream.rangeClosed(0, 10).min();
        OptionalInt s3 = IntStream.rangeClosed(0, 10).max();
        OptionalDouble optinalDouble = IntStream.rangeClosed(0, 10).average();

    }

    @Test
    public void exercises() {
        List<Transaction> s = transactions.stream()
                .filter((t) -> t.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .collect(Collectors.toList());

        List<String> cities = transactions.stream().map((t) -> t.getTrader().getCity()).distinct().collect(Collectors.toList());

        List<Trader> traders = transactions.stream().map((t) -> t.getTrader()).filter((t) -> "Cambridge".equals(t.getCity())).sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());

        List<String> traderNames = transactions.stream().map((t) -> t.getTrader().getName()).sorted(String::compareTo).collect(Collectors.toList());

        boolean b = transactions.stream().anyMatch((t) -> "Milan".equals(t.getTrader().getCity()));

        transactions.stream().filter((t) -> "Cambridge".equals(t.getTrader().getCity())).map((t) -> t.getValue()).forEach(System.out::println);

        // max
        Optional<Integer> o = transactions.stream().map(t -> t.getValue()).reduce(Math::max);
        transactions.stream().map(t -> t.getValue()).reduce(0, Math::max);
        transactions.stream().map(t -> t.getValue()).reduce(0L, Math::max, Math::max);
        Optional<Integer> o1 = transactions.stream().map(t -> t.getValue()).max(Integer::compare);

    }

    @Test
    public void mappingToPrimitveStreamToAvoidBoxingCosts() {
        dishes.stream().mapToInt(Dish::getCalories).sum();
        dishes.stream().mapToLong(Dish::getCalories).sum();
        dishes.stream().mapToDouble(Dish::getCalories).sum();

        OptionalInt oInt1 = dishes.stream().mapToInt(Dish::getCalories).max();
        OptionalInt oInt2 = dishes.stream().mapToInt(Dish::getCalories).min();
        // OptionalLong
        // OptionalDouble

    }

    @Test
    public void streamFromValues() {
        Stream<String> ss = Stream.of("a", "b", "c");
        int count = 0;

        Stream<Integer> s = Stream.generate(() -> {
            return 1;
        });

        Stream.iterate(0, n -> n + 2);

        Stream<String> stream = Stream.empty();

        Arrays.stream(new int[]{1, 2, 3, 4, 5}).sum();


    }

    Collector<Transaction, List, List> listCollector = /*or specify your own collector*/new Collector<Transaction, List, List>() {
        @Override
        public Supplier<List> supplier() {
            return ArrayList::new;
        }

        @Override
        public BiConsumer<List, Transaction> accumulator() {
            return (list, t) -> list.add(t);
        }

        @Override
        public BinaryOperator<List> combiner() {
            return (List list1, List list2) -> {
                list1.addAll(list2);
                return list1;
            };
        }

        @Override
        public Function<List, List> finisher() {
            return Function.identity();
        }

        @Override
        public Set<Characteristics> characteristics() {
            return EnumSet.of(Characteristics.IDENTITY_FINISH, Characteristics.CONCURRENT);
        }
    };


    @Test
    public void collectors() {
        Map<Trader, List<Transaction>> map1 = transactions.stream().collect(Collectors.groupingBy(Transaction::getTrader));
        Map<Trader, Integer> map2 = transactions.stream().collect(Collectors.groupingBy(Transaction::getTrader, Collectors.summingInt(Transaction::getValue)));
        Map<Boolean, List<Transaction>> part1 = transactions.stream().collect(Collectors.partitioningBy((t) -> t.getValue() > 100));

        Collectors.toList();

        Collectors.counting();

        Collectors.summingInt(Transaction::getValue);
        Collectors.summingLong(Transaction::getValue);
        Collectors.summingDouble(Transaction::getValue);

        Collectors.averagingInt(Transaction::getValue);
        Collectors.averagingLong(Transaction::getValue);
        Collectors.averagingDouble(Transaction::getValue);

        Collectors.minBy(Integer::compare);
        Collectors.maxBy(Comparator.comparingInt(Transaction::getValue));

        //Collector<Transaction, IntSummaryStatistics, IntSummaryStatistics> i1 = Collectors.summarizingInt(Transaction::getValue);
        //Collector<Transaction, LongSummaryStatistics,LongSummaryStatistics> i2 =Collectors.summarizingLong(Transaction::getValue);
        //Collector<Transaction,  DoubleSummaryStatistics,DoubleSummaryStatistics> i3 = Collectors.summarizingDouble(Transaction::getValue);

        Collector<Transaction, ?, Map<String, List<Transaction>>> c0 = Collectors.groupingBy(Transaction::toString); // default collectors is a toList();
        transactions.stream().collect(Collectors.groupingBy(/*mapper*/Transaction::getCurrencty));
        Collector<Transaction, ?, Map<String, List>> c1 = Collectors.groupingBy(/*mapper*/Transaction::toString, /*your collector*/listCollector);
        transactions.stream().collect(Collectors.groupingBy(/*mapper*/Transaction::toString, /*your collector*/listCollector));
        Collector<Transaction, ?, Map<String, List>> c2 = Collectors.groupingBy(/*mapper*/Transaction::toString, /*map supplier*/HashMap::new, /*your collector*/listCollector);
        transactions.stream().collect(Collectors.groupingBy(/*mapper*/Transaction::toString, /*map supplier*/HashMap::new, /*your collector*/listCollector));


        Collectors.joining();
        Collectors.joining(",");

        Collectors.collectingAndThen(listCollector, (list) -> Collections.unmodifiableList(list));
        Map<Dish.Type, Optional<Dish>> cat1 = dishes.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))));
        Map<Dish.Type, Dish> cat2 = dishes.stream()
                .collect(Collectors
                        .groupingBy(Dish::getType,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)),
                                        (Optional<Dish> op) -> op.orElse(new Dish("salmon", false, 450, Dish.Type.FISH))
                                )
                        ));

        Collectors.reducing( /*binary operator - acumulator*/(Integer in1, Integer in2) -> in1 + in2);
        Collectors.reducing(/*baseline*/0, /*binary operator - acumulator*/(Integer in1, Integer in2) -> in1 + in2);
        Collectors.reducing(0, /*mapper */(Transaction transaction) -> transaction.getValue(), /*binary operator - acumulator*/(Integer in1, Integer in2) -> in1 + in2);

        Collectors.partitioningBy((Transaction t) -> t.getValue() > 100);
        Collectors.partitioningBy((Transaction t) -> t.getValue() > 100, Collectors.partitioningBy((Transaction t) -> t.getTrader() != null));

        List<String> mapp1 = dishes.stream().collect(Collectors.mapping(Dish::getName, Collectors.toList()));

        // toList, toSet, toCollection


        // generic collect form
        List<Dish> list = dishes.stream().collect(
                /*supplier*/ArrayList::new,
                /*accumulator*/List::add,
                /*combiner*/List::addAll);
    }

    @Test
    public void paralelStream() {
        long noOfTimes = 10_000_000;
        // simple sequential sum
        Utils.cron("boxed seq iterate",() -> {
            Stream.iterate(0L, (l) -> l + 1)
                    .limit(noOfTimes)
                    .sequential() // this is default - ONE THREAD
                    .reduce(0L, (l1, l2) -> l1 + l2);
        });

        // turn to paralel
        Utils.cron("boxed parallel iterate",() -> {
            Stream.iterate(0L, (l) -> l + 1)
                    .limit(noOfTimes)
                    .sequential() // this is default - ONE THREAD
                    .parallel() // this only sets a flag - LAST CALL WINS
                    .parallel() // this only sets a flag - LAST CALL WINS
                    .parallel() // this only sets a flag - LAST CALL WINS
                    .parallel() // this only sets a flag - LAST CALL WINS
                    .reduce(0L, (l1, l2) -> l1 + l2);
        });

        // internally use ForkJoinPool - and Spliterator - this one decides when to split - trySplit - the new spliterator goes to another task in the pool - guess will split max numb of processors
        // it does have as many threads as processors (on this machine 8 - uses Runtime.getRuntime().availableProcessors();
        // you can change this default by setting a system property: System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","12"); // GENERAL CHANGE AFFECTING ENTIRE JVM

        Utils.cron("prim seq iterate",() -> {
            LongStream.iterate(0L, (l) -> l + 1)
                    .limit(noOfTimes)
                    .reduce(0L, (l1, l2) -> l1 + l2);
        });

        Utils.cron("prim rangeClosed seq iterate",() -> {
            LongStream.rangeClosed(0L, noOfTimes)
                    .reduce(0L, (l1, l2) -> l1 + l2);
        });

        Utils.cron("boxed rangeClosed parallel iterate",() -> {
            LongStream.rangeClosed(0L, noOfTimes)
                    .parallel()
                    .reduce(0L, (l1, l2) -> l1 + l2);
        });

        Utils.cron("boxed rangeClosed UNORDERED parallel iterate",() -> {
            LongStream.rangeClosed(0L, noOfTimes)
                    .unordered() // LOOKITTHAT - WORKS BETTER FOR PARALLEL
                    .parallel()
                    .reduce(0L, (l1, l2) -> l1 + l2);
        });

    }

    @Test
    public void spliterator(){
        // splitable iterator
        class SpliteratorIntArray implements Spliterator<Integer> {

            public int threshold = 100;
            public Integer[] array;
            int start;
            int end;

            public SpliteratorIntArray(Integer[] array, int start, int end){
                System.out.println(" SpliteratorIntArray " + start + "-" + end + " size: " + (end-start));
                this.array = array;
                this.start = start;
                this.end = end;
            }

            @Override
            public boolean tryAdvance(Consumer<? super Integer> action) {
                if (start < end) {
                    action.accept(array[start++]);
                    return true;
                }
                return false;
            }

            @Override
            public Spliterator<Integer> trySplit() {
                if ((end-start) > threshold) {
                    int mid = (start + end) / 2;
                    int tempEnd = this.end;
                    this.end = mid;
                    return new SpliteratorIntArray(array, mid+1, tempEnd);
                }
                return null;
            }

            @Override
            public long estimateSize() {
                return end-start;
            }

            @Override
            public int characteristics() {
                return Spliterator.CONCURRENT
                        //+ Spliterator.ORDERED
                        //+ Spliterator.DISTINCT
                        //+ Spliterator.SORTED
                        //+ Spliterator.SIZED
                        //+ Spliterator.SUBSIZED
                        //+ Spliterator.NONNULL
                        + Spliterator.IMMUTABLE ;
            }
        };
        // the split happens at first - and continoues as long as there is a spliterator that on trySplit return NOT null
        // then it procedes
        Integer[] someArr = new Integer[1000];
        StreamSupport.stream(new SpliteratorIntArray(someArr,0,999),true).parallel().count();

    }

    @Test
    public void iterateOverAString(){
        String str = "some string";

        Stream<Character> chars = IntStream.rangeClosed(0, str.length() - 1).mapToObj((i) -> str.charAt(i));
        Stream<Character> chars2 = IntStream.rangeClosed(0, str.length() - 1).mapToObj(str::charAt); // WOW

        Map<Character, Long> counting = chars.collect(Collectors.groupingBy((c)->c, Collectors.counting()));
        System.out.println(counting);

        //chars.forEach((c)-> System.out.println(c+""));
    }

    // don't forget that lambda can't shadow existing variables - COMPILE ERROR
    // lambda can refer to effectively final references


    static interface SomeTask{
        public void run();
    }

    static class Some{
        void doer(SomeTask task){
            System.out.println("st");
        }
        void doer(Runnable r){
            System.out.println("r");
        }

    }
    // when lambda is ambigous about which method to choose (cause of overload) then CAST EXPLICITLY
    @Test
    public void cast(){
        new Some().doer((SomeTask)()->{}); // EXPLICIT CAST OR COMPILE ERROR

    }

    // java 8 allows static methods in INTERFACES - also defaults
    // inheritance:
    /**
     * 1. classes always win - any concrete implementation wins
     * 2. the most specific wins A () B extends A {} C uses B - then b method will be used
     * 3. if choice is ambiguous - THEN YOU MUST PROVIDE IMPLEMENTATION AND CALL EXPLICITLY THE ONE YOU NEED _ LIKE ANY STATIC CALL
     * A{} B{} C extends A,B { default void m{ B.super.hello(); }}
     */

    @Test
    public void optional() throws Throwable{
        @Data
        class Insurance{
            String name;
        }
        @Data
        class Car{ Insurance insurance;}
        @Data
        class Person{ Car car;}


        Optional<String> opString = Optional.of(""); // if null would throw RUntimeException - NullPointerException
        Optional<String> ofNullbable = Optional.ofNullable(null);

        String value = opString.orElse("default");

        opString.ifPresent((s)->{
                System.out.println(s);
        });

        opString.get(); // throrws NoSuchElementException - avoid it

        Optional<Integer> opInteger = Optional.<Integer>empty();

        // extracting optional variables:
        Optional<Person> opPerson = Optional.of(new Person());

        Optional<Car> opCar = opPerson.map(Person::getCar);

        // make sure that the returned value of say getCar does not return itself an Optional otherwise you'll have Optional<Optional<Car>>
        // the solution is flatMap for Optional - if some method return an Optional
        String opName = opPerson
                .map(Person::getCar)
                .map(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("default");

        opCar.orElseGet(/*Supplier*/()->{ return new Car();});

        opCar.orElseThrow(()->{ throw new NullPointerException();});

        // filtering
        opCar.filter((car)->"someName".equals(car.getInsurance().getName())).orElse(new Car());

        // OptionalInt, OptionalLong, OptionalDouble do not have map, flatMap, filter methods... and can't be chained with Optional
        // not recommended
    }

}

package java8.second;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.StampedLock;

/**
 * Created by Battlestar on 2/25/2015.
 */
public class ConcurrencyEnhancements {

    @Test
    public void atomicLong(){

        AtomicLong atomicLong = new AtomicLong();

        atomicLong.set(1);
        long value = atomicLong.get();

        value = atomicLong.incrementAndGet();
        value = atomicLong.getAndIncrement();

        value = atomicLong.decrementAndGet();
        value = atomicLong.getAndDecrement();

        // pattern for safe thread update with compare and set
        long current = 0;
        long newValue = 0;
        do {
            current = atomicLong.get();
            newValue=current+100;
        }while(!atomicLong.compareAndSet(current, newValue));
        //java 8 provides one simple method to do just that
        value = atomicLong.accumulateAndGet(/*this is new delta to add to prev*/100, (prev,x)->prev+x);
        atomicLong.getAndAccumulate(100, Long::sum);
        // or
        value = atomicLong.updateAndGet((prev)->prev+100);
        atomicLong.getAndUpdate((prev)->prev+100);

        // for high contention scenarios java 8 introduces alternatives to Atomics: LongAdder and LongAccumulator - DoubleAdder, DoubleAccumulator
        LongAdder longAdder = new LongAdder();
        longAdder.increment();
        longAdder.decrement();;
        longAdder.add(10);

        long finalValue = longAdder.sum();
        longAdder.reset();
        finalValue = longAdder.sumThenReset();

        // LongAccumulator
        // valid for operations that are ASSOCIATIVE AND COMUTATIVE
        LongAccumulator longAccumulator = new LongAccumulator(/*accumulator function LongBinaryOperator*/Long::sum, /*start value - identity*/ 0);
        longAccumulator.accumulate(10);
        finalValue = longAccumulator.get();
        longAccumulator.getThenReset();
        longAccumulator.reset();

    }

    int a ;
    int b;
    @Test
    public void stampedLock(){
        StampedLock stampedLock = new StampedLock();
        long stamp = stampedLock.tryOptimisticRead();

        // read
        int aValue = a;
        int bValue = b;

        // check changes were done during reading
        if (!stampedLock.validate(stamp)){
            // pssimistic lock
            stamp  = stampedLock.readLock();

            aValue = a;
            bValue= b;

            stampedLock.unlockRead(stamp);
        }

        // at this point you have a consistent read;
    }

    @Test
    public void concurrentHashMap(){
        ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>(/*initial capacity*/100, /*load factor*/0.75f,/*concurrency level*/ 8);
        //long count: mappingCount
        int count = map.size();
        long counter = map.mappingCount(); // java 8

        // java 8 uses trees for structure - for Comparable - prev used fixed array of buckets

        // better concurrency support for update
        String someKey = "a";
        Long oldValue = map.get(someKey);
        Long newValue = 0l;
        map.put(someKey, oldValue+1); // not very thread safe - LOST UPDATES PROBLEM
        // java 8 permits something similar to AtomicInteger update pattern
        do{
            oldValue= map.get(someKey);
            newValue= oldValue + 100;
        }while(map.replace(someKey,oldValue,newValue)); // replaces with newValue only if oldValue is the one that was used to compute the newvalue - so no writes occured in the meantime
        // that was like compareAndSet - but java 8 takes care of this pattern in methods: compute, merge
        map.compute(someKey,(key1,value)->value+100);

        map.computeIfAbsent(someKey, (key1)-> 100l);

        map.computeIfPresent(someKey, (key1,value)->value+100L);

        // you cannot have null values in the concurrent hashmap

        // merge - unlike compute - it does not uses the someKey in the function
        map.merge(someKey, /*valueToMerge*/100L, (existing, valueToMerge ) -> existing + valueToMerge);


        // BULK OPERATIONS: search, searchKey, searchValues, searchEntries, reduce, reduceKeys, reduceValues, reduceEntries, forEach, forEachKey, forEachValue, forEachEntries
        int parallelismThreshold = 100; //the (estimated) number of elements  needed for this operation to be executed in parallel

        // search for value
        Long searchResult = map.search(parallelismThreshold, (key,value)-> "a".equals(key) ? value: null);
        searchResult = map.searchValues(parallelismThreshold, (value)->value);
        searchResult = map.searchEntries(parallelismThreshold, (entry)->entry.getValue() != null ? entry.getValue() : 0L);

        //search for key
        String searchKeyResult = map.searchKeys(parallelismThreshold,(key)-> key);


        // reduce, reduceKeys, reduceValues, reduceEntries
        Long reduceResult = map.reduce(parallelismThreshold, /*map*/(key,value)->value, /*reduce*/(value1,value2)->value1+value2);
        reduceResult = map.reduceEntries(parallelismThreshold, /*map*/(entry1) -> entry1.getValue(),/*reduce*/ (value1, value2) -> value1 + value2);

        reduceResult = map.reduceValues(parallelismThreshold, (value1,value2)->value1+value2);
        String keysResult = map.reduceKeys(parallelismThreshold, (key1,key2)->key1+key2);

        // for each
        map.forEach(parallelismThreshold, (key,value)->{});
        map.forEach(parallelismThreshold,/*transformer*/ (key, value) -> value, (value) -> {
        });

        map.forEachEntry(parallelismThreshold, (entry)->{});
        map.forEachEntry(parallelismThreshold, /*transformer*/(entry)->entry.getValue(),(value)->{});

        map.forEachKey(parallelismThreshold, (key)->{});
        map.forEachKey(parallelismThreshold, /*transformer*/(key)->key, (key)->{});

        map.forEachValue(parallelismThreshold,(value)->{});
        map.forEachValue(parallelismThreshold,(value)->value, (value)->{});

        // or a simple approach:
        // better with putIfAbsent - no longer overriding
        {
            ConcurrentHashMap<String, AtomicLong> newMap = new ConcurrentHashMap<>();
            newMap.putIfAbsent(someKey, new AtomicLong());
            newMap.get(someKey).incrementAndGet(); // atomicLong does the rest of the guarantees
            // or even in one line
            newMap.putIfAbsent(someKey, new AtomicLong()).incrementAndGet();
        }


        // SET VIEWS using concurrentHashMap
        Set<String> concurrentSet = map.keySet(/*default value*/0L);

        Set<String> concurrentSet2 = ConcurrentHashMap.<String>newKeySet();

    }

    @Test
    public void parallelArrayOperations(){

        String[] arr = {"c","b","a"};

        Arrays.parallelSort(arr);
        Arrays.parallelSort(arr, /*from*/0, /*to exclusive*/arr.length /*all in this case since 3 index will not be considered and it does not exist in this case*/);

        int[] ints = new int[10];
        Arrays.parallelSetAll(ints, (index)->index+1);

        // cummulates the values using the given operator
        Arrays.parallelPrefix(new int[]{2,1,0}, (a,b)->a+b); // [2,1,0] -> [2,3,3]
        Arrays.parallelPrefix(new int[]{2,1,0}, (a,b)->a*b); // [2,1,0] -> [2,2,0]

    }
}

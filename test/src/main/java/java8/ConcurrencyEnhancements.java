package java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.StampedLock;

/**
 *
 * Map: computeIfAbsent, computeIfPresent, merge
 * sending keys and values from a map to a stream - map.entrySet().stream();
 *
 *
 */
public class ConcurrencyEnhancements {

    @Test
    public void safeComputationOnCurrentAtomicValueOfAtomic(){
        // granted this was already - but here is the pattern that updates correctly an Atomic
        AtomicInteger ai = new AtomicInteger();
        int oldValue = 0;
        int newValue = 0;
        do{
            oldValue = ai.get();
            newValue = Math.max(oldValue, 100); // or some other computation that can't be performed with current AtomicInteger api, say like: Math.max(a,b);
        }while(ai.compareAndSet(oldValue,newValue)); // this pattern avoids RACE conditions when multiple thread try to update the same value

        // Java 8 style:

        ai.updateAndGet(x->Math.max(x,100)); // the same with one line of code...
        ai.accumulateAndGet(100, Math::max); // or like this - same semantics

        // this optimistic approach can suffer performance when multiple threads are involved so: LongAdder and LongAccumulator are introduced:
        // also DoubleAdder
        LongAdder longAdder = new LongAdder(); // SAME OPTIMISTIC STRATEGY - BUT SPREAD OVER MULTIPLE VARIABLES - SUM is the last function applied
        longAdder.increment();
        longAdder.decrement();
        longAdder.add(100);
        long sum = longAdder.sum(); // final call to get the FINAL value
        longAdder.sumThenReset();
        longAdder.reset();
        // notice it does not have the AtomicIncrement methods for optimisitc update: accumulateAndGet, updateAndGet...

        // LongAccumulator DoubleAccumulator -  is a generalization of LongAdder - you specify starting point and the function used to do the accumulation
        // the operation MUST BE: ASSOCIATIVE AND COMMUTATIVE
        LongAccumulator longAccumulator = new LongAccumulator(Long::sum,0); // will work same as LongAdder
        longAccumulator.accumulate(100);
        long finalValue = longAccumulator.getThenReset();
        longAccumulator.reset();

    }

    int aInstance = 0;
    int bInstance = 0;
    @Test
    public void stampedLockOptimisticFasterThanReadLock(){
        StampedLock stampedLock = new StampedLock();
        long stamp = stampedLock.tryOptimisticRead();

        int localAInstance=  aInstance;
        int localBInstance = bInstance;
        // read - more than one variable - read lock guarantees consistency ON READ ON MULTPLE - SINGLE IS NOT NECESSARY WITH READ LOCK - ONLY WRITE ON SINGLE
        // see if stamp is still valid - otherwise reRead with a readLock
        if (!stampedLock.validate(stamp)){
            stamp = stampedLock.readLock();
            // re read again 2 ore more fields protected by lock

            localAInstance = aInstance;
            localBInstance = bInstance;

            stampedLock.unlockRead(stamp);
        }
        // at this point we have a consistent read
        System.out.println(localAInstance + " , " + localBInstance);
    }

    @Test
    public void concurrentHashMap(){
        // NO NULL KEYS IN CONCURRENT HASH MAP
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
map.entrySet().stream();
        long size = map.mappingCount(); // mapping count for really long maps - more than integer 2 billion entries

        // as of Java 8 the map organizes buckets as Tree - guaranteeing log(n) performance - when Type implements Comparable
        // old way was with an array of buckets of linked lists

        // new optimistic methods added:
        map.putIfAbsent("key","value");
        String oldValue = null;
        String newValue = null;
        do{
            oldValue = map.get("key");
            newValue = oldValue+10;
        }while(!map.replace("key",oldValue, newValue)); // replace - with optimistic check -

        // pre java 8 had put if absent - but not replace function
        // with atomics the update is ok with this code: putIfAbsent + atomic operations
        ConcurrentHashMap<String, LongAdder> longAdderMap = new ConcurrentHashMap<>();
        longAdderMap.putIfAbsent("key", new LongAdder());
        longAdderMap.get("key").increment();

        // java 8 compute - for updating using lambdas;
        map.compute("key",(k,v)-> v == null ? "" : v+"v");
        map.computeIfAbsent("key", (k) -> "newValue");
        map.computeIfPresent("key", (k, v) -> v == null ? "" : v + "v");

        map.merge("key", "defaultValue", (oldv, newv) -> oldv + newv);
        map.merge("key","defaultValue",String::concat);
        // NOTE: computer,merge-  if function returns null then key is removed from map

        // bulk operations: on key, on value, on both or on Entry
        boolean exists = map.searchKeys(1, (k) -> k != null);

        // SEARCH STOP WHEN NOT NULL IS RETURNED FROM = so returning false is WRONG !!!!
        String key = map.searchKeys(1, (k) -> k.length()>0 ? k : null);
        String value = map.searchValues(1, v -> v!= null ? v : null);
        value = map.search(1, (k,v) -> (k!=null &&v!= null) ? v : null);
        value = map.searchEntries(1, (entry)-> entry.getKey()!=null ? entry.getKey(): null);

        map = new ConcurrentHashMap<>();
        map.put("key","value");
        map.put("key1","value1");
        map.reduceKeys(1, (first, second) -> first+second);
        map.reduceValues(1, (first, second) -> first + second);

        /**
         * transformer can be used as FILTER - null returns ARE SKIPPED
         */
        String finalValue = map.reduce(100,/*transformer*/ (s1, s2) -> {
            System.out.println(s1 + " first " + s2);
            return s1 + s2;
        }, /*reducer*/ (s1, s2) -> {
            System.out.println(s1 + " second " + s2);
            return s1 + s2;
        });
        System.out.println(finalValue);

        //Map.Entry<String,String> e = map.reduceEntries(100, (entry1,entry2)-> ""));

        // primitive reducer - need transormer, then reducer
        long valu2e = longAdderMap.reduceValuesToLong(
                /*threshold parallelism - over this many values in the map - use multi threaded approach*/1,
                 /*transformer*/ Number::longValue,
                 /*default value - basis for start*/ 0,
                 /*reducer*/ Long::sum);

        map.forEachKey(100, (k)-> {});
        map.forEachKey(100,/*transformer*/(k) -> k + "2",/*consumer*/ (k) -> {});
        map.forEachValue(100, (v) ->{});
        map.forEach(100, (k,v) ->{});
        map.forEachEntry(100, (entry)->{});

        // THREAD SAFE SET
        Set<String> concurrentSet = ConcurrentHashMap.<String>newKeySet();

        // or
        Set<String> concurrentSetLinkedToTheConcurrentHashMap = map.keySet("defaultValue");
    }

    @Test
    public void arrays(){
        String[] strings = {};
        Arrays.parallelSort(strings);

        int[] ints = {};
        Arrays.parallelSort(ints);

        int[] someINts = new int[1024];
        Arrays.parallelSetAll(someINts, (index)-> index);

        // cumulates values of an array - second = first + second, third +=second, ...
        Arrays.parallelPrefix(someINts, (x,y)->x+y);

    }


}

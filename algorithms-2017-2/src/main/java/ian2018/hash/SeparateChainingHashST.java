package ian2018.hash;

import ian2018.search.ST;

import java.util.*;

/**
 * To improve: resizing to minimize N/M - average keys per bucket
 *
 * Speed up searches by a factor of M - proven mathemticall even if hascode is not perfect (but decent)
 * Performance N / M - you want 1000x improvements - M = 997 is a good choice
   Balance between M and speedup - what is the min(M) that would maximize performance - should be N == M - but tradeof
   are needed cause we don't have N memory all the time - choose as large as you can afford

   computing min max is expensive (not the puspose of hash) - could precompute though - would work nicely

  hashing is good when key order is not important

 */
public class SeparateChainingHashST<Key, Value> implements ST<Key,Value> {
    int N = 0;
    int M;
    Map<Key,Value>[] st; // array of map or something that can hold both the KEY and the VALUE - funny to create a
    // hashmap using a hashmap - lol - but I could have used another ST (yeah a map) but simple linked list st -
    // SequentialSearchST - creating a hashmap based on a simpler map (linked list based)

    SeparateChainingHashST(int size){
        this.M = size;
        st = ( Map<Key,Value>[])new Map[M];
        for(int i=0; i<M;i++) st[i] = new HashMap();
    }

    private int hash(Key key){
        return makeSureIsPositive(key.hashCode()) % M;
    }

    private static int makeSureIsPositive(int o) {
        return o & 0x7fffffff;
    }

    @Override
    public void put(Key key, Value value) {
        if (st[hash(key)].put(key,value) == null) {
            N++;
        }
    }

    @Override
    public Value get(Key key) {
        Map map = st[hash(key)];
        return (Value)map.get(key);
    }

    @Override
    public void delete(Key key) {
        if (st[hash(key)].remove(key) != null){
            N--;
        }
    }

    @Override
    public boolean contains(Key key) {
        return st[hash(key)].containsKey(key);
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterable<Key> keys() {
        return null;
    }

    @Override
    public Iterator<Key> iterator() {
        return null;
    }
}

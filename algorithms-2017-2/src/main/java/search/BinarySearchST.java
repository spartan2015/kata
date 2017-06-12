package search;

import org.junit.Test;

import java.util.Iterator;

/**
 * Created on 6/6/2017.
 *
 * Complexity analysis:
 * inserting N elements: N^2 time - not an efficient implementation (compared to BinarySearchTree or RedBlackTree)
 *
 * lgN - for put, get, rank, floor
 * constant for select, min, max
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> implements OrderedST<Key, Value> {

    Key[] keys;
    Value[] values;
    int size = 0;

    public BinarySearchST() {

    }

    public BinarySearchST(int capacity) {
        this.keys = (Key[]) new Comparable[capacity];
        this.values = (Value[]) new Object[capacity];
    }

    /**
     * return where key should be in the array
     *
     * @param key
     * @return
     */
    @Override
    public int rank(Key key) {
        if (size == 0) {
            return 0;
        }
        int hi = size - 1;
        int lo = 0;
        while (hi >= lo) {
            int mid = (lo + hi) / 2;
            int compare = keys[mid].compareTo(key);
            if (compare == 0) {
                return mid;
            } else if (compare > 0) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    @Override
    public void put(Key key, Value value) {
        int i = rank(key);
        if (i < size) {
            if (keys[i].compareTo(key)==0){
                values[i]=value;
            }else {
                for (int j = size; j > i; j--) {
                    keys[j] = keys[j - 1];
                    values[j] = values[j - 1];
                }
                keys[i] = key;
                values[i] = value;
                size++;
            }
        } else {
            this.keys[size] = key;
            this.values[size] = value;
            size++;
        }
    }

    @Override
    public Value get(Key key) {
        if (size ==0) return null;
        int i = rank(key);
        if (i < size) {
            if (keys[i].compareTo(key) == 0) {
                return values[i];
            }
        }
        return null;

    }

    @Override
    public void delete(Key key) {
        //TODO
    }

    @Override
    public boolean contains(Key key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size!=0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Key min() {
        return keys[0];
    }

    @Override
    public Key max() {
        return keys[size-1];
    }

    @Override
    public Key floor(Key key) {
        return null; // TODO
    }

    @Override
    public Key ceiling(Key key) {
        return keys[rank(key)];
    }

    @Override
    public Key select(int rank) {
        return keys[rank]; // due to an already sorted array
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        return new Iterable<Key>() {
            @Override
            public Iterator<Key> iterator() {
                return new Iterator<Key>() {
                    int i = rank(lo);
                    int j = rank(hi);

                    @Override
                    public boolean hasNext() {
                        return i<j;
                    }

                    @Override
                    public Key next() {
                        return keys[i++];
                    }
                };
            }
        };
    }

    @Override
    public Iterator<Key> iterator() {
        return null;
    }
}

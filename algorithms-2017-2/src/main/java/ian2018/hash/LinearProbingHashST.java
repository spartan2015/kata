package ian2018.hash;

import ian2018.search.ST;

import java.util.Iterator;

/**
 * Created on 1/19/2018.
 */
public class LinearProbingHashST<Key,Value> implements ST<Key,Value> {
    int N;
    int M = 17;
    int lgM = (int)Math.log(M);
    Key[] keys;
    Value[] values;

    int[] primes = {61,127,251,509,1021,2039,4093,8191,16381,32749,65521,131071,262139,524287,1048573,2097143,
            4194301,
            8388593,16777213,33554393,67108859,134217689,268435399,536870909,1073741789,2147483647};

    boolean isResizing = false;
    public LinearProbingHashST() {
        keys = (Key[])new Object[M];
        values = (Value[])new Object[M];
    }

    private int hash(Key key){
        int t = key.hashCode() & 0x7fffffff;
        if (lgM < 26) t= t % primes[lgM+5]; // dealing with power of 2 issues of hashing
        return t % M;
    }

    public void putSedgewick(Key key, Value val)
    {
        if (N >= M/2) resize();
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key)) { values[i] = val; return; }
        keys[i] = key;
        values[i] = val;
        N++;
    }

    @Override
    public void put(Key key, Value value) {
        int h= hash(key);
        int origH = h;
        while(keys[h]!=null && !keys[h].equals(key) && hash(keys[h])==origH && h<keys.length) h=(h+1)%M; // sedgewick
        // also
        // mods
        // this
        if (keys[h]!=null && hash(keys[h])!=origH ){ // contiguous clusters -- but with overhead - not found in
            // sedgewick
            for(int i = M-1; i >=h; i--){
                keys[i]=keys[i-1];
                values[i]=values[i-1];
            }
        }
        if (keys[h]==null)  if (!isResizing) N++;
        keys[h] = key;
        values[h] = value;
        if (!isResizing) {
            resize();
        }
    }

    private void resize(){
        if (N > 0.5*M){
            M = M * 2; // problematic approach
            lgM = (int)Math.log(M);
            moveElements();
        }else if(M > 16 && N < 0.25 * M){
            M = (int)(0.75 * M);
            lgM = (int)Math.log(M);
            moveElements();
        }
    }

    private void moveElements() {
        isResizing = true;
        Key[] oldKeys = keys;
        Value[] oldValues = values;
        keys = (Key[])new Object[M];
        values = (Value[])new Object[M];
        for(int i = 0 ; i < oldKeys.length; i++){
            if (oldKeys[i]!=null){
                put(oldKeys[i], oldValues[i]);
            }
        }
        isResizing = false;
    }

    @Override
    public Value get(Key key) {
        int h= hash(key);
        while(keys[h]!=null && !keys[h].equals(key) ) h=(h+1)%M;
        if (keys[h].equals(key)) {
            return values[h];
        }
        else{
            return null;
        }
    }

    @Override
    public void delete(Key key) { // pay attention not to split cluster with same key value by putting a null in middle
        int h= hash(key);
        while(keys[h]!=null && !keys[h].equals(key) ) h++;
        if (keys[h]!=null && keys[h].equals(key)) N--;
        keys[h]=null;
        values[h]=null;
        // pay attention not to split cluster with same key value by putting a null in middle
        h = (h + 1) % M;
        while(keys[h+1]!=null) {
            Key oldK = keys[h];
            Value oldV = values[h];
            keys[h]=null;
            values[h]=null;
            N--;
            put(oldK,oldV); // why again put ? cause next key might not need to move at all - may be on its hash / or
            // not - it might not need - if we have 0 1 and delete 0 - 1 might does not need to move.
            h = (h + 1) % M;
        }
        keys[h]=null;
        values[h]=null;
        resize();
    }

    @Override
    public boolean contains(Key key) {
        return get(key)!=null;
    }

    @Override
    public boolean isEmpty() {
        return N==0;
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

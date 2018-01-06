package ian2018.search;

/**
 * Created on 1/5/2018.
 */
public class BinarySearchOrderedST<Key extends Comparable<Key>, Value> extends AbstractOrderedST<Key, Value> {

    Key[] keys;
    Value[] values;
    int capacity = 10;
    int size = 0;

    public BinarySearchOrderedST() {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];

    }

    @Override
    public void put(Key key, Value value) {
        int i = rank(key);
        Key currentKey = keys[i];
        if ((keys[i]!=null && theSame(currentKey, key))){
            values[i] = value;
        }else {
            size++;
            checkCapacity();
            moveElements(i);
            keys[i] = key;
            values[i] = value;
        }
    }

    private boolean theSame(Key currentKey, Key key) {
        return currentKey.compareTo(key)==0;
    }

    private void checkCapacity() {
        if (size >= capacity*.75 ){
            capacity*=2;
            Key[] newKeys = (Key[]) new Comparable[capacity];
            Value[] newValues = (Value[]) new Object[capacity];
            for(int i =0; keys[i]!=null;i++){
                newKeys[i]=keys[i];
                newValues[i]=values[i];
            }
            keys = newKeys;
            values=newValues;
        }
    }

    private void moveElements(int i) {
        for(int x = size+1; x > i; x--){
            keys[x]=keys[x-1];
            values[x]=values[x-1];
        }
    }

    @Override
    public Value get(Key key) {
        if (isEmpty()) return null;
        int rank = rank(key);
        if (rank < size && theSame(keys[rank], key)) {
            return values[rank];
        }else{
            return null;
        }
    }

    @Override
    public void delete(Key key) {

    }

    @Override
    public boolean contains(Key key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Key min() {
        return null;
    }

    @Override
    public Key max() {
        return null;
    }

    @Override
    public Key floor(Key key) {
        int rank = rank(key);
        if (rank < size && theSame(keys[rank],key) ){
            return keys[rank];
        }else {
            return keys[rank-1];
        }
    }

    @Override
    public Key ceiling(Key key) {
        int rank = rank(key);
        if (rank < size && theSame(keys[rank],key) ){
            return keys[rank];
        }else if (rank<size){
            return keys[rank];
        }else{
            return null;
        }
    }

    @Override
    public int rank(Key key) {
        if (size==0) return 0;
        int lo = 0;
        int hi = size-1;
        while(hi >=lo) {
            int mid = (lo + hi) / 2;
            int cmp = keys[mid].compareTo(key);
            if (cmp==0){
                return mid;
            }else if (cmp < 0){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        return lo;
    }

    private boolean less(Key key, Key thenKey) {
        if (key == null) return false;
        else return key.compareTo(thenKey) < 0;
    }

    @Override
    public Key select(int k) {
        return keys[k];
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }
}

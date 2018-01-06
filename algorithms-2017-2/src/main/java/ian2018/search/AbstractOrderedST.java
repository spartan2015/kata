package ian2018.search;

/**
 * Created on 1/4/2018.
 */
public abstract class AbstractOrderedST<Key extends Comparable<Key>, Value> implements OrderedST<Key,Value> {
    public void deleteMin(){
        delete(min());
    }
    public void deleteMax(){
        delete(max());
    }
    public int size(Key lo, Key hi){
        if (hi.compareTo(lo) < 0){
            return 0;
        }else if (contains(hi)){
            return rank(hi)-rank(lo)+1;
        }else{
           return rank(hi)-rank(lo);
        }
    }
    public Iterable<Key> keys(){
        return keys(min(),max());
    }
}


package ian2018.search;

/**
 * Created on 1/3/2018.
 *
 * common implementation
 */
public abstract class AbstractST<Key,Value> implements ST<Key,Value>{
    @Override
    public void delete(Key key){
        put(key, null);
    }
    @Override
    public boolean contains(Key key){
        return get(key)!=null;
    }
    @Override
    public boolean isEmpty(){
        return size()==0;
    }
}

package ian2018.search;

/**
 * Created on 1/12/2018.
 */
public class RedBlackTree<Key extends Comparable<Key>,Value> implements OrderedST<Key,Value> {
    static class RedBlackNode<Key extends Comparable<Key>,Value>{
        Key key;
        Value value;
        RedBlackNode<Key,Value> left;
        RedBlackNode<Key,Value> right;
        boolean parentLinkIsRead;
        int size;
        public RedBlackNode(RedBlackNode<Key, Value> left, RedBlackNode<Key, Value> right, boolean parentLinkIsRead, int size) {
            this.left = left;
            this.right = right;
            this.parentLinkIsRead = parentLinkIsRead;
            this.size = size;
        }
    }

    RedBlackNode<Key,Value> root;

    private int size(RedBlackNode node){
        if (node != null) return node.size;
        return 0;
    }

    private boolean isPointedByRedLink(RedBlackNode<Key, Value> x){
        if (x != null) {
            return x.parentLinkIsRead;
        }else{
            return false;
        }
    }

    public RedBlackNode<Key,Value> rotateLeft(RedBlackNode<Key,Value> h){
        RedBlackNode<Key,Value> x = h.right;
        h.right = x.left;
        x.left = h;

        x.parentLinkIsRead = h.parentLinkIsRead;
        h.parentLinkIsRead = true;

        x.size = h.size;
        h.size = 1 + size(h.left) + size(h.right);

        return x;
    }

    public RedBlackNode<Key,Value> rotateRight(RedBlackNode<Key,Value> h){
        RedBlackNode<Key,Value> x = h.right;
        h.left = x.right;
        x.right = h;

        x.parentLinkIsRead = h.parentLinkIsRead;
        h.parentLinkIsRead = true;

        x.size = h.size;
        h.size = 1 + size(h.left) + size(h.right);

        return x;
    }

    @Override
    public Value get(Key key) {
        for(RedBlackNode<Key,Value> x = root; x!=null;){
            int cmp = key.compareTo(x.key);
            if (cmp == 0){
                return x.value;
            }else if (cmp < 0){
                x = x.left;
            }else{
                x = x.right;
            }
        }
        return null;
    }

    @Override
    public void put(Key key, Value value) {

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
        return false;
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
        return null;
    }

    @Override
    public Key ceiling(Key key) {
        return null;
    }

    @Override
    public int rank(Key key) {
        return 0;
    }

    @Override
    public Key select(int k) {
        return null;
    }

    @Override
    public void deleteMin() {

    }

    @Override
    public void deleteMax() {

    }

    @Override
    public int size(Key lo, Key hi) {
        return 0;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }

    @Override
    public Iterable<Key> keys() {
        return null;
    }


}

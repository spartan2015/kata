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
        public RedBlackNode(Key key, Value value, boolean parentLinkIsRead, int size) {
            this.key=key;
            this.value=value;
            this.left = left;
            this.right = right;
            this.parentLinkIsRead = parentLinkIsRead;
            this.size = size;
        }

        public String toString(){
            return key.toString();
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
        RedBlackNode<Key,Value> x = h.left;
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
        root = put(key,value,root);
        root.parentLinkIsRead=false;
    }

    private RedBlackNode<Key, Value> put(Key key, Value value, RedBlackNode<Key, Value> node) {
        if (node == null){
            return new RedBlackNode<>(key,value,root == null ? false : true,1);
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0){
            node.value = value;
            return node;
        }else if (cmp < 0){
            node.left = put(key,value,node.left);
        }else{
            node.right = put(key,value,node.right);
        }

        node = balanceNodeSedgewick(key, value, node, cmp);

        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    private RedBlackNode<Key, Value> balanceNode(Key key, Value value, RedBlackNode<Key, Value> node, int cmp) {
        if (isTwoNode(node)){
            if (cmp > 0 && !isPointedByRedLink(node.left) && isPointedByRedLink(node.right)) {
                node = rotateLeft(node); // when do we do rotation - here or later;
            }
        }else{ // a three node
            if (isPointedByRedLink(node.left)){ // upper right
                if (cmp > 0 && isPointedByRedLink(node.right)){
                    flipColors(node);
                }
            }else{
                if (cmp < 0){ // lower left
                    node = rotateRight(node);
                }else{ // lower middle
                    rotateLeft(node); // must rotate c right - shit must go till we find a link to put it in
                    flipColors(node);
                }
            }
        }
        return node;
    }

    private RedBlackNode<Key, Value> balanceNodeSedgewick(Key key, Value value, RedBlackNode<Key, Value> node, int cmp) {
        if (isPointedByRedLink(node.right) && !isPointedByRedLink(node.left)) return rotateLeft(node);
        if (isPointedByRedLink(node.left) && isPointedByRedLink(node.left.left)) return rotateRight(node);
        if (isPointedByRedLink(node.left) && isPointedByRedLink(node.right)) flipColors(node);
        return node;
    }

    private void flipColors(RedBlackNode<Key, Value> node) {
        node.parentLinkIsRead=true;
        if (node.left!=null) node.left.parentLinkIsRead=false;
        if (node.right!=null) node.right.parentLinkIsRead=false;
    }

    private boolean isTwoNode(RedBlackNode<Key, Value> node) {
        return !isPointedByRedLink(node) && !isPointedByRedLink(node.left);
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

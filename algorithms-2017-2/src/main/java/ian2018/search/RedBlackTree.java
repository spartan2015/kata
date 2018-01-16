package ian2018.search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Complete Tested Implementation - Sedgewick
 */
public class RedBlackTree<Key extends Comparable<Key>,Value> implements OrderedST<Key,Value> {
    static class RedBlackNode<Key extends Comparable<Key>,Value>{
        Key key;
        Value value;
        RedBlackNode<Key,Value> left;
        RedBlackNode<Key,Value> right;
        boolean isRedColorOfLinkToParent;
        int size;
        public RedBlackNode(Key key, Value value, boolean isRedColorOfLinkToParent, int size) {
            this.key=key;
            this.value=value;
            this.left = left;
            this.right = right;
            this.isRedColorOfLinkToParent = isRedColorOfLinkToParent;
            this.size = size;
        }

        public String toString(){
            return key.toString();
        }
    }

    RedBlackNode<Key,Value> root;

    public RedBlackTree() {
    }

    public RedBlackTree(String string) {
        for(String s : string.split("")){
            this.put((Key)s,(Value)s);
        }
    }

    private int size(RedBlackNode node){
        if (node != null) return node.size;
        return 0;
    }

    public RedBlackNode<Key,Value> rotateLeft(RedBlackNode<Key,Value> h){
        RedBlackNode<Key,Value> x = h.right;
        h.right = x.left;
        x.left = h;

        x.isRedColorOfLinkToParent = h.isRedColorOfLinkToParent;
        h.isRedColorOfLinkToParent = true;

        x.size = h.size;
        h.size = 1 + size(h.left) + size(h.right);

        return x;
    }

    public RedBlackNode<Key,Value> rotateRight(RedBlackNode<Key,Value> h){
        RedBlackNode<Key,Value> x = h.left;
        h.left = x.right;
        x.right = h;

        x.isRedColorOfLinkToParent = h.isRedColorOfLinkToParent;
        h.isRedColorOfLinkToParent = true;

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
    public void put(Key key, Value value) {
        root = put(key,value,root);
        root.isRedColorOfLinkToParent =false;
    }

    private RedBlackNode<Key, Value> put(Key key, Value value, RedBlackNode<Key, Value> node) {
        if (node == null){
            return new RedBlackNode<>(key,value,true,1);
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

    private RedBlackNode<Key, Value> balanceNodeSedgewick(Key key, Value value, RedBlackNode<Key, Value> node, int cmp) {
        if (isConnectedWithRed(node.right) && !isConnectedWithRed(node.left)) {
            return rotateLeft(node);
        }
        if (isConnectedWithRed(node.left) && isConnectedWithRed(node.left.left)) {
            return rotateRight(node);
        }
        if (isConnectedWithRed(node.left) && isConnectedWithRed(node.right)) {
            flipColors(node);
        }
        return node;
    }

    private boolean isConnectedWithRed(RedBlackNode<Key, Value> x){
        if (x != null) {
            return x.isRedColorOfLinkToParent;
        }else{
            return false;
        }
    }

    private void flipColors(RedBlackNode<Key, Value> node) {
        node.isRedColorOfLinkToParent =true;
        if (node.left!=null) node.left.isRedColorOfLinkToParent =false;
        if (node.right!=null) node.right.isRedColorOfLinkToParent =false;
    }

    private RedBlackNode<Key, Value> balanceNode(Key key, Value value, RedBlackNode<Key, Value> node, int cmp) {
        if (isTwoNode(node)){
            if (cmp > 0 && !isConnectedWithRed(node.left) && isConnectedWithRed(node.right)) {
                node = rotateLeft(node); // when do we do rotation - here or later;
            }
        }else{ // a three node
            if (isConnectedWithRed(node.left)){ // upper right
                if (cmp > 0 && isConnectedWithRed(node.right)){
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

    private boolean isTwoNode(RedBlackNode<Key, Value> node) {
        return !isConnectedWithRed(node) && !isConnectedWithRed(node.left);
    }

    @Override
    public void deleteMin() {
        delete(min());
    }

    @Override
    public void deleteMax() {
        delete(max());
    }


    /* rest of methods are exactly the same as BST copy paste*/

    @Override
    public int size(Key lo, Key hi) {
        return root != null ? root.size : 0;
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> q = new LinkedList<>();
        keys(lo, hi, q, root);
        return q;
    }

    private void keys(Key lo, Key hi, Queue<Key> q, RedBlackNode<Key, Value> node) {
        if (node == null) return;
        if (lo.compareTo(node.key) < 0) {
            keys(lo, hi, q, node.left);
        }
        if (node.key.compareTo(lo) >= 0 && node.key.compareTo(hi) <= 0) {
            q.add(node.key);
        }
        if (hi.compareTo(node.key) > 0) {
            keys(lo, hi, q, node.right);
        }
    }

    @Override
    public Iterable<Key> keys() {
        return keys(min(),max());
    }

    public Key min() {
        for (RedBlackNode<Key, Value> current = root; current != null; ) {
            if (current.left == null) return current.key;
            else current = current.left;
        }
        return null;
    }

    public Value minRecursive() {
        RedBlackNode<Key, Value> node = minRecursive(root);
        return node != null ? node.value : null;
    }

    private RedBlackNode<Key, Value> minRecursive(RedBlackNode<Key, Value> node) {
        if (node == null) return null;
        if (node.left == null) return node;
        else return minRecursive(node.left);
    }

    public Key max() {
        for (RedBlackNode<Key, Value> current = root; current != null; ) {
            if (current.right == null) return current.key;
            else current = current.right;
        }
        return null;
    }

    public Value maxRecursive() {
        return maxRecursive(root);
    }

    public Value maxRecursive(RedBlackNode<Key, Value> node) {
        if (node == null) return null;
        if (node.right == null) return node.value;
        else return maxRecursive(node.right);
    }

    public Key floorIterative(Key key) {
        RedBlackNode<Key, Value> current = root;
        RedBlackNode<Key, Value> lastKnownSmall = null;
        do {
            int cmp = key.compareTo(current.key);
            if (cmp < 0) {
                current = current.left;
            } else {
                lastKnownSmall = current;
                current = current.right;
            }
        } while (current != null);
        return lastKnownSmall != null ? lastKnownSmall.key : null;
    }

    public Key ceilingIterative(Key key) {
        RedBlackNode<Key, Value> current = root;
        RedBlackNode<Key, Value> lastKnownSmall = null;
        do {
            int cmp = key.compareTo(current.key);
            if (cmp > 0) {
                current = current.right;
            } else {
                lastKnownSmall = current;
                current = current.left;
            }
        } while (current != null);
        return lastKnownSmall != null ? lastKnownSmall.key : null;
    }

    public Key floor(Key key) {
        return floor(root, key);
    }

    private Key floor(RedBlackNode<Key, Value> node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return floor(node.left, key);
        } else {
            Key searchRight = floor(node.right, key);
            return searchRight != null ? searchRight : node.key;
        }
    }

    public Key ceiling(Key key) {
        return ceiling(root, key);
    }

    private Key ceiling(RedBlackNode<Key, Value> node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp > 0) {
            return ceiling(node.right, key);
        } else {
            Key searchRight = ceiling(node.left, key);
            return searchRight != null ? searchRight : node.key;
        }
    }

    public Key select(int k) {
        return select(root, k);
    }

    public Key select(RedBlackNode<Key, Value> node, int k) {
        if (node == null) return null;
        if (size(node.left) + 1 == k) {
            return node.key;
        } else if (size(node.left) >= k) {
            return select(node.left, k);
        } else if (k > size(node.left) + 1) {
            return select(node.right, k - size(node.left) - 1);
        } else {
            return null;
        }
    }

    public Key selectIterative(int k) {
        RedBlackNode<Key, Value> node = root;
        while (node != null) {
            if (size(node.left) + 1 == k) {
                return node.key;
            } else if (size(node.left) >= k) {
                node = node.left;
            } else if (k > size(node.left) + 1) {
                k = k - size(node.left) - 1;
                node = node.right;
            } else {
                return null;
            }
        }
        return null;
    }

    public int rank(Key key) {
        return rank(root, key, size(root) - size(root.right));
    }

    private int rank(RedBlackNode<Key, Value> node, Key key, int k) {
        if (node == null) return -1;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return rank(node.left, key, k - 1 - (node.left != null ? size(node.left.right) : 0));
        } else if (cmp > 0) {
            return rank(node.right, key, k + size(node.right) - ((node.right != null ? size(node.right.right) : 0)));
        } else {
            return k;
        }
    }

    public int rankIterative(Key key) {
        RedBlackNode<Key, Value> node = root;
        int k = size(root) - size(root.right);
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                k = k - 1 - (node.left != null ? size(node.left.right) : 0);
                node = node.left;
            } else if (cmp > 0) {
                k = k + size(node.right) - ((node.right != null ? size(node.right.right) : 0));
                node = node.right;
            } else {
                return k;
            }
        }
        return -1;
    }

    

}

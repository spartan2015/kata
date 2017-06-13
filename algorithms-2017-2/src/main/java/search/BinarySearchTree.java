package search;

import java.util.*;

/**
 * Created on 6/13/2017.
 *
 *
 BST search cost for random keys to be
 about 39 percent higher than that for binary search.

 * Search hits in a BST built from N random keys require ~ 2 ln N
 (about 1.39 lg N) compares, on the average.

 Insertions and search misses in a BST built from N random keys
 require ~ 2 ln N (about 1.39 lg N) compares, on the average.
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> implements OrderedST<Key,Value> {
 Node<Key,Value> root;
    static class Node<Key extends Comparable<Key>, Value>{
        Key key;
        Value value;
        int N = 1;
        Node<Key,Value> left,right;
        public Node(Key key,Value value){
            this.key = key;
            this.value = value;
        }
    }

    private int size(Node<Key,Value> node){
        if (node == null) return 0;
        return node.N;
    }

    @Override
    public void put(Key key, Value value) {
        Node<Key,Value> node = root;
        if (root == null){
            root = new Node(key,value);
            root.N = 1;
        }else {
            Stack<Node> chain = new Stack<>();
            boolean updateSize = false;
            while (node != null){
                chain.push(node);
                int cmp = key.compareTo(node.key);
                if (cmp == 0){
                    node.value = value;
                    break;
                }else if (cmp < 0){
                    if (node.left == null){
                        node.left = new Node(key,value);
                        updateSize = true;
                        break;
                    }else {
                        node = node.left;
                    }
                }else{
                    if (node.right == null){
                        node.right = new Node(key,value);
                        updateSize = true;
                        break;
                    }else {
                        node = node.right;
                    }
                }
            }
            if (updateSize) {
                while (!chain.isEmpty()) {
                    chain.pop().N = size(node.left) + size(node.right) + 1;
                }
            }
        }

    }

    public void putRecursive(Key key, Value value) {
        root = putRecursive(root, key,value);
    }

    private Node<Key,Value> putRecursive(Node<Key, Value> node, Key key, Value value) {
        if (node == null){
            return new Node(key,value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0){
            node.value = value;
        }else if (cmp < 0){
            node.left = putRecursive(node.left, key, value);
        }else{
            node.right = putRecursive(node.right, key, value);
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Value getRecursive(Key key) {
        return getRecursive(root ,key);
    }

    private Value getRecursive(Node<Key, Value> node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp ==0){
            return node.value;
        }
        else if (cmp < 0){
            return getRecursive(node.left,key);
        }else {
            return getRecursive(node.right,key);
        }
    }

    @Override
    public Value get(Key key) {
        Node<Key,Value> node = root;
        while(node!=null){
            int cmp = key.compareTo(node.key);
            if (cmp ==0){
                return node.value;
            }
            else if (cmp < 0){
                node = node.left;
            }else if (cmp > 0){
                node = node.right;
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
    public Key select(int rank) {
        return null;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }

    @Override
    public Iterator<Key> iterator() {
        return null;
    }
}

package ian2018.search;

import java.util.Stack;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    Node<Key, Value> root;

    public int size() {
        return size(root);
    }

    private int size(Node<Key, Value> x) {
        return x == null ? 0 : x.size;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    public void putIterative(Key key, Value value) {
        if (root == null) {
            root = new Node<>(key, value);
            root.size = 1;
            return;
        }
        Stack<Node<Key, Value>> changedNodes = new Stack<>();
        boolean newNode = false;
        Node<Key, Value> current = root;
        while (current != null) {
            changedNodes.push(current);
            int cmp = key.compareTo(current.key);
            if (cmp == 0) {
                current.value = value;
                break;
            } else if (cmp < 0) {

                if (current.left == null) {
                    current.left = new Node(key, value);
                    newNode = true;
                    current.left.size = 1;
                } else {
                    current = current.left;
                }
            } else {
                if (current.right == null) {
                    current.right = new Node(key, value);
                    newNode = true;
                    current.right.size = 1;
                } else {
                    current = current.right;
                }
            }
        }
        //compute size - keep a stack of the changed nodes
        if (newNode) {
            while (!changedNodes.isEmpty() && (current = changedNodes.pop()) != null) {
                current.size = size(current.left) + size(current.right) + 1;
            }
        }
    }

    public Node<Key, Value> put(Node<Key, Value> node, Key key, Value value) {
        if (node == null) {
            node = new Node<>(key, value);
        } else {
            int cmp = key.compareTo(node.key);
            if (cmp == 0) {
                node.value = value;
                return node; // avoid size computing
            } else if (cmp < 0) {
                node.left = put(node.left, key, value);
            } else {
                node.right = put(node.right, key, value);
            }
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Value get(Key key) {
        Node<Key, Value> current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp == 0) {
                return current.value;
            } else if (cmp < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    public Value getRecursive(Key key) {
        return getRecursive(root, key);
    }

    private Value getRecursive(Node<Key, Value> node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0) return node.value;
        else if (cmp < 0) return getRecursive(node.left, key);
        else return getRecursive(node.right, key);
    }

    public Value min() {
        for (Node<Key, Value> current = root; current != null; ) {
            if (current.left == null) return current.value;
            else current = current.left;
        }
        return null;
    }

    public Value minRecursive() {
        return minRecursive(root);
    }

    private Value minRecursive(Node<Key, Value> node) {
        if (node == null) return null;
        if (node.left == null) return node.value;
        else return minRecursive(node.left);
    }

    public Value max() {
        for (Node<Key, Value> current = root; current != null; ) {
            if (current.right == null) return current.value;
            else current = current.right;
        }
        return null;
    }

    public Value maxRecursive() {
        return maxRecursive(root);
    }

    public Value maxRecursive(Node<Key, Value> node) {
        if (node == null) return null;
        if (node.right == null) return node.value;
        else return maxRecursive(node.right);
    }

    public Key floorIterative(Key key) {
        Node<Key, Value> current = root;
        Node<Key, Value> lastKnownSmall = null;
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
        Node<Key, Value> current = root;
        Node<Key, Value> lastKnownSmall = null;
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

    private Key floor(Node<Key, Value> node, Key key) {
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

    private Key ceiling(Node<Key, Value> node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp > 0) {
            return ceiling(node.right, key);
        } else {
            Key searchRight = ceiling(node.left, key);
            return searchRight != null ? searchRight : node.key;
        }
    }

    static class Node<Key extends Comparable<Key>, Value> {
        Key key;
        Value value;
        int size;
        Node<Key, Value> left;
        Node<Key, Value> right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    public Key select(int k){
        return select(root, k);
    }

    public Key select(Node<Key,Value> node, int k){
        if (node == null) return null;
        if (size(node.left)+1 == k ) {
            return node.key;
        } else if (size(node.left) >= k ){
            return select(node.left, k);
        }else if ( k > size(node.left)+1){
            return select(node.right, k - size(node.left) - 1);
        }else{
            return null;
        }
    }

    public Key selectIterative(int k){
        Node<Key,Value> node = root;
        while(node != null) {
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

    public int rank(Key key){
        return rank(root, key, size(root)-size(root.right));
    }

    private int rank(Node<Key, Value> node, Key key, int k) {
        if (node == null) return -1;
        int cmp = key.compareTo(node.key);
        if (cmp < 0){
            return rank(node.left,key, k - 1 - (node.left != null ? size(node.left.right) : 0));
        }else if (cmp > 0){
            return rank(node.right,key, k + size(node.right) - ((node.right != null ? size(node.right.right) : 0)));
        }else{
            return k;
        }
    }

    public int rankIterative(Key key) {
        Node<Key, Value> node = root;
        int k =size(root)-size(root.right);
        while(node!=null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                k = k - 1 - (node.left != null ? size(node.left.right) : 0);
                node= node.left;
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

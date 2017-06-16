package search;

import java.util.*;

/**
 * Created on 6/13/2017.
 * <p>
 * <p>
 * BST search cost for random keys to be
 * about 39 percent higher than that for binary search.
 * <p>
 * Search hits in a BST built from N random keys require ~ 2 ln N
 * (about 1.39 lg N) compares, on the average.
 * <p>
 * Insertions and search misses in a BST built from N random keys
 * require ~ 2 ln N (about 1.39 lg N) compares, on the average.
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> implements OrderedST<Key, Value> {
    public Node<Key, Value> root;

    static class Node<Key extends Comparable<Key>, Value> {
        Key key;
        Value value;
        int N = 1;
        Node<Key, Value> left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size(Node<Key, Value> node) {
        if (node == null) return 0;
        return node.N;
    }

    @Override
    public void put(Key key, Value value) {
        Node<Key, Value> node = root;
        if (root == null) {
            root = new Node(key, value);
            root.N = 1;
        } else {
            Stack<Node> chain = new Stack<>();
            boolean updateSize = false;
            while (node != null) {
                chain.push(node);
                int cmp = key.compareTo(node.key);
                if (cmp == 0) {
                    node.value = value;
                    break;
                } else if (cmp < 0) {
                    if (node.left == null) {
                        node.left = new Node(key, value);
                        updateSize = true;
                        break;
                    } else {
                        node = node.left;
                    }
                } else {
                    if (node.right == null) {
                        node.right = new Node(key, value);
                        updateSize = true;
                        break;
                    } else {
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

    @Override
    public void deleteMin() {
        if (root == null) return;
        Node<Key, Value> node = root;
        if (root.left == null) {
            root = root.right;
            return;
        }

        Stack<Node> chain = new Stack<>();
        while (node.left != null) {
            chain.push(node);
            if (node.left.left == null) {
                node.left = node.left.right;
                return;
            }
            node = node.left;
        }
        while (!chain.isEmpty()) {
            chain.pop().N = size(node.left) + size(node.right) + 1;
        }
    }

    @Override
    public void deleteMax() {
        if (root == null) return;
        Node<Key, Value> node = root;
        if (root.right == null) {
            root = root.left;
            return;
        }
        Stack<Node> chain = new Stack<>();
        while (node.right != null) {
            if (node.right.right == null) {
                node.right = node.right.left;
                return;
            }
            node = node.left;
        }
        while (!chain.isEmpty()) {
            chain.pop().N = size(node.left) + size(node.right) + 1;
        }
    }

    public void putRecursive(Key key, Value value) {
        root = putRecursive(root, key, value);
    }

    private Node<Key, Value> putRecursive(Node<Key, Value> node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            node.value = value;
        } else if (cmp < 0) {
            node.left = putRecursive(node.left, key, value);
        } else {
            node.right = putRecursive(node.right, key, value);
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Value getRecursive(Key key) {
        return getRecursive(root, key);
    }

    private Value getRecursive(Node<Key, Value> node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node.value;
        } else if (cmp < 0) {
            return getRecursive(node.left, key);
        } else {
            return getRecursive(node.right, key);
        }
    }

    @Override
    public Value get(Key key) {
        Node<Key, Value> node = root;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp == 0) {
                return node.value;
            } else if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            }
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        boolean deletedHappened = false;
        Node<Key, Value> node = root;
        Node<Key, Value> parentNode = null;
        Stack<Node<Key, Value>> chain = new Stack<>();
        chain.push(node);
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp == 0) {
                chain.pop();
                //delete
                deletedHappened = true;
                if (node == root && size(node) == 1) {
                    root = null;
                    return;
                } else if (node == root && size(node) > 1) {
                    if (node.left != null) {
                        root = node.left;
                        if (node.right != null) {
                            Node<Key, Value> saved = node.right;
                            Node<Key, Value> tmp = node.left;
                            chain.push(tmp);
                            while (tmp.right != null) {
                                tmp = tmp.right;
                                chain.push(tmp);
                            }
                            tmp.right = saved;
                        }
                    } else {
                        Node<Key, Value> saved = node.left;
                        root = node.right;

                    }
                } else if (size(node) > 1) {
                    if (node.left != null) {
                        if (parentNode.left == node) {
                            parentNode.left = node.left;
                        } else {
                            parentNode.right = node.left;
                        }
                        Node<Key, Value> saved = node.right;
                        Node<Key, Value> tmp = node.left;
                        chain.push(tmp);
                        while (tmp.right != null) {
                            tmp = tmp.right;
                            chain.push(tmp);
                        }
                        tmp.right = saved;
                    } else {
                        if (parentNode.left == node) {
                            parentNode.left = node.right;
                        } else {
                            parentNode.right = node.right;
                        }
                    }
                } else if (size(node) == 1) { // leaf nodes
                    if (parentNode.left == node) {
                        parentNode.left = null;
                    } else {
                        parentNode.right = null;
                    }
                }
                break;
            } else if (cmp < 0) {
                parentNode = node;
                node = node.left;
                chain.push(node);
            } else {
                parentNode = node;
                node = node.right;
                chain.push(node);
            }
        }
        if (deletedHappened) {
            while (!chain.isEmpty()) {
                node = chain.pop();
                node.N = size(node.left) + size(node.right) + 1;
            }
        }
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
        if (root == null) return null;
        Node<Key, Value> node = root;
        while (node.left != null) {
            node = node.left;
        }
        ;
        return node.key;
    }

    @Override
    public Key max() {
        if (root == null) return null;
        Node<Key, Value> node = root;
        while (node.right != null) {
            node = node.right;
        }
        ;
        return node.key;
    }

    @Override
    public Key floor(Key key) {
        if (root == null) return null;
        Node<Key, Value> node = root;
        Node<Key, Value> previous = null;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp == 0) {
                return node.key;
            } else if (cmp < 0) {
                node = node.left;
            } else {
                previous = node;
                node = node.right;
            }
        }
        return previous != null && previous.key.compareTo(key) <= 0 ? previous.key : null;
    }

    @Override
    public Key ceiling(Key key) {
        if (root == null) return null;
        Node<Key, Value> node = root;
        Node<Key, Value> previous = null;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp == 0) {
                return node.key;
            } else if (cmp < 0) {
                previous = node;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return previous != null && previous.key.compareTo(key) >= 0 ? previous.key : null;
    }

    @Override
    public int rank(Key key) {
        Node<Key, Value> node = root;
        int rank = size(node.left);
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp == 0) {
                return rank;
            } else if (cmp < 0) {
                rank--;
                node = node.left;
            } else {
                rank += size(node.right) - (node.right != null ? size(node.right.right) : 0);
                node = node.right;
            }
        }
        return -1;
    }

    public int rank(Node<Key, Value> node, Key key, int add) {
        if (node == null) return -1;
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return add + size(node.left);
        } else if (cmp < 0) {
            return rank(node.left, key, add);
        } else {
            return rank(node.right, key, add + size(node.left) + 1);
        }
    }

    @Override
    public Key select(int rank) {
        Node<Key, Value> node = root;
        while (node != null) {
            if (rank == size(node.left)) {
                return node.key;
            } else if (size(node.left) > rank) {
                node = node.left;
            } else {
                rank -= 1 + size(node.left);
                node = node.right;
            }
        }
        return null;
    }

    private Key select(Node<Key, Value> node, int rank) {
        if (node == null) return null;
        if (rank == size(node.left)) {
            return node.key;
        } else if (size(node.left) > rank) {
            return select(node.left, rank);
        } else {
            return select(node.right, rank - size(node.left) - 1);
        }
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

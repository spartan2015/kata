package ian2018.search;

import java.util.Stack;

public class BinarySearchTree<Key extends Comparable<Key>,Value> {
    static class Node<Key extends Comparable<Key>,Value>{
        Key key;
        Value value;
        int size;
        Node<Key,Value> left;
        Node<Key,Value> right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }
    Node<Key,Value> root;

    public int size(){
        return size(root);
    }

    private int size(Node<Key,Value> x){
        return x == null ? 0 : x.size;
    }

    public void put(Key key, Value value){
        root = put(root,key,value);
    }

    public void putIterative(Key key, Value value){
        if (root == null){
            root = new Node<>(key,value);
            root.size =1;
            return;
        }
        Stack<Node<Key,Value>> changedNodes = new Stack<>();
        boolean newNode= false;
        Node<Key,Value> current = root;
        while( current != null){
            changedNodes.push(current);
            int cmp = key.compareTo(current.key);
            if (cmp == 0){
                current.value=value;
                break;
            }else if (cmp < 0){

                if (current.left==null){
                    current.left = new Node(key,value);
                    newNode=true;
                    current.left.size=1;
                }else{
                    current = current.left;
                }
            }else{
                if (current.right==null){
                    current.right = new Node(key,value);
                    newNode=true;
                    current.right.size=1;
                }else{
                    current = current.right;
                }
            }
        }
        //compute size - keep a stack of the changed nodes
        if (newNode){
            while(!changedNodes.isEmpty() && (current = changedNodes.pop())!=null){
                current.size = size(current.left) + size(current.right) + 1;
            }
        }
    }

    public Node<Key,Value> put(Node<Key,Value> node, Key key, Value value){
        if (node == null){
            node = new Node<>(key,value);
        }else{
            int cmp = key.compareTo(node.key);
            if (cmp == 0){
                node.value=value;
                return node; // avoid size computing
            }else if (cmp < 0){
                node.left = put(node.left, key,value);
            }else{
                node.right = put(node.right, key,value);
            }
        }
        node.size = size(node.left) + size(node.right)+1;
        return node;
    }
}

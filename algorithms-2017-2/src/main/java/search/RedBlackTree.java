package search;

/**
 * Created on 7/12/2017.
 */
public class RedBlackTree<Key,Value> {
    class RedBlackNode<Key,Value>{
        Key key;
        Value value;
        RedBlackNode left, right;
        // the color of the link pointing to this node
        boolean red;
        // subtree size
        int N;
    }

    private boolean isRed(RedBlackNode node){
        return node!=null && node.red;
    }

    private int size(RedBlackNode n) {
        return n != null ? n.N : 0;
    }

    private RedBlackNode rotateLeft(RedBlackNode h){
        RedBlackNode x = h.right;
        h.right = x.left;
        x.left = h;
        x.red = h.red;
        h.red = true;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private RedBlackNode rotateRight(RedBlackNode h){
        RedBlackNode x = h.left;
        h.left = x.right;
        x.right = h;
        x.red = h.red;
        h.red = true;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

}

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


}

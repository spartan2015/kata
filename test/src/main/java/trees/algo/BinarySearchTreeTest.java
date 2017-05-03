package trees.algo;

import org.junit.Test;

import trees.structures.BinarySearchTree;

/**
 * Created by Battlestar on 1/9/2015.
 */
public class BinarySearchTreeTest {

    @Test
    public void test(){
           BinarySearchTree<Integer> bt = new BinarySearchTree<Integer>();

        bt.addNode(10);
        bt.addNode(9);
        bt.addNode(11);

        bt.addNode(8);
        bt.addNode(12);

        System.out.println("inOrder");
        bt.inOrderTraverse(bt.root);
        System.out.println("preOrder");
        bt.preOrderTraverse(bt.root);
        System.out.println("postOrder");
        bt.postOrderTraverse(bt.root);

        bt.search(8);
    }
}

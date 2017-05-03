package sorting;

/**
 * Created by Battlestar on 1/12/2015.
 */
public class Heap<T extends Comparable> {

    HeapNode root;
    HeapNode lastLeaf;
    HeapNode nextLevelNode;
    HeapNode lastNode;
    int count =0;
    int level = 0;

    public void addNode(HeapNode node){
        lastNode = node;
        count++;
        if (root == null){
            root = node;
            lastLeaf = node;
            nextLevelNode = node;
            level++;
        }else{
            if (lastLeaf.left == null){
                lastLeaf.left = node;
                node.parent = lastLeaf;
                if (count == Math.pow(2,level)){
                    nextLevelNode = node;
                    level++;
                }
            }else{
                lastLeaf.right = node;
                node.parent = lastLeaf;
                // determine the next leaf based on level
                if (Math.pow(2,level) - 1 == count){
                    lastLeaf = nextLevelNode; // incorect - last leafNode where you should add - is not nextLevelNode -
                }
            }
        }
        moveUp(node);
    }

    public HeapNode removeFirst(){
        HeapNode oldRoot = root;
        lastNode.parent = null;
        root=lastNode;
        root.left = oldRoot.left;
        root.right = oldRoot.right;
        moveDown(root);
        return oldRoot;
    }

    private void moveUp(HeapNode node){
        if (node.parent == null){
            return;
        }
        while (root != node && node.value.compareTo(node.parent.value) > 0){
            swapNodes(node.parent, node);
        }
    }

    private void moveDown(HeapNode node){
        // left or right ? well depends - if right tree is full then left - right
        if (count == 1){
            return;
        }
        if (count < (Math.pow(2,level+1)-1 - (Math.pow(2,level)/2))){ // valabil doar pentru root - ce se intampla daca nu e root-ul ? comparam cu ?
            swapNodes(node, node.left);
        }else{
            swapNodes(node, node.right);
        }

        while ((node.left!=null && node.left.value.compareTo(node.value) > 0) || (node.right != null && node.right.value.compareTo(node.value) > 0)){
            if(node.left.value.compareTo(node.right.value) >= 0) {
                swapNodes(node, node.left);
            }
            else{
                swapNodes(node, node.right);
            }
        }

        count--;
        level = (int)Math.floor(Math.sqrt(count));
    }

    private void  swapNodes(HeapNode first, HeapNode second){
        HeapNode node = null;

        if (second.parent != null && second.parent == first){
            node = second;
        }else{
            node = first;
        }

        HeapNode oldParent = node.parent;

        if (oldParent == root){
            root = node;
        }
        if (lastLeaf == oldParent){ // in a move down this would be correct
            lastLeaf = node;
        }

        if (lastNode == node){
            lastNode = oldParent;
        }

        if (nextLevelNode == node){
            nextLevelNode = oldParent;
        }

        // swap them - aht means oyu need to find the parent of parent at link to node
        // also node must link the parent - now depends if left or right

        node.parent = node.parent.parent;

        // parent of parent point to new node
        if (oldParent.parent != null) {
            if (oldParent.parent.left == oldParent) {
                oldParent.parent.left = node;
            } else {
                oldParent.parent.right = node;
            }
        }

        HeapNode<T> leftChild = node.left;
        HeapNode<T> rightChild = node.right;
        //our node will point to oldParent -
        oldParent.parent = node;
        if(oldParent.left == node){
            node.left = oldParent;
            node.right = oldParent.right;
            if (node.right!=null) {
                node.right.parent = node;
            }
        }else{
            node.left = oldParent.left;
            if (node.left!=null) {
                node.left.parent = node;
            }
            node.right=oldParent;
        }

        // swap children pointers
        oldParent.left = leftChild;
        if (oldParent.left != null){
            oldParent.left.parent = oldParent;
        }
        oldParent.right = rightChild;
        if(oldParent.right!=null){
            oldParent.right.parent = oldParent;
        }
    }

}

class HeapNode<T extends Comparable>{
    T value;
    HeapNode parent;
    HeapNode left;
    HeapNode right;
}
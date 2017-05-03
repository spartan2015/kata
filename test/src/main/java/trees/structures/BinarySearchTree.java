package trees.structures;

public class BinarySearchTree<T extends Comparable<T>>{
    public TreeNode<T> root;
    public void addNode(T value){
        TreeNode<T> newNode = new TreeNode();
        newNode.value= value;
        if (root == null){
            root = newNode;
        }else{

            TreeNode<T> currentNode = root;

            while(true){
                if (value.compareTo(currentNode.value) < 0){
                    if (currentNode.left == null){
                        currentNode.left = newNode;
                        return;
                    }else{
                        currentNode = currentNode.left;
                    }
                }else{
                    if (currentNode.right == null){
                        currentNode.right = newNode;
                        return;
                    }else{
                        currentNode = currentNode.right;
                    }
                }
            }

        }
    }

    public void inOrderTraverse(TreeNode focusNode){
        if(focusNode != null) {
            inOrderTraverse(focusNode.left);
            System.out.println(focusNode.value);
            inOrderTraverse(focusNode.right);
        }
    }

    public void preOrderTraverse(TreeNode focusNode){
        if(focusNode != null) {
            System.out.println(focusNode.value);
            preOrderTraverse(focusNode.left);
            preOrderTraverse(focusNode.right);
        }
    }

    public void postOrderTraverse(TreeNode focusNode){
        if(focusNode != null) {
            postOrderTraverse(focusNode.left);
            postOrderTraverse(focusNode.right);
            System.out.println(focusNode.value);
        }
    }

    public void search(T value){
        TreeNode<T> current = root;

        while(current != null) {
            int comp = value.compareTo(current.value);

            if (comp == 0) {
                System.out.println("found it !");
                return;
            }
            if (comp < 0) {
                current = current.left;
            } else if (comp > 0) {
                current = current.right;
            }
        }
    }
    
}
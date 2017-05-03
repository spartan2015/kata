package trees.structures;

public class TreeNode<E extends Comparable<E>> {
	public E value;
	public int balance;
	
	public TreeNode<E> parent;
	
	public TreeNode<E> left;
	public TreeNode<E> right;

	public TreeNode() {
		
	}
	
	public TreeNode(E value) {
		this.value = value;
	}
	
	public String toString(){
		return value.toString();
	}
	
}
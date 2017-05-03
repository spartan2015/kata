package trees.algo.s2;

public class TreeNode<T extends Comparable<T>> {
	TreeNode<T> left;
	TreeNode<T> right;
	TreeNode<T> parent;
	T value;

	public TreeNode(T value) {
		this.value = value;
	}

	public String toString() {
		return value + "";
	}
}
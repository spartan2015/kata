package linkedlists;

public class LinkedListNode<E> {
	public LinkedListNode<E> next;
	public E data;

	public LinkedListNode(E data) {
		this.data = data;
	}

	public LinkedListNode<E> addToTail(E data) {
		LinkedListNode<E> whereToAdd = this;
		while (whereToAdd.next != null) {
			whereToAdd = whereToAdd.next;
		}
		whereToAdd.next = new LinkedListNode<>(data);
		return this;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.data);
		LinkedListNode<E> current = this;
		while ((current = current.next) != null) {
			sb.append("->" + current.data);
		}
		return sb.toString();
	}

	public static <T> LinkedListNode<T> create(T... t) {
		if (t==null || t.length == 0) return null;
		LinkedListNode<T> root = new LinkedListNode<T>(t[0]);
		for(int i = 1; i< t.length; i++){
			root.addToTail(t[i]);
		}
		return root;
	}
}
package strings.algo.searching;

/**
 * Speed: 
 * search miss: log N
 * search hit: logN + size of key - and at most t * lnR
 * 
 * Size: 3N and 3Nw - way better than Trie
 * N - number of keys
 * w - average key size
 * @author vasil
 *
 * @param <T>
 */
public class TernarySearchTrie<T> {
	TernaryTrieNode<T> root;

	static class TernaryTrieNode<E> {
		char c;
		TernaryTrieNode<E> less;
		TernaryTrieNode<E> equal;
		TernaryTrieNode<E> greater;
		E value;

		TernaryTrieNode(char c, E value) {
			this.value = value;
			this.c = c;
		}
	}

	public T get(String key) {
		TernaryTrieNode<T> node = get(root, key, 0);
		return node != null ? node.value : null;
	}

	private TernaryTrieNode<T> get(TernaryTrieNode<T> node, String key, int index) {
		if (node == null || index >= key.length())
			return null;

		char c = key.charAt(index);
		if (c == node.c) {
			if (index == key.length() - 1) {
				return node;
			} else {
				return get(node.equal, key, index + 1);
			}
		} else if (c < node.c) {
			return get(node.less, key, index);
		} else {
			return get(node.greater, key, index);
		}

	}

	public void put(String key, T value) {
		root = put(root, key, value, 0);
	}

	private TernaryTrieNode<T> put(TernaryTrieNode<T> node, String key, T value, int index) {
		if (index >= key.length())
			return node;
		char c = key.charAt(index);
		if (node == null) {
			node = new TernaryTrieNode<>(c, value);
		}
		if (node.c == c) {
			node.equal = put(node.equal, key, value, index+1);
		} else if (c < node.c) {
			node.less = put(node.less, key, value, index);
		} else {
			node.greater = put(node.greater, key, value, index);
		}
		return node;
	}
}

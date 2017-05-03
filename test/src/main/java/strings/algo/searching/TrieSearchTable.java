package strings.algo.searching;

import java.util.LinkedList;
import java.util.Queue;

import strings.algo.Alphabet;
import strings.algo.Alphabet26;

/**
 * Speed - awesome (best) - search hit - max length of key, search miss - log N
 * 
 * size would be a problem here with large alphabets
 * 
 * Size:
 * between N * R and N * R * w
 * Eg 256 alphabet * 1 million keys - starts from 256 million 
 * 
 * w - average key length
 * N - N number of keys
 * R - size of alphabet
 * 
 * 
 * 
 * @author vasil
 *
 * @param <T>
 */
public class TrieSearchTable<T> implements StringSearchTable<T> {

	TrieNode<T> root;
	Alphabet alphabet;

	static class TrieNode<E> {
		TrieNode<E>[] links;
		E value;
		Alphabet alphabet;

		public TrieNode(Alphabet alphabet) {
			this.alphabet = alphabet;
			links = new TrieNode[alphabet.R()];
		}

		public TrieNode(E value) {
			links = new TrieNode[26];
			this.value = value;
		}

		boolean hasLink(int index) {
			return links[index] != null;
		}

		boolean hasLink(char c) {
			return links[c - 97] != null;
		}

		TrieNode<E> next(char c) {
			return links[c - 97];
		}

		E get(char c) {
			return links[c - 97] != null ? links[c - 97].value : null;
		}

		void put(char c, E value) {
			if (links[c - 97] != null) {
				links[c - 97].value = value;
			} else {
				links[c - 97] = new TrieNode<>(value);
			}
		}
	}

	public TrieSearchTable() {
		this(new Alphabet26());
	}

	public TrieSearchTable(Alphabet alphabet) {
		this.alphabet = alphabet;
		root = new TrieNode<>(this.alphabet);
	}

	@Override
	public void put(String key, T value) {
		if (key.length() == 0)
			return;
		put(root, key, value, 0);
	}

	private void put(TrieNode<T> node, String key, T value, int index) {
		char c = key.charAt(index);
		if (index == key.length() - 1) {
			node.put(c, value);
		} else {
			node.put(c, null);
			put(node.next(c), key, value, index + 1);
		}
	}

	@Override
	public T get(String key) {
		TrieNode<T> node = get(root, key, 0);
		return node != null ? node.value : null;
	}

	private TrieNode<T> get(TrieNode<T> node, String key, int index) {
		char c = key.charAt(index);
		if (index == key.length() - 1) {
			return node.next(c);
		} else {
			if (node.hasLink(c)) {
				return get(node.next(c), key, index + 1);
			} else {
				return null;
			}
		}
	}

	@Override
	public void delete(String key) {
		root = delete(root, key, 0);
	}

	private TrieNode<T> delete(TrieNode<T> node, String key, int index) {
		if (node == null) return null;
		if (index == key.length()){
			node.value = null;
		}else{
			char c = key.charAt(index);
			if (node.hasLink(c)){
				node.links[alphabet.toIndex(c)]=delete(node.links[alphabet.toIndex(c)], key, index+1);
			}
		}
		boolean hasChildren = false; 
		for(int r =0; r < alphabet.R(); r++){
			if (node.links[r]!= null){
				hasChildren = true;
				break;
			}
		}
		if (!hasChildren && node !=root){
			return null;
		}else{
			return node;
		}
	}

	@Override
	public boolean contains(String key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	private void collect(TrieNode<T> node, String prefix, String pattern, Queue<String> keys) {
		if (node == null)
			return;
		int d = prefix.length();
		if (d == pattern.length() && node.value!= null) keys.add(prefix);
		if (d == pattern.length()) return;
		
		char c = pattern.charAt(d);
		for(int i =0; i< alphabet.R(); i++){
			if (c == '.' || c == alphabet.toChar(i)){
				collect(node.links[i], prefix+alphabet.toChar(i), pattern, keys);
			}
		}
	}

	private void collect(TrieNode<T> node, String prefix, Queue<String> keys) {
		if (node == null) {
			return;
		}
		if (node.value != null) {
			keys.add(prefix);
		}
		for (int i = 0; i < alphabet.R(); i++) {
			collect(node.links[i], prefix + alphabet.toChar(i), keys);
		}
	}

	@Override
	public String longestPrefixOf(String s) {
		int length = search(root, s, 0, 0);
		return s.substring(0, length);
	}

	private int search(TrieNode<T> node, String s, int index, int lastKnownIndexWithValue) {
		if (node == null ) return lastKnownIndexWithValue;
		if (index == s.length()) return lastKnownIndexWithValue;
		char c = s.charAt(index);
		if (node.hasLink(c)){
			if (node.next(c).value!=null)lastKnownIndexWithValue = index;
			return search(node.next(c), s, index+1, lastKnownIndexWithValue);
		}
		return index;
	}

	@Override
	public Iterable<String> keysWithPrefix(String s) {
		Queue<String> keys = new LinkedList<>();
		collect(get(root, s, 0), s, keys);
		return keys;
	}

	@Override
	public Iterable<String> keysThatMatch(String pattern) {
		Queue<String> keys = new LinkedList<>();
		collect(root, "", pattern, keys);
		return keys;
	}

	@Override
	public int size() {
		/* lazy - avoid in practice */
		return size(root);
	}

	private int size(TrieNode<T> node) {
		if (node == null)
			return 0;
		int count = 0;
		if (node.value != null)
			count++;
		for (int i = 0; i < alphabet.R(); i++) {
			count += size(node.links[i]);
		}
		return count;
	}

	@Override
	public Iterable<String> keys() {
		LinkedList<String> keys = new LinkedList<>();
		collect(root, "", keys);
		return keys;
	}

}

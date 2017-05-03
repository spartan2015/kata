package strings.algo.searching;

public interface StringSearchTable<T> {

	void put(String key, T value);
	
	T get(String key);
	
	void delete(String key);
	
	boolean contains(String key);
	
	boolean isEmpty();
	
	String longestPrefixOf(String s);
	
	Iterable<String> keysWithPrefix(String s);
	
	Iterable<String> keysThatMatch(String s);
	
	int size();
	
	Iterable<String> keys();

}

package hackerRank;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * fast but wrong
 * 
 * some tests work: 0, 6,7,8 all other fail - wrong answer
 * 
 * 
 * @author vasil
 *
 */
public class CommonChildSkipCount {

	@Test
	public void test() {
		assertEquals(Integer.valueOf(3), Integer.valueOf(maxFromString("ABCD", "ABDC")));
	}

	@Test
	public void test2() {
		assertEquals(Integer.valueOf(3), Integer.valueOf(maxFromString("SHINCHAN", "NOHARAAA")));
	}

	@Test
	public void test3() {
		assertEquals(Integer.valueOf(2), Integer.valueOf(maxFromString("ABCDEF", "FBDAMN")));
	}

	@Test
	public void test4() {
		assertEquals(Integer.valueOf(2), Integer.valueOf(maxFromString("HARRY", "SALLY")));
	}

	@Test
	public void test5() {
		assertEquals(Integer.valueOf(0), Integer.valueOf(maxFromString("AA", "BB")));
	}

	@Test
	public void test6() {
		assertEquals(Integer.valueOf(3), Integer.valueOf(maxFromString("NHA", "NHNHA")));
	}

	@Test
	public void test7() {
		assertEquals(Integer.valueOf(1), Integer.valueOf(maxFromString("ABC", "ADE")));
	}

	@Test
	public void t2() {
		assertEquals(Integer.valueOf(8), Integer.valueOf(timed(() -> maxFromString("ABCDEFGH", "ABCDEFGHIABCDEFGHI"))));
	}

	@Test
	public void input01() {
		assertEquals(Integer.valueOf(15),
				Integer.valueOf(timed(() -> maxFromString("WEWOUCUIDGCGTRMEZEPXZFEJWISRSBBSYXAYDFEJJDLEBVHHKS",
														  "FDAGCXGKCTKWNECHMRXZWMLRYUCOCZHJRRJBOAJOQJZZVUYXIC"))));
	}

	public static <T> T timed(Callable<T> task) {
		long start = System.currentTimeMillis();
		T result;
		try {
			result = task.call();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		System.out.println("Duration: " + (System.currentTimeMillis() - start));
		return result;
	}

	static class LastMatch {
		int sIndex;
		int bIndex;

		LastMatch(int sIndex, int bIndex) {
			this.sIndex = sIndex;
			this.bIndex = bIndex;
		}
	}

	static class IncremenetalHash {
		int prevHash = 0;
		int hash = 0;
		List<Character> list = new ArrayList<>();

		void add(Character a) {
			// prevHash = hash;
			// hash += 13 + 7 * a.charValue();
			list.add(a);
		}

		IncremenetalHash() {
		}

		IncremenetalHash(IncremenetalHash other) {
			// this.hash = other.hash;
			list.addAll(other.list);
		}

		public String toString() {
			return list.toString();
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String aString = in.next();
		String bString = in.next();

		System.out.println(maxFromString(aString, bString));
	}

	private static int maxFromString(String aString, String bString) {
		Set<Character> aSet = Arrays.stream(aString.split("")).filter(s -> s.length() != 0).map(s -> s.charAt(0))
				.collect(Collectors.toSet());
		Set<Character> bSet = Arrays.stream(bString.split("")).filter(s -> s.length() != 0).map(s -> s.charAt(0))
				.collect(Collectors.toSet());

		aSet.retainAll(bSet);
		if (aSet.size() == 0)
			return 0;
		char[] a = retainCommon(aString, aSet);
		char[] b = retainCommon(bString, aSet);

		return max(a, 0, new IncremenetalHash(), b, new HashMap(), 0, 0);
	}

	private static int max(char[] ch, int index, IncremenetalHash orig, char[] bString,
			Map<Integer, LastMatch> lastKnown, int sIndex, int bIndex) {
		HashMap<Character, LinkedList<Integer>> orderMap = new HashMap<>();
		for (int i = 0; i < ch.length; i++) {
			if (orderMap.get(ch[i]) == null) {
				orderMap.put(ch[i], new LinkedList<Integer>());
			}
			orderMap.get(ch[i]).offer(i);
		}
		int realMax = 1;
		for (int startLetterIndex = 0; startLetterIndex < bString.length; startLetterIndex++) {
			HashMap<Character, LinkedList<Integer>> changeStartClone = clone(orderMap);
			int startLetterIndexlastIndex = changeStartClone.get(bString[startLetterIndex]).removeFirst();			
			System.out.println("--");
			System.out.println("--");
			System.out.println("StartWith: "+ bString[startLetterIndex] + " index at + " + startLetterIndexlastIndex);
			
			
			for(int followingLetterIndex = startLetterIndex+1; followingLetterIndex < bString.length; followingLetterIndex++){
				HashMap<Character, LinkedList<Integer>> changeFollowingStartClone = clone(changeStartClone);
			
				int max = 1;
				
				System.out.println("Following letter: " + bString[followingLetterIndex] + " lastIndex " + startLetterIndexlastIndex);
				int nextLetterIndex = -1;
				 int nextIndex = nextIndex(bString, startLetterIndexlastIndex, changeFollowingStartClone, max, followingLetterIndex);
					if (nextIndex!=-1){
						max++;
						nextLetterIndex = nextIndex;
						System.out.println("Is possible after index " + nextLetterIndex);
					}else{
						System.out.println("NOT POSSIBLE");
						continue;
					}
				
				for (int letterIndex = followingLetterIndex+1; letterIndex < bString.length; letterIndex++) {
					nextIndex = nextIndex(bString, nextLetterIndex, changeFollowingStartClone, max, letterIndex);
					if (nextIndex!=-1){
						max++;
						nextLetterIndex = nextIndex;
					}
				}
				
				System.out.println("--");
				System.out.println("Max between " + realMax + " and current " + max);
				realMax = Math.max(realMax, max);
			}
		}
		return realMax;
	}

	private static int nextIndex(char[] bString, int lastIndex,
			HashMap<Character, LinkedList<Integer>> changeFollowingStartClone, int max, int letterIndex) {
		LinkedList<Integer> positions = changeFollowingStartClone.get(bString[letterIndex]);
		System.out.print("("+bString[letterIndex]+", positions: "+positions+")");
		if (positions != null && positions.size() > 0) {
			for (int g = 0; g < positions.size(); g++) {
				int v = positions.get(g);
				if (v > lastIndex) {
					lastIndex = v; System.out.print(">"+ bString[letterIndex] + "["+lastIndex+"]<");
					
					positions.remove(g);
					return v;
				}
			} 
		}else{
			System.out.print("("+bString[letterIndex]+")");
			return -1;
		}
		return -1;
	}

	static final LastMatch def = new LastMatch(0, 0);

	private static int[] possible(IncremenetalHash sequence, char[] bString, Map<Integer, LastMatch> lastKnown,
			int sIndex, int bIndex) {
		// LastMatch last = lastKnown.getOrDefault(sequence.prevHash, def);
		// System.out.println("sequence " + sequence + " prevHash " +
		// sequence.prevHash + ", last" + last.sIndex + "- " + last.bIndex);
		// int sIndex = 0;//last.sIndex;
		// int bIndex = 0; //last.bIndex;
		for (; bIndex < bString.length && sIndex < sequence.list.size(); bIndex++) {
			// System.out.println(bString[bIndex] + " == " +
			// sequence.list.get(sIndex) + " option: " + sequence.list);
			if (bString[bIndex] == sequence.list.get(sIndex)) {
				// System.out.println("sequence " + sequence + " hash " +
				// sequence.hash + ", last" + sIndex + "- " + bIndex);
				// lastKnown.put(sequence.hash, new LastMatch(sIndex+1,
				// bIndex+1));
				sIndex++;
			}
			if (sIndex == sequence.list.size()) {
				// System.out.println("Valid: " + sequence);
				return new int[] { sIndex, bIndex + 1 };
			}
		}
		return null;
	}

	private static char[] retainCommon(String aString, Set<Character> aSet) {
		StringBuilder s1Sb = new StringBuilder();
		for (int i = 0; i < aString.length(); i++) {
			char ch = aString.charAt(i);
			if (aSet.contains(ch)) {
				s1Sb.append(ch);
			}
		}
		char[] chars = new char[s1Sb.length()];
		s1Sb.getChars(0, s1Sb.length(), chars, 0);
		return chars;
	}

	private static <T> T clone(T object) {
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(object);
			oos.flush();
			oos.close();
			bos.close();
			byte[] byteData = bos.toByteArray();
			ByteArrayInputStream bais = new ByteArrayInputStream(byteData);
			return (T) new ObjectInputStream(bais).readObject();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;

	}
}

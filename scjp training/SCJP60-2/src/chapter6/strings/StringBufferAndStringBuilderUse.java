package chapter6.strings;

public class StringBufferAndStringBuilderUse {

	
	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder("abc");
		
		// 1. append(boolean, char, char[], CharSequence, double, float, int, long, object, string, stringBuffer, char[] start, CharSequence start, ent)

		sb.append("def");
		System.out.println("1. append(*) "+ sb);
		
		// 2. sb.delete(int start, int until)
		sb = new StringBuilder("0123456").delete(2, 3); // sterge de la 2 pana la 3
		System.out.println("2. sb.delete(int start, int until) " + sb);
		
		// 3. sb.insert(int offset, String s)
		sb = new StringBuilder("0123456").insert(2, "ABC");
		System.out.println("3. sb.insert(int offset, String s) " + sb);
		
		// 4. sb.reverse()
		sb = new StringBuilder("123");
		System.out.println("4. sb.reverse() " + sb.reverse());
		
		// 5. toString()
		
	}

}

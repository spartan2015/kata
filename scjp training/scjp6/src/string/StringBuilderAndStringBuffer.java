package string;

public class StringBuilderAndStringBuffer {

	
	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder("a");
		
		sb.append("b");
		
		System.out.println(sb);
		
		sb.delete(0, 1);
		
		System.out.println(sb);
		
		sb.insert(0, "a");
		System.out.println(sb);
		
		sb.reverse();
		System.out.println(sb);
		
		

	}

}

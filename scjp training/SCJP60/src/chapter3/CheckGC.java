package chapter3;

public class CheckGC {

	
	public enum Suits{
		A;
		private String string = "private enum variable avail into the class";
	}
	
	public static class G{
		private static String as;
	}
	
	public static void main(String[] args) {
		
		Runtime r = Runtime.getRuntime();
		System.out.println("total available memory(bytes): " + r.totalMemory());
		System.out.println("total available memory(M): " + (r.totalMemory()/Math.pow(1024, 2)));
		System.out.println("free memory - before: " + (r.freeMemory()/Math.pow(1024, 2)));
		double[] d = new double[4000000];
		
		System.out.println("total available memory(M) - after double alocation: " + (r.totalMemory()/Math.pow(1024, 2)));
		System.out.println("free memory - after alocation: " + (r.freeMemory()/Math.pow(1024, 2)));
		d=null;
		System.gc();
		System.out.println("total available memory(M) - afte gc call: " + (r.totalMemory()/Math.pow(1024, 2)));
		System.out.println("free memory - after gc: " + (r.freeMemory()/Math.pow(1024, 2)));
		
		double x = 2.3 * 2.1;
		System.out.println(x);
		
		
		int[] i1 = new int[1];
		int[] i2 = new int[20];
		
		i1 = i2;
		
		System.out.println(Suits.A.string);
		
		System.out.println(G.as);
	}

}

class B{
	B(){
		CheckGC.Suits.string;
	}
}

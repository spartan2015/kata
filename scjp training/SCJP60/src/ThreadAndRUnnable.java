
public class ThreadAndRUnnable {

	public static void main(String ar[]){
		System.out.println(new Integer(1) == new Integer(1));
		
		// value of intoarce un obiect, wrapperul
		Integer i2 = Integer.valueOf("1");
		
		// parseXXX() - intoarce primitiva
		int i1 = Integer.parseInt("1");
				
		for(int i = 0; i <= 10; i++){
			System.out.println(Integer.toString(i, 2) + "		" + Integer.toString(i, 16) + "		" + Integer.toString(i, 8));			
		}
		
		
	}
		
	
}

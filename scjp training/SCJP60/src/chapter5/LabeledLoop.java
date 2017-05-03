package chapter5;

public class LabeledLoop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * both break and continue statements can be labeld
		 * 
		 * the labeled break and continue statement must be inside the loop with the label
		 * otherwise COMPILE ERROR
		 */

		a: for(int i = 0; i < 3; i++){
			System.out.println("one");
			if (true){ // CONDITION IS A MUST if code follows - otherwise COMPILE ERROR - UNREACHABLE CODE 
				continue a;
				//continue b; //IMPOSSIBLE: COMPILE ERROR - the label b is missing
			}
			System.out.println("never printer");
		}
	}

}

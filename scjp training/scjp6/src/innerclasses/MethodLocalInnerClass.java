package innerclasses;

public class MethodLocalInnerClass {

	private static int y = 11;	
	
	public static void main(String[] args) {
		
		final int x = 10;
		class MethodLocalClass {
			public void seeMethodFinalVars() {
				System.out.println("final int x local method var is: " + x);
				System.out.println("final int y outer class private member: " + y);				
			}
		}

		new MethodLocalClass().seeMethodFinalVars();
		
		new MethodLocalInnerClass().testInstanceReferenceOnTheMethodLocalClass();
	}

	private String privateInstanceMember = "10";
	public void testInstanceReferenceOnTheMethodLocalClass(){
		class MethodLocalClass {
			public void seeMethodFinalVars() {
				System.out.println("private outer class member privateInstanceMember is: " + privateInstanceMember);
			}
		}
		new MethodLocalClass().seeMethodFinalVars();
	} 
}

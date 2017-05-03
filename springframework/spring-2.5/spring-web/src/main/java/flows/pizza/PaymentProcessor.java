package flows.pizza;

public class PaymentProcessor {
	public void approveCreditCard(String creditCardNumber) throws PaymentException{
		System.out.println("Approving credit card: " + creditCardNumber);
		if (creditCardNumber.equals("1")){
			throw new PaymentException();
		}		
	}
}

package flows.pizza;

import org.springframework.webflow.execution.Action;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;



public class LookupCustomerAction implements Action {

	public Event execute(RequestContext context) throws Exception {
		
		String phoneNumber = (String)context.getRequestParameters().get("number");
		System.out.println("Got number:  " + phoneNumber);
		
		if (phoneNumber.equals("1")){
			throw new CustomerNotFoundException();
		}else{		
			Order order = (Order)context.getFlowScope().get("order");
			Customer customer = new Customer();
			
			
			order.setCustomer(customer);
			
			return new Event(this,"success");
		}		
	}

}

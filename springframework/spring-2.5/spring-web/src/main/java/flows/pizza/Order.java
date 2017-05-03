package flows.pizza;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Order implements Serializable{
	private Customer customer;
	private List<Pizza> pizzas;
	
	
	public Order(){
		pizzas = new ArrayList<Pizza>();
		customer = new Customer();
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Pizza> getPizzas() {
		return pizzas;
	}
	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	
	public void addPizza(Pizza pizza){
		pizzas.add(pizza);
	}
}

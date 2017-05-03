package flows.pizza;

import java.io.Serializable;

public class Customer implements Serializable{
	private String phoneNumber;
	String city;
	String state;
	String zipCode;
	String streetAddress;
	boolean inDeliveryArea;
	
	public boolean isInDeliveryArea() {
		return inDeliveryArea;
	}
	public void setInDeliveryArea(boolean inDeliveryArea) {
		this.inDeliveryArea = inDeliveryArea;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
}

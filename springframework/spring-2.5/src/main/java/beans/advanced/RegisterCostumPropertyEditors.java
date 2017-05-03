package beans.advanced;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.advanced.beans.Contact;

public class RegisterCostumPropertyEditors {

	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("registering-custom-property-editors.xml");
		Contact contact = (Contact)ctx.getBean("contact");
		System.out.println(contact.getPhoneNumber().getAreaCode()
				+ "#" +
				contact.getPhoneNumber().getPrefix()
				+ "#" +
				contact.getPhoneNumber().getNumber()
				);
	}

}

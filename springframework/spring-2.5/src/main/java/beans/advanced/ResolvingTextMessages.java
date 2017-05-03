package beans.advanced;

import java.util.Locale;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ResolvingTextMessages {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("resolving-text-messages.xml");

		System.out.println(
				ctx.getMessage("text.title",new Object[0],Locale.ENGLISH)
		);
		
		System.out.println(
				ctx.getMessage("text.title",new Object[0],null)
		);
	}

}

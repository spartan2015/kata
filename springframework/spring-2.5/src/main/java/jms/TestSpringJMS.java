package jms;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringJMS {

	
	public static void main(String[] args) {
	
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jms/jms.xml");
		
		SpringSend ss = (SpringSend)ctx.getBean("springSend");
		SpringReceive sr = (SpringReceive)ctx.getBean("springReceive");
		
		
		
		
		
		ss.sendMessage("hello");
		
		//String s = sr.receiveMessage(); // will block man
		
		//System.out.println(s);

	}

}

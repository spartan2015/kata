package beans.advanced;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.advanced.beans.ConfigurableClass;

public class InjectingNonSpringBeans {

		
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("injecting-non-spring-beans.xml");
		
		ConfigurableClass c = new ConfigurableClass();
		System.out.println(c.getStr());
		
	}

}

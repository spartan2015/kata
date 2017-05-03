package springframework;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class T1SimpleContainer {

	@Test
	public void test() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");

		assertEquals("Hello World!", obj.getMessage());
		
		// graceful shutdown in non web applications:
		((ClassPathXmlApplicationContext)context).registerShutdownHook();
	}

}

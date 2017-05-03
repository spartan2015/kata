package org.spring.java.configuration;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.spring.java.HelloWorld;
import org.spring.java.springconfig.App;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {

	@Test
	public void initApp() {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);

		HelloWorld bean = ctx.getBean(HelloWorld.class);
		assertEquals("Hello World!", bean.getMessage());
		
		
	}
}

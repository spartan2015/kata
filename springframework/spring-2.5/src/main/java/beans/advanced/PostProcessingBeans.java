package beans.advanced;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PostProcessingBeans {

	
	public static void main(String[] args) {
	
		ApplicationContext ctx = new ClassPathXmlApplicationContext("post-processing-beans.xml");

	}

}

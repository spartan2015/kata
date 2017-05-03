package beans.start;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import beans.start.beans.SuperMan;

public class SimpleBeanFactory {

	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("basic-beans.xml");
		
		SuperMan superMan = (SuperMan)ctx.getBean("superMan");
		superMan.doSuperThing();
		superMan.doSuperThing();
		
		
		//XmlBeanFactory ctx2 = new XmlBeanFactory(new ClassPathResource("basic-beans.xml")); // same as above but with longe syntax
		
	}

}

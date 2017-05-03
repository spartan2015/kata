package beans.advanced;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.advanced.beans.Magician;
import beans.start.beans.SuperMan;

public class SimpleAdvancedFactory {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("advanced-wiring.xml");
		
		SuperMan superMan = (SuperMan)ctx.getBean("superMan");
		superMan.doSuperThing();
		
		Magician magician = (Magician)ctx.getBean("magician");
		System.out.println(magician.getContents());
		
		
		Magician magicianReplaced = (Magician)ctx.getBean("magicianReplaced");
		System.out.println(magicianReplaced.getContents());
		
		System.out.println(magicianReplaced.getterStyleInjection());
	}

}

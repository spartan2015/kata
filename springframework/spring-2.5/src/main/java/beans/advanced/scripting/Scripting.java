package beans.advanced.scripting;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.advanced.scripting.beans.ICoconut;
import beans.advanced.scripting.interfaces.Lime;

public class Scripting {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("scripting.xml");
		
		Lime lime = (Lime)ctx.getBean("lime");
		System.out.println(lime.drink());
				
		Lime groovyLime = (Lime)ctx.getBean("groovyLime");
		System.out.println(groovyLime.drink());
		
		Lime beanShellLime = (Lime)ctx.getBean("beanShellLime");
		System.out.println(beanShellLime.drink());
		
		ICoconut coconut = (ICoconut)ctx.getBean("coconut");
		coconut.drinkThem();
	}
}

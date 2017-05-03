package beans.advanced.contextAwareness;

import org.springframework.beans.factory.BeanNameAware;

public class BeanNameAwareClass implements BeanNameAware{

	public void setBeanName(String name) {
		System.out.println(name);
		
	}

}

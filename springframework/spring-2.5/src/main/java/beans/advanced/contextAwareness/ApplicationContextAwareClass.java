package beans.advanced.contextAwareness;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextAwareClass implements ApplicationContextAware{

	private ApplicationContext ctx;
	
	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		this.ctx = ctx;		
	}

}

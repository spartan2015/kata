package beans.advanced.postProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class PostProcessor implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("Created Bean: " + beanName + " of type: "
				+ bean.getClass() + " with string representation: "
				+ bean.toString());
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("Bean wired: " + beanName + " of type: "
				+ bean.getClass() + " with string representation: "
				+ bean.toString());
		return bean;
	}

}

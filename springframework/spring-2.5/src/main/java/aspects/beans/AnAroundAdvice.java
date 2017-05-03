package aspects.beans;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AnAroundAdvice implements MethodInterceptor {

	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		Object object = null;
		System.out.println("Before Advice");
		try{
			object = methodInvocation.proceed();
			
			System.out.println("After advice");
			
		}catch(Exception ex){
			System.out.println("Exception Advice");
		}
		
		return object;
	}

}

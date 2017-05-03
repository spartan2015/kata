package aspects.beans;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

public class AnAspectPojo implements MethodBeforeAdvice,AfterReturningAdvice,ThrowsAdvice {
	
	public void before(Method method, Object[] args, Object targert){
		System.out.println("Before advice");
	}
	
	public void afterReturning(Object returnValue, Method method, Object[] arguments,
			Object target) throws Throwable {
		System.out.println("After advice");
		
	}	
	
	public void afterThrowing(Throwable throwable){
		System.out.println("Exception Advice");
	}
	
}

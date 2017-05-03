package aspects.beans;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectJAnnotatedAspect {

	@Pointcut("execution(* *.perform(..))")
	public void performance(){} // THIS DEFINES A POINTCUT - yep stupid method but the name is important
	
	@Before("performance()")
	public void before(){
		System.out.println("Before advice - @Before");
	}
	
	@AfterReturning("performance()")
	public void afterReturning(){
		System.out.println("after returning advice @AfterReturning");
	}
	
	@AfterThrowing("performance()")
	public void afterThrowing(){
		System.out.println("after thoring advice @AfterThrowing");
	}

	@Around("performance()")
	public void around(ProceedingJoinPoint joinPoint){
		System.out.println("Before @Around");
		try{
			
			joinPoint.proceed();
			
			System.out.println("AfterReturning @Arounf");			
		}catch(Throwable ex){
			System.out.println("Exception @Around");
		}
	}
}

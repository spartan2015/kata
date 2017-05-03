package springframework;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LogAdvisor {

	@Before("public * get*(..)")
	void before(JoinPoint point, Object service) {
		System.out.println("LogAdvisor.before " + point.toShortString());
	}

	@After("public * *(..)")
	void after(JoinPoint point,Object service) {
		System.out.println("LogAdvisor.after " + point.toShortString());
	}

	@AfterReturning("public * *(..)")
	void afterReturning(JoinPoint point,Object returnedValue,Object service) {
		System.out.println("LogAdvisor.afterReturning: " + returnedValue);
	}

	@AfterThrowing("public * *(..)")
	void afterThrowing(JoinPoint point,Exception exception, Object service) {
		System.out.println("LogAdvisor.afterThrowing " + point.toShortString());
	}

	@Around("public * *(..)")
	Object around(ProceedingJoinPoint call, Object service) {
		System.out.println("LogAdvisor.around before: " + call.toShortString());
		try {

			Object returned = call.proceed();

			System.out.println("LogAdvisor.around afterReturning" + call.toShortString());

			return returned;

		} catch (Throwable e) {
			System.out.println("LogAdvisor.around afterThrowing" + call.toShortString());
			return null;
		} finally {
			System.out.println("LogAdvisor.around finally" + call.toShortString());
		}
	}

}

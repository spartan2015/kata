package com.fortech.java;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAdvisor {

	public void before(Object service) {		
		System.out.println("before " );
	}

	public void after(Object service) {
		System.out.println("after");
	}

	public void doAccessCheck(Object retVal, Object service) {
		System.out.println(" returned: " + retVal);
	}

	public Object doBasicProfiling(ProceedingJoinPoint pjp, Object service) throws Throwable {
		long start = System.currentTimeMillis();

		Object retVal = pjp.proceed();

		long stop = System.currentTimeMillis();

		System.out.println(pjp.toLongString() + " duration: " + (stop - start));

		return retVal;
	}

	public void doRecoveryActions(Exception exception, Object service) {
		System.out.print("exception " + exception);
	}
}

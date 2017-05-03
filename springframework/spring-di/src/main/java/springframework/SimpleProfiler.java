package springframework;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class SimpleProfiler {

	@Around("* *(..)")
	public Object profile(ProceedingJoinPoint call, Object service) throws Throwable {
		StopWatch clock = new StopWatch("Profiling for '" + call.toShortString()+ "'");
		try {
			clock.start(call.toShortString());
							
			Object returned = call.proceed();
			
			return returned;
			
		} finally {
			clock.stop();
			System.out.println(clock.prettyPrint());
		}
	}
}
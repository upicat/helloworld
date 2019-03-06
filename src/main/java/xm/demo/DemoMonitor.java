package xm.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoMonitor {

	// @AfterReturning("execution(public * xm..*Demo.*(..))")
	// public void logServiceAccess(JoinPoint joinPoint) {
	// System.out.println("Completed: " + joinPoint.toShortString() );
	// }

	@Around("execution(public * xm..*Demo.*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		long s = System.currentTimeMillis();
		Object obj = pjp.proceed();
		long e = System.currentTimeMillis();
		System.out.println("Completed: " + pjp.toShortString() + " in " + (e - s) + "ms");
		return obj;
	}
}
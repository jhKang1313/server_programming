package sample1_4_1120;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class LoggingAdvice implements MethodInterceptor{
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String name = invocation.getMethod().getName();
		
		System.out.println("[LOG] " + name + " is calling");
		StopWatch sw = new StopWatch();
		sw.start(name);
		Object obj = invocation.proceed();
		sw.stop();
		System.out.println("[LOG] " + name + " was called");
		System.out.println("처리시간 : " + sw.getTotalTimeMillis() / 1000 + "sec.");
		return obj;
	}

}

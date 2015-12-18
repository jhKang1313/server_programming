package aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor{
	public Object invoke(MethodInvocation invocation) throws Throwable {

		System.out.println("함수 시작");
		Object obj = invocation.proceed();
		System.out.println("함수 끝");
		return obj;
	}

}

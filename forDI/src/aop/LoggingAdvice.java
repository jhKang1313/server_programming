package aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor{
	public Object invoke(MethodInvocation invocation) throws Throwable {

		System.out.println("�Լ� ����");
		Object obj = invocation.proceed();
		System.out.println("�Լ� ��");
		return obj;
	}

}

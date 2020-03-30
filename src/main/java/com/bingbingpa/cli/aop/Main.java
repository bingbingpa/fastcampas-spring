package com.bingbingpa.cli.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;

public class Main {
	public static void main(String...arcgs) {
		ProxyFactory factory = new ProxyFactory(new SimplePojo());
		factory.addInterface(Pojo.class);
		factory.addAdvice(new RetryAdvice());
		
		Pojo pojo = (Pojo) factory.getProxy();
		pojo.foo();
	}
}

class RetryAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		return invocation.proceed();
	}
	
}

interface Pojo {
	void foo();
}

class SimplePojo implements Pojo {
	
	public void foo() {
		System.out.println("run foo");
	}
}

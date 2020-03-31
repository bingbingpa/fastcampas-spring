package com.bingbingpa.cli.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.hibernate.validator.cfg.context.ContainerElementConstraintMappingContext;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
	public static void main(String...args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		Service bean = context.getBean(Service.class);
		bean.log();
		context.close();
//		ProxyFactory factory = new ProxyFactory(new SimplePojo());
//		factory.addInterface(Pojo.class);
//		factory.addAdvice(new RetryAdvice());
//		Pojo pojo = (Pojo) factory.getProxy();
//		pojo.foo();
	}
}

class RetryAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("before");
		Object proceed = invocation.proceed();
		System.out.println("after");
		
		return proceed;
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

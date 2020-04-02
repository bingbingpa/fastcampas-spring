package com.bingbingpa.cli.temp.aop;

import java.sql.Connection;
import java.sql.SQLException;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bingbingpa.cli.dao.MemberDao;


public class Main {
	public static void main(String...args) throws SQLException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		createTable(context.getBean(Connection.class));
		MemberDao bean = context.getBean(MemberDao.class);
//		bean.insert();
		bean.print();
//		bean.log();
//		context.close();
//		ProxyFactory factory = new ProxyFactory(new SimplePojo());
//		factory.addInterface(Pojo.class);
//		factory.addAdvice(new RetryAdvice());
//		Pojo pojo = (Pojo) factory.getProxy();
//		pojo.foo();
	}
	
	public static void createTable(Connection connection) throws SQLException {
		connection.createStatement()
			.execute("create table member (id int auto_increment,username varchar(255) not null,password varchar(255) not null,primary key(id))"	);
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

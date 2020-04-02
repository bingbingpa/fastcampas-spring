 package com.bingbingpa.cli.temp.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String...args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");
		// 관계를 설정으로 빼고 비즈니스 로직에 더 집중 할 수 있다.
		A a = context.getBean("a", A.class);
		a.print();
	}
}

package com.bingbingpa.cli.temp.res;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String...args) throws IOException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ResourceExample.class);
		context.refresh();
		ResourceExample re = context.getBean(ResourceExample.class);
		re.print();
		context.close();
	}
}

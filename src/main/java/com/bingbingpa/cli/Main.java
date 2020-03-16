package com.bingbingpa.cli;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

/**
 * Hello world!
 *
 */
@Slf4j
public class Main {
	public static void main(String[] args) {
		log.info("Hello World!");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");
		log.info("context ====== {} " , context);
		Dao dao = context.getBean(Dao.class);
		dao.run();
	}
}

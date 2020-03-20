package com.bingbingpa.cli;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

/**
 * Hello world!
 *
 */
@Slf4j
public class Main {
	public static void main(String[] args) throws SQLException {
		log.info("Hello World!");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");
		Dao dao = context.getBean("dao", Dao.class);
		dao.run();
	}
}

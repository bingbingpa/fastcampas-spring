package com.bingbingpa.cli;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.bingbingpa.cli.aop.TransactionBean;

import lombok.extern.slf4j.Slf4j;

/**
 * Hello world!
 *
 */
@Slf4j
@Configuration
@ComponentScan(basePackageClasses = Main.class, excludeFilters = @Filter(type = FilterType.REGEX, pattern = "com.bingbingpa.cli.B"))
public class Main {
	public static void main(String[] args) throws SQLException {
		log.info("Hello World!");
//		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.register(TransactionBean.class);
		context.refresh();
		
		createTable(context.getBean(Connection.class));
		
		Dao dao = context.getBean(Dao.class);
		dao.insert();
		dao.print();
//		MyService dao = context.getBean(MyService.class);
//		dao.check();
		context.close();
	}
	
	public static void createTable(Connection connection) throws SQLException {
		connection.createStatement()
			.execute("create table member (id int auto_increment,username varchar(255) not null,password varchar(255) not null,primary key(id))"	);
	}
}

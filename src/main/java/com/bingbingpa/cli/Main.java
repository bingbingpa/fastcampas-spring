package com.bingbingpa.cli;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.bingbingpa.cli.service.MyService;

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
		context.refresh();
		MyService dao = context.getBean(MyService.class);
		dao.check();
		context.close();
	}
}

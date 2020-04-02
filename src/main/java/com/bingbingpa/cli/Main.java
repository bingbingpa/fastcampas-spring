package com.bingbingpa.cli;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.bingbingpa.cli.config.AppConfig;
import com.bingbingpa.cli.controller.MemberController;
import com.bingbingpa.cli.temp.TransactionBean;

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
		
		createTable(context.getBean(DataSource.class).getConnection());
		
		System.out.println("=================== 사용자의 username, password를 입력해주세요. =================");
		Scanner scanner = new Scanner(System.in);
		System.out.println("username: ");
		String username = scanner.nextLine();
		System.out.println("password:");
		String password = scanner.nextLine();
		
		MemberController controller = context.getBean(MemberController.class);
		controller.insert(username, password);
		controller.print();
//		MemberDao dao = context.getBean(MemberDao.class);
//		dao.insert();
//		dao.print();
//		MyService dao = context.getBean(MyService.class);
//		dao.check();
		context.close();
	}
	
	public static void createTable(Connection connection) throws SQLException {
		connection.createStatement()
			.execute("create table member (id int auto_increment,username varchar(255) not null,password varchar(255) not null,primary key(id))"	);
	}
}

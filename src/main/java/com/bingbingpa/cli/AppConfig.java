package com.bingbingpa.cli;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.bingbingpa.cli.service.MyService;

@Configuration
@Profile("default | dev") // 배열로 넣어도 가능 : {"default", "dev"}
@PropertySource("classpath:application-${spring.profiles.active}.properties")
public class AppConfig {
	
	@Bean
	public B b () {
		return new B();
	}

	@Bean(initMethod = "init", destroyMethod = "destroy")
	public A a(B b) {
		return new A(b);
	}
	
	@Bean
	public Connection connection(ConnectionFactory connectionFactory) throws SQLException {
		return connectionFactory.getConnection();
	}
	
	@Bean
	public Dao dao(Connection connection) {
		return new Dao(connection);
	}
	
	@Bean(initMethod = "init", destroyMethod = "destroy")
	public ConnectionFactory connectionFactory(
			@Value("${jdbc.driver-name}") String driverClass,
			@Value("${jdbc.url}") String url,
			@Value("${jdbc.username}") String username,
			@Value("${jdbc.password}") String password) {
		
		return new ConnectionFactory(driverClass, url, username, password);
	}
	
	@Bean
	public LocalValidatorFactoryBean localValidatorFactoryBean() {
		return new LocalValidatorFactoryBean();
	}
	
	@Bean
	public MyService myService() {
		return new MyService();
	}
}

package com.bingbingpa.cli;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("default | dev") // 배열로 넣어도 가능 : {"default", "dev"} 
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
}

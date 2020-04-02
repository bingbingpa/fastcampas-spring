package com.bingbingpa.cli.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bingbingpa.cli.controller.MemberController;
import com.bingbingpa.cli.dao.MemberDao;
import com.bingbingpa.cli.service.MemberService;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
//@Profile("default | dev") // 배열로 넣어도 가능 : {"default", "dev"}
//@PropertySource("classpath:application-${spring.profiles.active}.properties")
@PropertySource("classpath:application-default.properties")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class AppConfig {
	
	@Bean 
	public DataSource dataSource(
			@Value("${jdbc.driver-name}") String driverClass,
			@Value("${jdbc.url}") String url,
			@Value("${jdbc.username}") String username,
			@Value("${jdbc.password}") String password) {
		
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(driverClass);
		config.setJdbcUrl(url);
		config.setUsername(username);
		config.setPassword(password);

		return new HikariDataSource(config);
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public MemberDao dao(JdbcTemplate jdbcTemplate) {
		return new MemberDao(jdbcTemplate);
	}
	
	@Bean
	public MemberService service(MemberDao dao) { return new MemberService(dao); }
	
	@Bean
	public MemberController controller(MemberService service) { return new MemberController(service); }
	
	@Bean
	public PlatformTransactionManager platformTransactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
		
	}
	
//	@Bean
//	public B b () {
//		return new B();
//	}
//
//	@Bean(initMethod = "init", destroyMethod = "destroy")
//	public A a(B b) {
//		return new A(b);
//	}
//	
//	@Bean
//	public Connection connection(ConnectionFactory connectionFactory) throws SQLException {
//		return connectionFactory.getConnection();
//	}
//	
//	@Bean
//	public Dao dao(Connection connection) {
//		return new Dao(connection);
//	}
//	
//	@Bean(initMethod = "init", destroyMethod = "destroy")
//	public ConnectionFactory connectionFactory(
//			@Value("${jdbc.driver-name}") String driverClass,
//			@Value("${jdbc.url}") String url,
//			@Value("${jdbc.username}") String username,
//			@Value("${jdbc.password}") String password) {
//		
//		return new ConnectionFactory(driverClass, url, username, password);
//	}
//	
//	@Bean
//	public LocalValidatorFactoryBean localValidatorFactoryBean() {
//		return new LocalValidatorFactoryBean();
//	}
//	
//	@Bean
//	public MyService myService() {
//		return new MyService();
//	}
}

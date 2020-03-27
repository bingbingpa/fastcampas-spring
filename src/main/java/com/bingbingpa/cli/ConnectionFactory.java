package com.bingbingpa.cli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConnectionFactory {
	
	private String driverClass;
	private String url;
	private String user;
	private String password;
	@Getter private Connection connection = null;
	
	public ConnectionFactory(String driverClass, String url, String user, String password) {
		this.driverClass = driverClass;
		this.url = url;
		this.user = user;
		this.password = password;
	}


	public Connection createConnection() throws SQLException {
		try {
			Class.forName(this.driverClass);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return DriverManager.getConnection(this.url, this.user, this.password); 
	}
	
	public void init() throws SQLException {
		log.info("init");
		this.connection = createConnection();
	}
	
	public void destroy() throws SQLException {
		log.info("destroy");
		if(this.connection != null) {
			this.connection.close();
		}
	}
}

package com.bingbingpa;

import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;

/**
 * Hello world!
 *
 */
public class App  {
	private static Logger logger = LoggerFactory.getLogger(App.class);
    public static void main( String[] args ) {
        logger.info( "Hello World!" );
        
         Connection connection = null;
         Statement statement = null;
        try {
			Class.forName("org.h2.Driver");
			String url = "jdbc:h2:mem:test;MODE=MySQL";
			connection = DriverManager.getConnection(url, "sa", "");
			statement = connection.createStatement();
			connection.setAutoCommit(false);
			
			statement.execute("create table member (id int auto_increment,username varchar(255) not null,password varchar(255) not null,primary key(id))");
			
			statement.executeUpdate("insert into member(username, password) values('bingbingpa','1234')");
//			if(true) throw new RuntimeException("sql error");
			ResultSet resultSet = statement.executeQuery("select id, username, password from member");
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				
				logger.info("id = {}, username = {}, password = {}", id, username, password );
			}
			
			connection.commit();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try { 
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try { 
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    }
}

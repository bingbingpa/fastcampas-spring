package com.bingbingpa.cli;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App  {
	private static Logger logger = LoggerFactory.getLogger(App.class);
    public static void main( String[] args ) throws ClassNotFoundException {
        logger.info( "Hello World!" );
        
         Class.forName("org.h2.Driver");
         var url = "jdbc:h2:mem:test;MODE=MySQL";
        try(var connection = DriverManager.getConnection(url, "sa", "");
    		var statement = connection.createStatement())  {
			connection.setAutoCommit(false);
			statement.execute("create table member (id int auto_increment,username varchar(255) not null,password varchar(255) not null,primary key(id))");
			try {
				statement.executeUpdate("insert into member(username, password) values('bingbingpa','1234')");
				connection.commit();
			} catch (SQLException e) {
				connection.rollback();
			}
//			if(true) throw new RuntimeException("sql error");
			var resultSet = statement.executeQuery("select id, username, password from member");
			while(resultSet.next()) {
				var member = new Member(resultSet);
				logger.info("member ======{} " , member.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
    }
}

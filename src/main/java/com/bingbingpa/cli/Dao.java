package com.bingbingpa.cli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Dao {
	private Connection connection;
	
	public Dao(Connection connection) {
		this.connection = connection;
	}
	
	public void run() throws SQLException {
		var statement = connection.createStatement();
		connection.setAutoCommit(false);
		statement.execute(
				"create table member (id int auto_increment,username varchar(255) not null,password varchar(255) not null,primary key(id))");
		try {
			statement.executeUpdate("insert into member(username, password) values('bingbingpa','1234')");
			connection.commit();
		} catch (SQLException e) {
			connection.rollback();
		}
//			if(true) throw new RuntimeException("sql error");
		var resultSet = statement.executeQuery("select id, username, password from member");
		while (resultSet.next()) {
			var member = new Member(resultSet);
			log.info("member ======{} ", member.toString());
		}
	}
}

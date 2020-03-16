package com.bingbingpa.cli;

import java.sql.DriverManager;
import java.sql.SQLException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Dao {
	public void run() {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		var url = "jdbc:h2:mem:test;MODE=MySQL";
		try (var connection = DriverManager.getConnection(url, "sa", "");
				var statement = connection.createStatement()) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

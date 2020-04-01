package com.bingbingpa.cli;

import java.sql.Connection;
import java.sql.SQLException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Dao {
	private Connection connection;
	
	public Dao(Connection connection) {
		this.connection = connection;
	}
	
	public void insert() throws SQLException {
		var statement = connection.createStatement();
		statement.executeUpdate("insert into member(username, password) values('bingbingpa','1234')");
	}
	
	public void print() throws SQLException {
		var statement = connection.createStatement();
		var resultSet = statement.executeQuery("select id, username, password from member");
		while (resultSet.next()) {
			var member = new Member(resultSet);
			log.info("member ======{} ", member.toString());
		}
	}
}

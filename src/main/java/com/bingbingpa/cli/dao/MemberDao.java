package com.bingbingpa.cli.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.bingbingpa.cli.entity.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemberDao {
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Transactional
	public void insert(String username, String password) throws SQLException {
//		var statement = DataSourceUtils.getConnection(dataSource).createStatement();
//		statement.executeUpdate("insert into member(username, password) values('bingbingpa','1234')");
		jdbcTemplate.update("insert into member(username, password) values(?,?)", username, password);
	}
	
	public void print() throws SQLException {
//		var statement = DataSourceUtils.getConnection(dataSource).createStatement();
//		var resultSet = statement.executeQuery("select id, username, password from member");
//		while (resultSet.next()) {
//			var member = new Member(resultSet);
//			log.info("member ======{} ", member.toString());
//		}
		List<Member> list = jdbcTemplate.query("select id, username, password from member", 
				(resultSet, i) -> new Member(resultSet));
		list.forEach(x -> log.info("member ==== {}, {} " , x.getUsername(), x.getPassword()));
	}
}

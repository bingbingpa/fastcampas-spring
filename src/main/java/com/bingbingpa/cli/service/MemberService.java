package com.bingbingpa.cli.service;

import java.sql.SQLException;

import org.springframework.transaction.annotation.Transactional;

import com.bingbingpa.cli.dao.MemberDao;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MemberService {
	private MemberDao memberDao;
	
	@Transactional
	public void insert(String username, String password) throws SQLException {
		memberDao.insert(username, password);
	}
	
	public void print() throws SQLException {
		memberDao.print();
	}
}

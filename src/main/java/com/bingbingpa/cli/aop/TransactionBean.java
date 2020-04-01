package com.bingbingpa.cli.aop;

import java.sql.Connection;
import java.sql.SQLException;

import org.aspectj.lang.ProceedingJoinPoint;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TransactionBean {
	private Connection connection;
	
	public TransactionBean(Connection connection) {
		this.connection = connection;
	}

	public Object aroundTransaction(ProceedingJoinPoint pjp) throws SQLException {
		log.error(">>> before aop transaction");
		try {
			Object proceed = pjp.proceed();
			log.error(">> returning aop transaction");
			connection.commit();
			
			return proceed;
			
		} catch(Throwable throwable) {
			log.error(">> throwing aop transaction");
			connection.rollback();
		}
		log.error(">>> after aop log");
		return null;
	}
	
	public void beforeLog() {
		log.error(">>>> before aop log");
	}
	
	public void afterLog() {
		log.error(">>>> after aop log");
	}
	
	public void afterReturningLog() {
		log.error(">>>> afterReturning aop log");
	}
	
	public void afterThrowingLog() {
		log.error(">>>> afterThrowing aop log");
	}
}

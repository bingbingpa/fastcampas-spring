package com.bingbingpa.cli.aop;

import org.aspectj.lang.ProceedingJoinPoint;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AopBean {
	
	public void aroundLog(ProceedingJoinPoint pjp) {
		log.error(">>> before aop log");
		try {
			Object proceed = pjp.proceed();
			log.error(">> returning aop log");
		} catch(Throwable throwable) {
			log.error(">> throwing aop log");
		}
		log.error(">>> after aop log");
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

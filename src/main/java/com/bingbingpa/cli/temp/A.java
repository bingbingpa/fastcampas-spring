package com.bingbingpa.cli.temp;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class A {
	@Resource private B b;
	
	
	public A(B b) {
		super();
		this.b = b;
	}

	@PostConstruct
	void init() {
		log.info("A post construct");
	}
	
	@PreDestroy
	void destroy() { log.info("A pre destroy"); }
	
}

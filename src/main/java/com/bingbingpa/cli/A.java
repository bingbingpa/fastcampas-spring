package com.bingbingpa.cli;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class A {
	@Resource private B b;
//	@Autowired private ApplicationContext context;
//	@Value("#{systemProperties['hello']") String property;
	
	@PostConstruct
	void init() {
		log.info("A post construct");
	}
	
	@PreDestroy
	void destroy() { log.info("A pre destroy"); }
	
}

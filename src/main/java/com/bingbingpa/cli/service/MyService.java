package com.bingbingpa.cli.service;

import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bingbingpa.cli.validation.PersonForm;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MyService {
	
	@Autowired
	private Validator validator;
	
	public void check() {
		// locale 설정에 따라 메시지 언어가 변경된다.
		Locale.setDefault(Locale.ENGLISH);
		PersonForm personForm = new PersonForm("testttt", -1);
		Set<ConstraintViolation<PersonForm>> result = validator.validate(personForm);
		if(result.isEmpty()) {
			log.info("validate 성공");
		} else {
			log.info("validate 실패");
			result.forEach(x -> {
				log.error("error message ===== {} " , x.getMessage());
			});
		}
	}
}

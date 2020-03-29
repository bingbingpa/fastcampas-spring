package com.bingbingpa.cli.res;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;

public class Main {
	public static void main(String...args) throws IOException {
		ClassPathResource resource = new ClassPathResource("dao.xml");
		byte[] bytes = resource.getInputStream().readAllBytes();
		String daoStr = new String(bytes);
		System.out.println(daoStr);
	}
}

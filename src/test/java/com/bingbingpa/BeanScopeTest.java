package com.bingbingpa;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

public class BeanScopeTest {
	
	@Test
	void testIdentity() {
		// 동일성(identity): 객체 주소 같다 - (obj1 == obj2 == obj3) == true
		// 동등성(equals): 객체의 값이 같다 - (obj1.equals(obj2)) == true
		
//		A a1 = new A();
//		A a2 = new A();
//		Assert.assertTrue(a1 == a2);
	}
	@Test
	void testEquals() {
		A a1 = new A(10, "hello");
		A a2 = new A(10, "hello");
		A a3 = new A(5, "hello");
		
		Assert.assertTrue(a1.equals(a2));
		Assert.assertFalse(a1.equals(a3));
	}
	
	@AllArgsConstructor
	@EqualsAndHashCode
	class A {
		private int a1;
		private String a2;
	}
}

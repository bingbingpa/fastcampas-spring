package com.bingbingpa.cli.di;

public class A {
	private B b;
	
//	public A(B b) {
//		this.b = b;
//	}
	
	public void setB(B b) {
		this.b = b;
	}
	public void print() {
		System.out.println(b.calc());
	}
}

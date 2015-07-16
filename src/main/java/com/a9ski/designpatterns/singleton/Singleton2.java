package com.a9ski.designpatterns.singleton;

public enum Singleton2 {
	INSTANCE;
		
	private final long id;
	
	private Singleton2() {
		id = System.nanoTime();
	}
	 
	public Long getId() {
		return id;
	}
}

package com.a9ski.designpatterns.singleton;

import java.util.concurrent.atomic.AtomicLong;

public class Singleton1 {
	
	private static volatile Singleton1 instance;
	
	private static volatile Object lock = new Object();
	
	private static final AtomicLong staticId = new AtomicLong(0);
	
	private final long id;
	
	public static Singleton1 getInstance() {
		if (instance == null) {
			synchronized (lock) {
				if (instance == null) {
					instance = new Singleton1();					
				}
			}
		}
		return instance;
	}
	
	private Singleton1() {
		super();
		this.id = staticId.incrementAndGet();
	}
	
	public Long getId() {
		return id;
	}
}

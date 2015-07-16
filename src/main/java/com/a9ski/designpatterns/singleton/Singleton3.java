package com.a9ski.designpatterns.singleton;

import java.util.concurrent.atomic.AtomicLong;

public class Singleton3 {
	
	private static class LazyHolder  {
		public static final Singleton3 INSTANCE = new Singleton3();
	}
	
	public static Singleton3 getInstance() {
		return LazyHolder.INSTANCE;
	}
	
	private static final AtomicLong staticId = new AtomicLong(0);
	private final long id;
		
	private Singleton3() {
		super();
		this.id = staticId.incrementAndGet();
	}
	
	public Long getId() {
		return id;
	}
}

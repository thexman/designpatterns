package com.a9ski.designpatterns.singleton;

import org.junit.Test;

public class Singleton3Test extends AbstractSingletonTest {
	
	@Test
	public void testGetInstance() throws InterruptedException  {
		executeTest();
	}
	
	protected Long getSingletonId() {
		return Singleton3.getInstance().getId();
	}

}

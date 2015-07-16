package com.a9ski.designpatterns.singleton;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class AbstractSingletonTest {
	private final int size = 50;
	
	
	protected void executeTest() throws InterruptedException {
		final CountDownLatch startSignal = new CountDownLatch(1);
		final CountDownLatch doneSignal = new CountDownLatch(size);

		final ExecutorService executor = Executors.newFixedThreadPool(size);
		
		try {
			final Set<Long> singletonIds = Collections.newSetFromMap(new ConcurrentHashMap<>());
			
			for(int i = 0; i < size; i++) {
				executor.execute(createRunnable(startSignal, doneSignal, singletonIds));
			}
			
			// all threads are setup and wating, so signal them to enter getInstance() at the same time
			startSignal.countDown();
			
			doneSignal.await();
			
			assertEquals(1, singletonIds.size());
			assertEquals(getSingletonId(), singletonIds.iterator().next());
		} finally {
			executor.shutdownNow();
		}
	}

	private Runnable createRunnable(final CountDownLatch startSignal, final CountDownLatch doneSignal, final Set<Long> singletonIds) {
		return new Runnable() {
			
			@Override
			public void run() {
				final Set<Long> ids = new HashSet<>();
				try {
					// waits for the signal, so all threads enters getInstance() at the same time
					startSignal.await();
					// repeat it 100 times, so to be sure that we don't create a new instance
					for(int i = 0; i < 100; i++) { 
						ids.add(getSingletonId());
						//System.out.println(Thread.currentThread().getName());
						Thread.sleep(10);
					}
				} catch(InterruptedException ex) {
					// ignore and exit the thread
				} finally {
					singletonIds.addAll(ids);
					doneSignal.countDown();
				}
			}
		};
	}

	protected abstract Long getSingletonId();
}

package com.a9ski.designpatterns.factorymethod;

/**
 * This is a version of "factory method" design pattern with static factory method 
 *
 */
public final class HashAlgorithmFactory {
	
	public static enum Algorithm {
		MD5, SHA256;
	}
	
	private HashAlgorithmFactory() {
		super();
	}
	
	// This is the factory method
	public static HashAlgorithm createAlgorithm(final Algorithm algorithm) {
		final HashAlgorithm hashAlgorithm;
		switch (algorithm) {
			case MD5: hashAlgorithm = new MD5Algorithm(); break;
			case SHA256: hashAlgorithm = new SHA256Algorithm(); break;
			default: hashAlgorithm = null; break;
		}
		return hashAlgorithm;
	}
}

package com.a9ski.designpatterns.factorymethod;

import java.security.GeneralSecurityException;

import org.apache.commons.codec.binary.Hex;

/**
 * This is version of factory method with inheritance
 *
 */
public abstract class HashCalculator {
	
	// this is the factory method
	protected abstract HashAlgorithm createAlgorithm();
	
	public String toHexString(byte[] data) throws GeneralSecurityException {		
		return Hex.encodeHexString(calculateHash(data)).toLowerCase();
	}
	
	public byte[] toByteArray(byte[] data) throws GeneralSecurityException {
		return calculateHash(data).clone();
	}
	
	private byte[] calculateHash(byte[] data) throws GeneralSecurityException {
		final HashAlgorithm calc = createAlgorithm(); // use factory method
		final byte[] hash = calc.calculateHash(data);
		return hash;
	}
}

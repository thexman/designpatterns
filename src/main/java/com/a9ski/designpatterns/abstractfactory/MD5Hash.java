package com.a9ski.designpatterns.abstractfactory;

import org.apache.commons.codec.binary.Hex;

public class MD5Hash implements Hash {

	private final byte[] hash;
	
	protected MD5Hash(byte[] hash) {
		this.hash = hash;
	}
	
	@Override
	public String toHexString() {
		return Hex.encodeHexString(hash).toLowerCase();
	}

	@Override
	public byte[] toByteArray() {
		return hash.clone();
	}
	
	@Override
	public String getAlgorithmName() {
		return "MD5";
	}

}

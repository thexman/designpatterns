package com.a9ski.designpatterns.abstractfactory;

import org.apache.commons.codec.binary.Hex;

public class SHA256Hash implements Hash {

	private final byte[] hash;
	
	protected SHA256Hash(byte[] hash) {
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
		return "SHA-256";
	}

}

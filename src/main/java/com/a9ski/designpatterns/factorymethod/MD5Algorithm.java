package com.a9ski.designpatterns.factorymethod;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Algorithm implements HashAlgorithm {
	
	@Override
	public byte[] calculateHash(byte[] data) throws NoSuchAlgorithmException {
		final MessageDigest md = MessageDigest.getInstance("MD5");
		final byte[] hash = md.digest(data);
		return hash;
	}

}

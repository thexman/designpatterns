package com.a9ski.designpatterns.abstractfactory;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;

public class SHA256HashFactory implements HashFactory {

	@Override
	public Hash createHash(byte[] data) throws GeneralSecurityException {
		final MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] hash = md.digest(data);		
		return new SHA256Hash(hash);
	}

}

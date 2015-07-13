package com.a9ski.designpatterns.abstractfactory;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;

public class MD5HashFactory implements HashFactory {

	@Override
	public Hash createHash(byte[] data) throws GeneralSecurityException {
		final MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] hash = md.digest(data);		
		return new MD5Hash(hash);
	}

}

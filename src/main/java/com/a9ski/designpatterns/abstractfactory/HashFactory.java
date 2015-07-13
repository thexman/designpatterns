package com.a9ski.designpatterns.abstractfactory;

import java.security.GeneralSecurityException;

public interface HashFactory {
	public Hash createHash(byte[] data) throws GeneralSecurityException; 
}

package com.a9ski.designpatterns.abstractfactory;

import java.security.GeneralSecurityException;
import java.util.Comparator;

public interface HashFactory {
	public Hash createHash(byte[] data) throws GeneralSecurityException;
	
	public Comparator<Hash> createHashComparer();
}

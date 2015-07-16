package com.a9ski.designpatterns.factorymethod;

import java.security.GeneralSecurityException;

public interface HashAlgorithm {
	public byte[] calculateHash(byte[] data) throws GeneralSecurityException;
}

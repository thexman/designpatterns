package com.a9ski.designpatterns.abstractfactory;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import org.junit.Test;

public class HashFactoryTest {

	private byte[] data() throws UnsupportedEncodingException {
		return "The quick brown fox jumps over the lazy dog".getBytes("UTF-8");
	}
	
	@Test
	public void testCreateMD5Hash() throws GeneralSecurityException, UnsupportedEncodingException {
		executeTest(new MD5HashFactory(), "MD5", "9e107d9d372bb6826bd81d3542a419d6");
	}
	
	@Test
	public void testCreateSHA256Hash() throws GeneralSecurityException, UnsupportedEncodingException {
		executeTest(new SHA256HashFactory(), "SHA-256", "d7a8fbb307d7809469ca9abcb0082e4f8d5651e46d3cdb762d02d0bf37c9e592");
	}
	
	
	private void executeTest(final HashFactory factory, final String algorithm, final String expectedHash) throws UnsupportedEncodingException, GeneralSecurityException {		
		final Hash hash = factory.createHash(data());
		assertEquals(algorithm, hash.getAlgorithmName());
		assertEquals(expectedHash, hash.toHexString());
	}
	
	

}

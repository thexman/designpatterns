package com.a9ski.designpatterns.factorymethod;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

import com.a9ski.designpatterns.AbstractHashTest;
import com.a9ski.designpatterns.factorymethod.HashAlgorithmFactory.Algorithm;

public class HashCalculatorTest extends AbstractHashTest {

	@Test
	public void testMD5Calculator() throws UnsupportedEncodingException, GeneralSecurityException {
		final HashCalculator calc = new MD5Calculator();
		assertEquals(expectedMD5Hex(), calc.toHexString(data()));
	}
	
	@Test
	public void testSHA256Calculator() throws UnsupportedEncodingException, GeneralSecurityException {
		final HashCalculator calc = new SHA256Calculator();
		assertEquals(expectedSHA256Hex(), calc.toHexString(data()));
	}
	
	@Test
	public void testMD5Algorithm() throws Exception {
		final HashAlgorithm algorithm = HashAlgorithmFactory.createAlgorithm(Algorithm.MD5);
		final String actual = hex(algorithm.calculateHash(data()));
		assertEquals(expectedMD5Hex(), actual);
	}
	
	@Test
	public void testSHA256Algorithm() throws Exception {
		final HashAlgorithm algorithm = HashAlgorithmFactory.createAlgorithm(Algorithm.SHA256);
		final String actual = hex(algorithm.calculateHash(data()));
		assertEquals(expectedSHA256Hex(), actual);
	}
	
	private String hex(byte[] bytes) {
		return Hex.encodeHexString(bytes).toLowerCase();
	}

}

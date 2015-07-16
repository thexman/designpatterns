package com.a9ski.designpatterns.abstractfactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.apache.commons.codec.binary.StringUtils;
import org.junit.Test;

import com.a9ski.designpatterns.AbstractHashTest;

public class HashFactoryTest extends AbstractHashTest {
	
	@Test
	public void testCreateMD5Hash() throws GeneralSecurityException, UnsupportedEncodingException {
		executeTest(new MD5HashFactory(), "MD5", expectedMD5Hex());
	}
		
	@Test
	public void testCreateSHA256Hash() throws GeneralSecurityException, UnsupportedEncodingException {
		executeTest(new SHA256HashFactory(), "SHA-256", expectedSHA256Hex());
	}
	
	private void executeTest(final HashFactory factory, final String algorithm, final String expectedHash) throws UnsupportedEncodingException, GeneralSecurityException {		
		final Hash hash = factory.createHash(data());
		assertEquals(algorithm, hash.getAlgorithmName());
		assertEquals(expectedHash, hash.toHexString());
	}
	
	
	@Test
	public void testHashComparator() throws UnsupportedEncodingException, GeneralSecurityException  {
		final HashFactory md5 = new MD5HashFactory();
		final HashFactory sha256 = new SHA256HashFactory();
		
		final List<Hash> hashes = new ArrayList<>(); 
		for(int i = 0; i < 1024; i++) {
			final byte[] data = utf8(UUID.randomUUID().toString() + String.valueOf(i));
			hashes.add(md5.createHash(data));
			hashes.add(sha256.createHash(data));
		}
		
		Collections.sort(hashes, md5.createHashComparer());		
		checkSorting(hashes, "MD5");
		
		Collections.sort(hashes, sha256.createHashComparer());
		checkSorting(hashes, "SHA-256");		
	}

	private void checkSorting(final List<Hash> hashes, final String algorithmName) {
		for(int i = 1; i < hashes.size(); i++) {
			final Hash prev = hashes.get(i-1);
			final Hash curr = hashes.get(i);
					
			final int cmp;
			final boolean h1 = isHash(prev, algorithmName);			
			final boolean h2 = isHash(curr, algorithmName);
			
			if ( (h1 && h2) || (!h1 && !h2)) {
				cmp = prev.toHexString().compareTo(curr.toHexString());
			} else if (h1 && !h2) {
				cmp = -1 ;
			} else {
				cmp = 1;
			}
			
			assertTrue(cmp <= 0);
		}
	}
	
	private boolean isHash(Hash hash, String algorithmName) {
		return hash != null && StringUtils.equals(algorithmName, hash.getAlgorithmName());
	}
	

}

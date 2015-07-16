package com.a9ski.designpatterns.abstractfactory;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Comparator;

import org.apache.commons.lang3.StringUtils;

public class SHA256HashFactory implements HashFactory {

	@Override
	public Hash createHash(byte[] data) throws GeneralSecurityException {
		final MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] hash = md.digest(data);		
		return new SHA256Hash(hash);
	}

	@Override
	public Comparator<Hash> createHashComparer() {
		return new Comparator<Hash>() {

			@Override
			public int compare(Hash o1, Hash o2) {
				final int res;
				if (o1 == o2) {
					res = 0;
				} else if (o1 == null) {
					res = -1;
				} else if (o2 == null) {
					res = 1;
				} else {
					final boolean sameAlgorithm = StringUtils.equals(o1.getAlgorithmName(), o2.getAlgorithmName());
					final boolean o1IsSha256 = StringUtils.equals("SHA-256", o1.getAlgorithmName());
					final boolean o2IsSha256 = StringUtils.equals("SHA-256", o2.getAlgorithmName());
					final boolean notSha256 = !o1IsSha256 && !o2IsSha256;
					if (sameAlgorithm || notSha256) {
						res = o1.toHexString().compareTo(o2.toHexString());
					} else if (o1IsSha256){
						// o1 is SHA256 so it is smaller
						res = -1;
					} else { 
						// o2 is SHA256 so it is smaller
						res = 1;
					}
				}
				
				return res;
			}			
		};
	}

}

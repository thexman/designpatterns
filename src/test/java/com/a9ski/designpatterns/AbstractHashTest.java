package com.a9ski.designpatterns;

import java.io.UnsupportedEncodingException;

public class AbstractHashTest {
	protected byte[] data() throws UnsupportedEncodingException {
		return utf8("The quick brown fox jumps over the lazy dog");
	}
	
	protected byte[] utf8(String data) throws UnsupportedEncodingException {
		return data.getBytes("UTF-8");
	}
	
	protected String expectedMD5Hex() {
		return "9e107d9d372bb6826bd81d3542a419d6";
	}
	
	protected String expectedSHA256Hex() {
		return "d7a8fbb307d7809469ca9abcb0082e4f8d5651e46d3cdb762d02d0bf37c9e592";
	}

	
}

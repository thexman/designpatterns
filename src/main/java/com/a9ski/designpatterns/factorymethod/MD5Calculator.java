package com.a9ski.designpatterns.factorymethod;

public class MD5Calculator extends HashCalculator {

	@Override
	public HashAlgorithm createAlgorithm() {
		return new MD5Algorithm();
	}

}

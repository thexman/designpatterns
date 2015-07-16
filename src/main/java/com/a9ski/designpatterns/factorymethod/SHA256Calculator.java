package com.a9ski.designpatterns.factorymethod;

public class SHA256Calculator extends HashCalculator {

	@Override
	public HashAlgorithm createAlgorithm() {
		return new SHA256Algorithm();
	}

}

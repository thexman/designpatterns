package com.a9ski.designpatterns.abstractfactory;

public interface Hash {
	public String toHexString();
	public byte[] toByteArray();
	public String getAlgorithmName();
}

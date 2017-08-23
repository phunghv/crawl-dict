package com.phunghv.audiodict;

public enum Language {
	UK("uk"), US("us");

	private String localtion;

	private Language(String localtion) {
		this.localtion = localtion;
	}

	public String getLocaltion() {
		return localtion;
	}
	
}

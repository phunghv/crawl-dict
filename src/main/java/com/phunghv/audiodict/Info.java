package com.phunghv.audiodict;

public class Info {
	private String mp3;
	private String ogg;
	private String ipa;

	public Info(String mp3, String ogg, String ipa) {
		this.mp3 = mp3;
		this.ogg = ogg;
		this.ipa = ipa;
	}

	public String getMp3() {
		return mp3;
	}

	public void setMp3(String mp3) {
		this.mp3 = mp3;
	}

	public String getOgg() {
		return ogg;
	}

	public void setOgg(String ogg) {
		this.ogg = ogg;
	}

	public String getIpa() {
		return ipa;
	}

	public void setIpa(String ipa) {
		this.ipa = ipa;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		// result.append("[");
		result.append(ipa + ", ");
		result.append(mp3 + ", ");
		result.append(ogg); // + "]");
		return result.toString();
	}
}

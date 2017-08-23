package com.phunghv.audiodict;

public class ProcessorFactory {
	public static IProcessor getProcessor(Language language) {
		switch (language) {
		case US:
			return new CambrigdeProcessor();
		case UK:
			return new CambrigdeProcessor();
		default:
			return new CambrigdeProcessor();
		}
	}
}

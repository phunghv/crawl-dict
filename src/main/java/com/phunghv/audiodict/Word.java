package com.phunghv.audiodict;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class Word {
	private String word;
	private Map<Language, Info> infos = new HashMap<Language, Info>();
	private Set<Language> languages = new TreeSet<Language>();

	public Word(String word) {
		this.word = word;
	}

	public Info getInfo(Language language) {
		return infos.get(language);
	}

	public void addLanguage(Language language) {
		this.languages.add(language);
	}

	public String getWord() {
		return word;
	}

	public void loadInfo() {
		for (Language language : languages) {
			IProcessor processor = ProcessorFactory.getProcessor(language);
			Info info = processor.process(word, language);
			if (info != null) {
				infos.put(language, info);
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("");
		result.append(word);
		result.append(",");
		for (Entry<Language, Info> entry : infos.entrySet()) {
			result.append(entry.getValue());
			result.append(",");
		}
		result.append("\n");
		return result.toString();
	}

}

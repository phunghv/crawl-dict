package com.phunghv.audiodict;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CambrigdeProcessor implements IProcessor {
	private static final String BASE_URL = "http://dictionary.cambridge.org/dictionary/english/";

	public Info process(String word, Language language) {
		System.out.println("process " + word + ":" + language);
		Info info = null;
		try {
			String ipa = null;
			String mp3 = null;
			String ogg = null;
			Document doc = Jsoup.connect(BASE_URL + word).get();
			Elements nodes = doc.select(".uk");
			for (Element node : nodes) {
				if (ipa == null && node.hasClass("uk")) {
					Element proun = node.select(".ipa").first();
					if (proun != null) {
						ipa = proun.text();
					}
				}
				if ((mp3 == null || ogg == null) && node.hasClass("audio_play_button")) {
					Element audio = node.select(".audio_play_button").first();
					if (audio != null) {
						mp3 = audio.attr("data-src-mp3");
						ogg = audio.attr("data-src-ogg");
					}
				}
				if (ipa != null && (mp3 != null || ogg != null)) {
					return new Info(mp3, ogg, ipa);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}
}

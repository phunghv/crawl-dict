package com.phunghv.audiodict;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	public static String getName(String word) {

		int len = word.length();
		if (len < 3) {
			return word.charAt(0) + "";
		}
		return word.charAt(0) + "/" + word.charAt(1) + "" + word.charAt(2);
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Start");
		String[] strs = { "question", "go" };
		for (String str : strs) {
			System.out.println(getName(str));
		}

		FileWriter writer = new FileWriter("output.csv");
		Scanner scanner = new Scanner(new File("3000w.txt"));
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			System.out.println("|" + line + "|");
			Word wStr = new Word(line);
			wStr.addLanguage(Language.UK);
			wStr.addLanguage(Language.US);
			wStr.loadInfo();
			System.out.println(wStr);
			writer.write(wStr.toString());
			Language[] l = { Language.US, Language.UK };
			for (Language language : l) {
				Info info = wStr.getInfo(language);
				if (info != null) {
					FileDownloader.download(info.getMp3(), language.toString().toLowerCase() + "/mp3/"
							+ getName(wStr.getWord()) + "/" + wStr.getWord() + ".mp3");
					FileDownloader.download(info.getOgg(), language.toString().toLowerCase() + "/ogg/"
							+ getName(wStr.getWord()) + "/" + wStr.getWord() + ".ogg");
				}
			}
			writer.flush();
		}
		scanner.close();
		writer.close();
		System.out.println("End");
	}
}

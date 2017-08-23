package com.phunghv.audiodict;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class FileDownloader {
	public static void download(String url, String file) {
		try {
			// connectionTimeout, readTimeout = 10 seconds
			FileUtils.copyURLToFile(new URL(url), new File(file), 10000, 10000);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

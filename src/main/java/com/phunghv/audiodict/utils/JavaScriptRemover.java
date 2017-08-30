package com.phunghv.audiodict.utils;

public class JavaScriptRemover implements IRemover {

	public String remove(String content) {
		return content.replaceAll("<script((.|\\n|\\r)*?)script>", "");
	}

	public static void main(String[] args) {
		String test = "  <script type=\"text/javascript\">\r\n"
				+ "                googletag.cmd.push(function() { googletag.display('ad_contentslot_1'); });\r\n"
				+ "                </script> ";

		System.out.println(test);
		System.out.println(new JavaScriptRemover().remove(test));
	}
}

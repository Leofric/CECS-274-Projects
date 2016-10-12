package edu.homework_3;

public class Finder {

	public static boolean find(String text, String str) {
		boolean found = false;
		if (text.length()>=str.length()){
		String test = "";
		for (int i = 0; i < str.length(); i++) {
			if (text.charAt(i) == str.charAt(i)) {
				test += text.charAt(i);
			}
		}

		if (test.equals(str)) {
			found = true;
		} else if (text.length()>str.length()) {
			return find(text.substring(1), str);
		}
		return found;
		}
		else return found;
	}
}
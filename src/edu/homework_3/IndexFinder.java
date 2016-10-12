package edu.homework_3;

public class IndexFinder {

	public static void main(String[] args) {
		String string = "Today, Tuesday, March 22nd is going to be a wonderful day!";
		String str = "2nd";
		String str2 = "wonder";
		String str3 = " day!";

		System.out.println("\"" + str + "\"" + " was found at index " +IndexOf(string, str) );
		System.out.println( "\"" + str2 + "\"" + " was found at index " + IndexOf(string, str2) );
		System.out.println( "\"" + str3 + "\"" + " was found at index "+ IndexOf(string, str3) );
		}
		

	public static int IndexOf(String text, String str) {
		return IndexOf(text, str, 0);
	}

	public static int IndexOf(String text, String str, int start) {
		if (text.length() >= str.length()) {
			String test = "";
			for (int i = 0; i < str.length(); i++) {
				if (text.charAt(i) == str.charAt(i)) {
					test += text.charAt(i);
				}
			}
			if (test.equals(str)) {
				return start;
			} else {
				return IndexOf(text.substring(1), str, start + 1);
			}
		} else
			return -1;
	}
}
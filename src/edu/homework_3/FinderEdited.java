package edu.homework_3;

public class FinderEdited {

	public static boolean find(String text, String str) {
		boolean found = false;
		String test = "";
	//	System.out.println("Now testing substring \"" + str + "\" against \"" + text + "\"");
		for (int i = 0; i < str.length(); i++) {
			if (text.charAt(i) == str.charAt(i)) {
				test += text.charAt(i);
			}
		}
	//	System.out.println("Matched characters are: \"" + test + "\"");
	//	System.out.println("Comparing matched characters \"" + test + "\" to \"" + str + "\"");
		if (test.equals(str)) {
			found = true;
		//	System.out.println("Boolean is: " + found);
			return found;
		} else {
			System.out.println("Substring was not found. Trying again.");
			return find(text.substring(1), str); // <----NEW STUFF HERE
		}
		// System.out.println("Is false here?" + found);
		// System.out.println("Boolean is: " + found);
		// return found;
	}
}

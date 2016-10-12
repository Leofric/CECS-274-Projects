package edu.lab_10;

public class ReverseStringHelper {

	public static void main(String[] args) {
		System.out.println(reverse("Today is wednesday"));
	}

	public static String reverse(String text) {
		return test(text, text.length()-1, "");
	}
	
	private static String test(String text, int index, String solution){
		if (index==0){
			solution += text.charAt(index);
			return solution;
		}
		else{
			solution += text.charAt(index);
			return test(text, index-1, solution);
		}	
	}
}
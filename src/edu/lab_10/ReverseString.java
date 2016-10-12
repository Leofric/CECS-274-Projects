package edu.lab_10;

public class ReverseString {

	public static void main(String[] args) {
		System.out.println(reverse("today is thursday"));
		
	}
		public static String reverse(String text){
			String solution;
			if (text.length() == 1) {return text;}
			else {
				solution = reverse(text.substring(1,text.length())) + text.charAt(0);
				return solution;
			}
		}
	}
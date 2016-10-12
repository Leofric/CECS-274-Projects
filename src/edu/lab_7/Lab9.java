package edu.lab_7;
public class Lab9 {

	public static void main(String[] args) {
		String greeting = "hi";
		System.out.println(countVowels(greeting));
	}
	
	public static int countVowels(String string){
		int numberOfVowels = 0;
		int length = string.length();
		for(int i = 0; i<length; i++){
			char letter = string.charAt(i);
			if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u'){
				numberOfVowels += 1;	
			}
		}
		return numberOfVowels;
		
	}
}

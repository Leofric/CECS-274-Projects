package edu.homework_3;

public class test {

	public static void main(String[] args) {
		

System.out.println(Finder.find("",""));
System.out.println("Expected: true\n");
System.out.println(Finder.find("Mitten","Mit"));
System.out.println("Expected: true\n");
System.out.println(Finder.find("I love my CS courses!"," CS"));
System.out.println("Expected: true\n");
System.out.println(Finder.find("","Cookies."));
System.out.println("Expected: false\n");
System.out.println(Finder.find("Java","Python"));
System.out.println("Expected: false\n");
	}
}

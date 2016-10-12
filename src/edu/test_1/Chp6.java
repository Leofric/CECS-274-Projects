package edu.test_1;
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Chp6 {
//
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		System.out.println("Please enter a whole number");
//		int length = in.nextInt();
//		int[] fubcity = new int[length];
//		System.out.print(Arrays.toString(fubcity));
//	}
//}
//
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * 
 * Usage:
 * wordList = [('hi',5),('there',6),('mom',10),('fred',2),('bill',20)]
 * highCount=20, lowCount=2
 * body=''
 * for word,cnt in pairs:
    body = body + makeHTMLword(word,cnt,highCount,lowCount)
 * box = makeHTMLbox(body)
 * printHTMLfile(box,'testFile')
 * 
 * @author Alvaro Monge alvaro.monge@csulb.edu
 *
 */
public class Chp6 {
   
   public static final int MAX_FONT_SIZE = 96;
   public static final int MIN_FONT_SIZE = 14;
   
   /**
    * Tester program; this code is here just to test and show you how the other methods are used.
    * @param args program arguments not used in this example
    * @throws FileNotFoundException in case the file cannot be created an exception is thrown.
    */
   public static void main(String[] args) throws FileNotFoundException
   {
      String[] words =  {"economy", "foreign", "security", "politics"};
      int[] frequency = { 10, 5, 8, 20};
      int highCount = 20;
      int lowCount = 5;
      
      String body = ""; 
      for (int i=0; i < words.length; i++)
      {
         body = body + makeHTMLWord(words[i], frequency[i], highCount, lowCount);
      }
      String box = makeHTMLBox(body);
      printHTMLFile("test.html", "Testing methods", box);
   }
   
   /**
    * Takes the String returned from makeHTMLbox and wraps a standard html web 
    * page around it. 
    * @param fileName is the name of the file to use (should end with .html)
    * @param pageTitle is the title of the page to use 
    * @param pageBody is the contents of the page
    */
   public static void printHTMLFile(String fileName, String pageTitle, String pageBody) throws FileNotFoundException
   {
      PrintWriter out = new PrintWriter(fileName);
      
      out.println("<!DOCTYPE html >");
      out.println("<html> <head>");
      out.println("<meta charset=\"UTF-8\">");
      out.printf("<title>%s</title>", pageTitle);
      out.println("</head>");
      
      out.println("<body>");
      out.printf("<h1>%s</h1>", pageTitle);
      out.println(pageBody);
      out.println("</body>");
      out.println("</html>");
      out.close();
   }
   
   /**
    * Creates and return a String for an HTML div that has all the words in it. 
    * 
    * @param body is a string with all the font-wrapped words to be displayed
    */
   public static String makeHTMLBox(String body)
   {
      String htmlBody = "<div style=\"width: 800px; background-color: rgb(250,250,250); ";
      htmlBody += "border: 1px grey solid; text-align: center\">" + body + "</div>";
      
      return htmlBody;
   }
   
   /**
    * This method takes a word and wraps it in a font tag with a specific size determined
    * by the frequency of the word. The function takes the word to
    * be wrapped, how many times it occurred in the document, the highest word
    * count and the lowest word count of words being processed (the highest count
    * we are considering for this tag and the lowest). It returns a string that is
    * the word and fontSize between MAX_FONT_SIZE and MIN_FONT_SIZE (two constants in this class,
    * you can change these values to be whatever you like)
    * 
    * @param word the word itself
    * @param frequency the number of times word appears in the document
    * @param high represents the highest frequency in the document
    * @param low represents the lowest frequency in the document
    * @return a String with HTML code to set font size for displaying the word  
    * 
    */
   public static String makeHTMLWord(String word, int frequency, int high, int low)
   {
      float relativeRatio = (frequency-low)/(float)(high-low);
      float fontSize = MAX_FONT_SIZE * relativeRatio + (1-relativeRatio) * MIN_FONT_SIZE;
      
      String cloud = String.format("<span style=\"font-size:%.2fpx;\">%s</span>", fontSize, word);
      return cloud;
   }
   
}

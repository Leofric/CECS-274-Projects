package edu.test_1;
import java.util.ArrayList;
import java.util.Comparator;

public class SortTwoArrays {
		  
	public static void main(String[] args) {
		ArrayList<String> words =  new ArrayList<String>();
		      words.add("economy");
		      words.add("foreign");
		      words.add("security");
		      words.add("politics");

		      ArrayList<Integer> frequencies = new ArrayList<Integer>();
		      frequencies.add(10);
		      frequencies.add(5);
		      frequencies.add(8);
		      frequencies.add(20);
		      
		      System.out.println("BEFORE sorting: ");
		      System.out.println("words: " + words);
		      System.out.println("freqeuencies: " + frequencies);
		      
		      ArrayList<Integer> indexes = new ArrayList<Integer>(frequencies.size());
		      for (int i=0; i < frequencies.size(); i++)
		         indexes.add(i);
		      
		      indexes.sort(new Comparator<Integer>() {
		         @Override
		         public int compare(Integer o1, Integer o2) {
		            return frequencies.get(o2) - frequencies.get(o1);
		         }
		      });

		      System.out.println("AFTER sorting: ");
		      System.out.println("words: " + words);
		      System.out.println("frequencies: " + frequencies);
		      System.out.println("indexes: " + indexes);
		      
		      
		      for (int index : indexes)
		         System.out.printf("%s : %d\n", words.get(index), frequencies.get(index) );
		   }
		}


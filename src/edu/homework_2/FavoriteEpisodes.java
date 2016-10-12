package edu.homework_2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FavoriteEpisodes {

	public static void main(String Args[]) {
		Scanner input = new Scanner(System.in);
		ArrayList<String> favorites = new ArrayList<String>();

		System.out.println("Please enter the directory to the file you wish to scan");
		boolean run = true;
		boolean foundFile = false;
		do {
			try {
				String path = input.next();
				File inputFile = new File(path);
				Scanner fileScanner = new Scanner(inputFile);
				foundFile = true;
				System.out.println("Reading file...\n");
				System.out.println("Please enter your favorite episodes to be saved! enter 'DONE' to finish");

				while (run) {
					fileScanner = new Scanner(inputFile);
					input = new Scanner(System.in);
					String episode = input.nextLine();
					boolean foundEpisode = false;

					if (episode.contains("DONE")) {
						foundEpisode = false;
					}

					while (fileScanner.hasNextLine() && run) {
						String currentLine = fileScanner.nextLine();
						if (currentLine.contains(episode) && episode.length() > 2) {
							foundEpisode = true;
							currentLine = currentLine.substring(5, currentLine.length());
							String temp[] = currentLine.split("  ");
							int counter = 0;
							String first = null;
							String second = null;
							for (int i = 0; i < temp.length; i++) {
								temp[i] = temp[i].trim();
								if (!temp[i].isEmpty() && counter < 2) {
									counter++;
									if (counter == 1) {
										first = temp[i];
									} else
										second = temp[i];
								}
							}
							if (!first.isEmpty() && !second.isEmpty()) {
								first = first + " " + second;
								favorites.add(first);
							}
						}
					}
					if (foundEpisode) {
						System.out.println("Episode was added! \n");
						System.out.println("Enter an episode name or DONE");

					} else if (!foundEpisode && run) {
						if (episode.equals("DONE")) {
							System.out.println("Do you want to add any more episodes(YES/NO)");
						} else
							System.out.println(episode + " was not found. did you mispell it? (YES/NO)");
						if (input.next().contains("NO")) {
							System.out.println("Where would you like to save the current file?");
							String save = input.next();
							try {
								PrintWriter fileWriter = new PrintWriter(save);
								for (int i = 0; i < favorites.size(); i++) {
									//System.out.println(favorites.get(i));
									String temp[] = favorites.get(i).split("\\(");
									String newStuff = "Title:	" + temp[0];

									temp = temp[1].split(" ", 2);
									newStuff = newStuff + "\nSeason: " + temp[0].charAt(0) + "\nEpisode: "+ temp[0].charAt(2) + temp[0].charAt(3);
									temp = temp[1].split("/");
									int calculation = Integer.parseInt(temp[2]) + 1900;
									calculation = 2016 - calculation;

									newStuff = newStuff + "\nFirst Aired: " + calculation + " Years Ago \n";
									fileWriter.println(newStuff);
								}
								fileWriter.close();
								System.out.println("Save completed! goodbye!");
								run = false;
							} catch (IOException e) {
								System.out.println("This path is invalid, program will now exit");
								run = false;
							}
						} else
							System.out.println("Plese re-enter the episode name");
					}
				}

				fileScanner.close();

			} catch (IOException e) {
				System.out.println("this file name does not exist, please try again! (Q to quit)");
				if (input.next().equals("Q")) {
					foundFile = true;
					run = false;
				}
			}
		} while (!foundFile);
		input.close();
	}
}
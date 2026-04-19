//package module5;

/*
*   Christopher Villarreal
*   Module 5 Assignment 2
*
*   Purpose of this Program:
*      This program reads a text file that contains a words and stores them in a TreeSet.
*      It then displays the words in both ascending and descending order, demonstrating the
*      benefits of a TreeSet, such as automatic sorting and elimination of duplicates.
*
*   References:
*      - TreeSet Descending Order: https://www.geeksforgeeks.org/java/treeset-descendingset-method-in-java-with-examples/
*/

import java.io.*;
import java.util.*;

public class AccessSet {

    public static void main(String[] args) {

        String fileName = "collection_of_words.txt";
        TreeSet<String> words = new TreeSet<>();
        int totalWords = 0;
        int uniqueWords = 0;

        try {
            File file = new File(fileName);
            Scanner input = new Scanner(file);

            while (input.hasNext()) {
                String word = input.next();
                totalWords++;
                words.add(word);
            }

            input.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }

        // Ascending order
        System.out.println("Displaying [Words] in Ascending Order:");
        for (String word : words) {
            System.out.println("\t" + word);
        }

        // Descending order
        System.out.println("\nWords in Descending Order:");
        NavigableSet<String> wordsReversed = words.descendingSet(); // Utilized GeekForGeeks from references
        for (String word : wordsReversed) {
            System.out.println("\t" + word);
        }

        uniqueWords = words.size();
        System.out.println("\nThere were " + uniqueWords + " out of " +
                totalWords + " words that were not duplicates.");
    }
}
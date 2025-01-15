package day5.q1;

import java.io.*;
import java.util.*;
import java.io.FileReader;

public class WordFreq {




    public static void main(String[] args) {
        File inputFile = new File("story.txt");
        Map<String, Integer> wordFrequency = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into words using spaces as delimiters
                String[] words = line.split("\\s+");

                for (String word : words) {
                    word = word.toLowerCase().replaceAll("[^a-zA-Z]", "");  // Convert to lowercase and remove punctuation
                    if (!word.isEmpty()) {
                        wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                    }
                }
            }

            // Print the word frequencies
            System.out.println("Word Frequencies:");
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}

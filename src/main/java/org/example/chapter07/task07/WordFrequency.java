package org.example.chapter07.task07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class WordFrequency {
    public static TreeMap<String, Integer> wordFrequency(String filename) throws FileNotFoundException {
        TreeMap<String, Integer> counts = new TreeMap<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNext()) {
                String word = scanner.next()
                        .toLowerCase()
                        .replaceAll("[^\\p{L}\\p{N}]+", "");
                if (!word.isEmpty()) {
                    counts.merge(word, 1, Integer::sum);
                }
            }
        }
        return counts;
    }

    static void main() throws Exception {
        TreeMap<String, Integer> counts = wordFrequency(
                "src/main/java/org/example/chapter07/task07/words.txt");

        counts.forEach((word, count) -> System.out.println(word + ": " + count));
    }
}

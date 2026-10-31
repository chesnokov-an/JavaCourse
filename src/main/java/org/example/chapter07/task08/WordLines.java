package org.example.chapter07.task08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class WordLines {
    public static Map<String, Set<Integer>> wordLines(String filename) throws FileNotFoundException {
        Map<String, Set<Integer>> result = new TreeMap<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            int lineNumber = 0;
            while (scanner.hasNextLine()) {
                lineNumber++;
                String line = scanner.nextLine();
                for (String word : line.split("\\s+")) {
                    String key = word.toLowerCase().replaceAll("[^\\p{L}\\p{N}]+", "");
                    if (!key.isEmpty()) {
                        result.computeIfAbsent(key, k -> new HashSet<>()).add(lineNumber);
                    }
                }
            }
        }
        return result;
    }

    static void main() throws Exception {
        Map<String, Set<Integer>> result = wordLines(
                "src/main/java/org/example/chapter07/task08/text.txt");

        result.forEach((word, lines) -> System.out.println(word + " -> " + lines));
    }
}

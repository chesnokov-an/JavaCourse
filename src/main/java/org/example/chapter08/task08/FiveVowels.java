package org.example.chapter08.task08;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Stream;

import static org.example.chapter08.task07.FileWords.words;

public class FiveVowels {
    public static String[] fiveVowelWords(Path path) throws Exception {
        try (Stream<String> words = words(path)) {
            return words.map(String::toLowerCase)
                        .filter(FiveVowels::hasFiveDistinctVowels)
                        .toArray(String[]::new);
        }
    }

    private static boolean hasFiveDistinctVowels(String word) {
        return word.chars().filter(c -> "aeiou".indexOf(c) >= 0)
                           .distinct()
                           .count() == 5;
    }

    static void main() throws Exception {
        Path path = Path.of("src/main/java/org/example/chapter08/task08/words.txt");
        System.out.println(Arrays.toString(fiveVowelWords(path)));
    }
}

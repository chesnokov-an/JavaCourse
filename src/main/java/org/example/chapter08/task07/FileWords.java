package org.example.chapter08.task07;

import org.example.chapter08.task06.WordCheck;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileWords {
    public static Stream<String> words(Path path) throws Exception {
        return Files.lines(path)
                .flatMap(line -> Arrays.stream(line.split("\\s+")))
                .filter(WordCheck::isWord);
    }

    static void main() throws Exception {
        Path path = Path.of("src/main/java/org/example/chapter08/task07/text.txt");

        try (Stream<String> words = words(path)) {
            System.out.println("Первые 100 слов:");
            System.out.println(words.limit(100).toList());
        }

        Map<String, Long> counts;
        try (Stream<String> words = words(path)) {
            counts = words
                    .map(word -> word.toLowerCase(Locale.ROOT))
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        }

        System.out.println();
        System.out.println("10 самых частых слов:");
        counts.entrySet().stream()
                .sorted(Comparator.comparingLong((Map.Entry<String, Long> entry) -> entry.getValue())
                        .reversed()
                        .thenComparing(Map.Entry::getKey))
                .limit(10)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}

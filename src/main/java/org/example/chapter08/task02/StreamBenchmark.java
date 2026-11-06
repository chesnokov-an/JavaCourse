package org.example.chapter08.task02;

import org.example.chapter08.task06.WordCheck;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class StreamBenchmark {
    public static long countLongWords(List<String> words, boolean parallel) {
        return (parallel ? words.parallelStream() : words.stream())
                .filter(word -> word.length() > 12)
                .count();
    }

    static void main() throws Exception {
        Path path = Path.of("src/main/java/org/example/chapter08/task16/war_and_peace.txt");
        List<String> words = Files.readAllLines(path).stream()
                .flatMap(line -> Arrays.stream(line.split("\\s+")))
                .filter(WordCheck::isWord)
                .toList();

        long start = System.currentTimeMillis();
        long sequential = countLongWords(words, false);
        long sequentialTime = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        long parallel = countLongWords(words, true);
        long parallelTime = System.currentTimeMillis() - start;

        System.out.println("Слов в тексте: " + words.size());
        System.out.println("Длинных слов: " + sequential + " / " + parallel);
        System.out.println("stream():         " + sequentialTime + " мс");
        System.out.println("parallelStream(): " + parallelTime + " мс");
    }
}

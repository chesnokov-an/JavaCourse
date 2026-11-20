package org.example.chapter08.task16;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static org.example.chapter08.task07.FileWords.words;

public class LongestWords {
    public static List<String> longestWords(List<String> words, int count, boolean parallel) {
        Stream<String> stream = parallel ? words.parallelStream() : words.stream();
        return stream.distinct()
                     .sorted(Comparator.comparingInt(String::length).reversed())
                     .limit(count)
                     .toList();
    }

    static void main() throws Exception {
        Path path = Path.of("src/main/java/org/example/chapter08/task16/war_and_peace.txt");
        List<String> words = words(path).toList();

        long start = System.currentTimeMillis();
        List<String> sequential = longestWords(words, 500, false);
        long sequentialTime = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        List<String> parallel = longestWords(words, 500, true);
        long parallelTime = System.currentTimeMillis() - start;

        System.out.println("Слов в тексте: " + words.size());
        System.out.println("Первые 10: " + sequential.subList(0, 10));
        System.out.println("stream():         " + sequentialTime + " мс");
        System.out.println("parallelStream(): " + parallelTime + " мс");
    }
}

package org.example.chapter08.task01;

import java.util.List;
import java.util.stream.Stream;

public class LazyFilter {
    public static List<String> firstLongWords(Stream<String> words, int count) {
        return words
                .filter(word -> {
                    System.out.println("filter: " + word);
                    return word.length() > 12;
                })
                .map(word -> {
                    System.out.println("map: " + word);
                    return word;
                })
                .limit(count)
                .toList();
    }

    static void main() {
        List<String> words = List.of(
                "java",
                "программирование",
                "функциональный",
                "преобразование",
                "бесконечность",
                "интернационализация",
                "переосмысление",
                "характеристика",
                "stream");

        System.out.println(firstLongWords(words.stream(), 5));
    }
}

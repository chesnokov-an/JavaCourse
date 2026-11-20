package org.example.chapter08.task01;

import java.util.List;
import java.util.stream.Stream;

public class LazyFilter {
    public static List<String> firstLongWords(Stream<String> words, int count) {
        return words.filter(word -> {
                    System.out.println("filter: " + word + " - " + word.length());
                    return word.length() > 12;
                })
                .peek(word -> System.out.println("map: " + word))
                .limit(count)
                .toList();
    }

    static void main() {
        List<String> words = List.of(
                "мама",
                "карбюратор",
                "Программирование",
                "преобразование",
                "претидижитатор",
                "интернационализация",
                "переосмысление",
                "характеристика",
                "потокииии");

        System.out.println(firstLongWords(words.stream(), 5));
    }
}

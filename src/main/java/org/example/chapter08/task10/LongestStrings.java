package org.example.chapter08.task10;

import java.util.List;
import java.util.stream.Stream;

public class LongestStrings {
    public static List<String> longest(Stream<String> strings) {
        List<String> all = strings.toList();
        int maxLength = all.stream().mapToInt(String::length).max().orElse(0);

        return all.stream()
                .filter(s -> s.length() == maxLength)
                .toList();
    }

    static void main() {
        System.out.println(longest(Stream.of("Java", "Collections", "Stream", "Programming")));
        System.out.println(longest(Stream.empty()));
    }
}

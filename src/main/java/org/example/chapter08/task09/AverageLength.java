package org.example.chapter08.task09;

import java.util.stream.Stream;

public class AverageLength {
    public static double averageLength(Stream<String> strings) {
        return strings.mapToInt(String::length).average().orElse(0);
    }

    static void main() {
        System.out.println(averageLength(Stream.of("Java", "Streams", "API")));
        System.out.println(averageLength(Stream.empty()));
    }
}

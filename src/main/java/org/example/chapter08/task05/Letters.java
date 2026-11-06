package org.example.chapter08.task05;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Letters {
    public static Stream<String> letters(String s) {
        return IntStream.range(0, s.length())
                .mapToObj(i -> s.substring(i, i + 1));
    }

    static void main() {
        System.out.println(letters("boat").toList());
        System.out.println(letters("Привет").toList());
    }
}

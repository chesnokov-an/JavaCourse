package org.example.chapter08.task03;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOfArray {
    static void main() {
        int[] values = {1, 4, 9, 16};

        System.out.println("Stream.of(values):"); // Stream.of(values) — это varargs Stream.of(T...)
        Stream.of(values).forEach(array -> System.out.println("  " + Arrays.toString(array)));
        System.out.println("Количество элементов: " + Stream.of(values).count());

        System.out.println("IntStream.of(values): " + IntStream.of(values).boxed().toList());
        System.out.println("Arrays.stream(values): " + Arrays.stream(values).boxed().toList());
    }
}

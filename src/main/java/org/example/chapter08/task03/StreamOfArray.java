package org.example.chapter08.task03;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOfArray {
    static void main() {
        int[] values = {1, 4, 9, 16};
        System.out.println("Количество элементов у Stream.of(values): " + Stream.of(values).count());
        // Stream.of(values) — это varargs Stream.of(T...), а int это примитивный тип

        System.out.println("IntStream.of(values): " + IntStream.of(values).boxed().toList());
        System.out.println("Arrays.stream(values): " + Arrays.stream(values).boxed().toList());
    }
}

package org.example.chapter06.task06;

import java.util.ArrayList;
import java.util.List;

public class Task06E {
    // Приёмник: List<E>, источник: List<? extends E>
    public static <E> void addAll(List<E> target, List<? extends E> source) {
        for (E item : source) {
            target.add(item);
        }
    }

    static void main() {
        List<Number> numbers = new ArrayList<>(List.of(1, 2));
        List<Integer> integers = List.of(10, 20);
        List<Double> doubles = List.of(1.5, 2.5);

        addAll(numbers, integers); // List<Integer> - подтип List<? extends Number>
        addAll(numbers, doubles);  // List<Double>  - подтип List<? extends Number>

        System.out.println(numbers);
    }
}
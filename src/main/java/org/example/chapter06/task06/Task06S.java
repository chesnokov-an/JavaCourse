package org.example.chapter06.task06;

import java.util.ArrayList;
import java.util.List;

public class Task06S {
    // Приёмник: List<? super E>, источник: List<E>
    public static <E> void addAll(List<? super E> target, List<E> source) {
        for (E item : source) {
            target.add(item);
        }
    }

    static void main() {
        List<Number> numbers = new ArrayList<>(List.of(1, 2));
        List<Object> objects = new ArrayList<>(List.of("x"));
        List<Integer> integers = List.of(10, 20);

        addAll(numbers, integers); // List<Number> - подтип List<? super Integer>
        addAll(objects, integers); // List<Object> - подтип List<? super Integer>

        System.out.println(numbers);
        System.out.println(objects);
    }
}
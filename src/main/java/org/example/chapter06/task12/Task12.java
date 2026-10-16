package org.example.chapter06.task12;

import java.util.Comparator;
import java.util.List;

public class Task12 {
    public static <T> void minmax(List<T> elements, Comparator<? super T> comp, List<? super T> result) {
        if (elements.isEmpty()) throw new IllegalArgumentException("empty collection");
        T min = elements.getFirst();
        T max = elements.getFirst();
        for (T item : elements) {
            if (comp.compare(item, min) < 0) min = item;
            if (comp.compare(item, max) > 0) max = item;
        }
        result.add(min);
        result.add(max);
    }

    static void main() {
        List<Integer> numbers = List.of(3, 7, 1, 9, 4);

        List<Number> result1 = new java.util.ArrayList<>();
        minmax(numbers, Comparator.naturalOrder(), result1);
        System.out.println(result1);
    }
}
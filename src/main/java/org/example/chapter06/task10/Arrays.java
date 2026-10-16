package org.example.chapter06.task10;

import java.util.Collection;
import java.util.List;

public class Arrays {
    public static <E extends Comparable<? super E>> E min(Collection<E> c) {
        if (c.isEmpty()) throw new IllegalArgumentException("empty collection");
        E result = null;
        for (E item : c) {
            if (result == null || item.compareTo(result) < 0) {
                result = item;
            }
        }
        return result;
    }

    public static <E extends Comparable<? super E>> E max(Collection<E> c) {
        if (c.isEmpty()) throw new IllegalArgumentException("empty collection");
        E result = null;
        for (E item : c) {
            if (result == null || item.compareTo(result) > 0) {
                result = item;
            }
        }
        return result;
    }

    static void main() {
        List<Integer> numbers = List.of(3, 7, 1, 9, 4);
        System.out.println("min: " + min(numbers));
        System.out.println("max: " + max(numbers));

        List<String> words = List.of("banana", "apple", "cherry");
        System.out.println("min: " + min(words));
        System.out.println("max: " + max(words));
    }
}
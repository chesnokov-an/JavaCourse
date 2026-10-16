package org.example.chapter06.task11;

import java.util.Collection;

public class Arrays {
    public static class Pair<E> {
        private final E first;
        private final E second;

        public Pair(E first, E second) {
            this.first = first;
            this.second = second;
        }

        public E getFirst() { return first; }
        public E getSecond() { return second; }
    }

    public static <E extends Comparable<? super E>> Pair<E> minMax(Collection<E> c) {
        if (c.isEmpty()) throw new IllegalArgumentException("empty collection");
        E min = null;
        E max = null;
        for (E item : c) {
            if (min == null || item.compareTo(min) < 0) min = item;
            if (max == null || item.compareTo(max) > 0) max = item;
        }
        return new Pair<>(min, max);
    }

    static void main() {
        var numbers = java.util.List.of(3, 7, 1, 9, 4);
        System.out.println(minMax(numbers).first);
        System.out.println(minMax(numbers).second);

        var words = java.util.List.of("banana", "apple", "cherry");
        System.out.println(minMax(words).first);
        System.out.println(minMax(words).second);
    }
}
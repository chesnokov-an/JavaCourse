package org.example.chapter06.task09;

import java.util.ArrayList;
import java.util.List;

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

    public static <E> Pair<E> firstLast(ArrayList<? extends E> a) {
        if (a.isEmpty()) {
            throw new IllegalArgumentException("Массив пуст");
        }
        return new Pair<>(a.get(0), a.get(a.size() - 1));
    }

    static void main() {
        ArrayList<Integer> ints = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        Pair<Integer> p1 = firstLast(ints);
        System.out.println(p1.first);
        System.out.println(p1.second);

        Pair<Number> p2 = Arrays.firstLast(ints);
        System.out.println(p2.first);
        System.out.println(p2.second);
    }
}
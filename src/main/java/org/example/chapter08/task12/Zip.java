package org.example.chapter08.task12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Zip {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();
        List<T> result = new ArrayList<>();

        while (firstIterator.hasNext() || secondIterator.hasNext()) {
            result.add(firstIterator.hasNext() ? firstIterator.next() : null);
            result.add(secondIterator.hasNext() ? secondIterator.next() : null);
        }
        return result.stream();
    }

    static void main() {
        System.out.println(zip(Stream.of(1, 2, 3), Stream.of(10, 20)).toList());
        System.out.println(zip(Stream.of(1, 2), Stream.of(10, 20, 30)).toList());
    }
}

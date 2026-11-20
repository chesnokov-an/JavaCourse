package org.example.chapter08.task17;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class AdjacentDistinct {
    public static <T> Stream<T> distinctAdjacent(Stream<T> stream) {
        return stream.filter(new Predicate<>() {
            private T previous;

            @Override
            public boolean test(T value) {
                if (!Objects.equals(previous, value)) {
                    previous = value;
                    return true;
                }
                return false;
            }
        });
    }

    static void main() {
        Stream<String> words = Stream.of("aaa", "aaa", "bbb", "bbb", "aaa", "ccc", "ccc");
        System.out.println(distinctAdjacent(words).toList());

        // В parallelStream() filter хранит состояние и зависит от порядка,
        // поэтому для параллельного потока метод не подходит.
    }
}

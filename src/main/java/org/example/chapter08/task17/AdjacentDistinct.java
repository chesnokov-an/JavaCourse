package org.example.chapter08.task17;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class AdjacentDistinct {
    public static <T> Stream<T> distinctAdjacent(Stream<T> stream) {
        return stream.filter(new Predicate<>() {
            private T previous;
            private boolean first = true;

            @Override
            public boolean test(T value) {
                if (first || !Objects.equals(previous, value)) {
                    first = false;
                    previous = value;
                    return true;
                }
                return false;
            }
        });
    }

    static void main() {
        Stream<String> words = Stream.of("a", "a", "b", "b", "a", "c", "c");
        System.out.println(distinctAdjacent(words).toList());

        // В parallelStream() filter хранит состояние и зависит от порядка,
        // поэтому для параллельного потока метод не подходит.
        System.out.println("Параллельный поток не поддерживается: важен порядок элементов.");
    }
}

package org.example.chapter08.task11;

import java.util.Iterator;
import java.util.stream.Stream;

public class FiniteCheck {
    public static <T> boolean isFinite(Stream<T> stream) {
        // Конечность можно проверить только полным перебором.
        // Для бесконечного потока он никогда не завершится, а для конечного — полностью его потребит
        Iterator<T> iterator = stream.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        return true;
    }

    static void main() {
        System.out.println("Конечный поток: " + isFinite(Stream.of(1, 2, 3)));
        System.out.println("Ограниченный Stream.iterate: "
                + isFinite(Stream.iterate(1, x -> x + 1).limit(5)));
    }
}

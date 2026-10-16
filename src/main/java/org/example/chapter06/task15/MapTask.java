package org.example.chapter06.task15;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MapTask {
    public static <T, R> List<R> map(List<T> elements, Function<T, R> f) {
        List<R> result = new ArrayList<>(elements.size());
        for (T item : elements) {
            result.add(f.apply(item));
        }
        return result;
    }

    static void main() {
        List<String> words = List.of("Java", "C++", "Python");
        List<Integer> lengths = map(words, String::length);
        System.out.println(lengths);
    }
}
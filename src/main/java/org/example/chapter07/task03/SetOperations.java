package org.example.chapter07.task03;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetOperations {
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    public static <T> Set<T> difference(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.removeAll(b);
        return result;
    }

    static void main() {
        Set<String> first = Set.of("Java", "Python", "C++", "Go");
        Set<String> second = Set.of("Python", "Go", "Rust");

        System.out.println("A: " + new TreeSet<>(first));
        System.out.println("B: " + new TreeSet<>(second));
        System.out.println("Объединение:  " + new TreeSet<>(union(first, second)));
        System.out.println("Пересечение:  " + new TreeSet<>(intersection(first, second)));
        System.out.println("Разность A-B: " + new TreeSet<>(difference(first, second)));
    }
}

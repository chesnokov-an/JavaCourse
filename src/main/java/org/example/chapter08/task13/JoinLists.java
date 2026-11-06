package org.example.chapter08.task13;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class JoinLists {
    public static <T> ArrayList<T> reduceWithOptional(Stream<ArrayList<T>> lists) {
        return lists.reduce((result, list) -> {
            result.addAll(list);
            return result;
        }).orElseGet(ArrayList::new);
    }

    public static <T> ArrayList<T> reduceWithIdentity(Stream<ArrayList<T>> lists) {
        return lists.reduce(new ArrayList<>(), (result, list) -> {
            result.addAll(list);
            return result;
        });
    }

    public static <T> ArrayList<T> reduceWithCombiner(Stream<ArrayList<T>> lists) {
        return lists.reduce(new ArrayList<>(), (result, list) -> {
            result.addAll(list);
            return result;
        }, (left, right) -> {
            left.addAll(right);
            return left;
        });
    }

    static void main() {
        System.out.println(reduceWithOptional(lists()));
        System.out.println(reduceWithIdentity(lists()));
        System.out.println(reduceWithCombiner(lists()));
    }

    private static Stream<ArrayList<String>> lists() {
        return Stream.of(
                new ArrayList<>(List.of("a", "b")),
                new ArrayList<>(List.of("c")),
                new ArrayList<>(List.of("d", "e")));
    }
}

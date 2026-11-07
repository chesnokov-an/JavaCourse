package org.example.chapter08.task13;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class JoinLists {
    public static <T> ArrayList<T> reduceWithOptional(Stream<ArrayList<T>> lists) {
        return lists.reduce((result, list) -> {
            result.addAll(list);
            return result;
        }).orElseGet(ArrayList::new); // первый список становится накопителем, в него addAll остальных
    }

    public static <T> ArrayList<T> reduceWithIdentity(Stream<ArrayList<T>> lists) {
        return lists.reduce(new ArrayList<>(), (result, list) -> {
            result.addAll(list);
            return result; // берём new ArrayList<>() как начальное значение и добавляем в него
        });
    }

    public static <T> ArrayList<T> reduceWithCombiner(Stream<ArrayList<T>> lists) {
        return lists.reduce(new ArrayList<>(), (result, list) -> {
            result.addAll(list);
            return result;
        }, (left, right) -> {
            left.addAll(right);
            return left;
        }); // третий аргумент нужен для параллельного выполнения:
            // он сливает частичные списки, полученные в разных потоках
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

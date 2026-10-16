package org.example.chapter06.task13;

import org.example.chapter06.task12.Task12;
import java.util.*;


public class Task13 {

    public static <T> void maxmin(List<T> elements, Comparator<? super T> comp, List<? super T> result) {
        Task12.minmax(elements, comp, result);
        Lists.swapHelper(result, 0, 1);
    }

    static class Lists {
        static <X> void swapHelper(List<X> list, int i, int j) {
            X temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }

    static void main() {
        List<Integer> elements = List.of(3, 1, 2);
        List<Number> result = new ArrayList<>();
        maxmin(elements, Comparator.naturalOrder(), result);
        System.out.println(result);
    }
}
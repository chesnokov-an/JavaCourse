package org.example.chapter07.task05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class SwapElements {
    public static void swap(List<?> list, int i, int j) {
        if (i == j) {
            return;
        }
        if (list instanceof RandomAccess) {
            swapRandomAccess(list, i, j);
        } else {
            swapIterator(list, i, j);
        }
    }

    private static <T> void swapRandomAccess(List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    // Для списков без произвольного доступа не проходим весь список,
    // а доходим итераторами только до позиций i и j
    private static <T> void swapIterator(List<T> list, int i, int j) {
        ListIterator<T> first = list.listIterator(i);
        ListIterator<T> second = list.listIterator(j);

        T firstValue = first.next();
        T secondValue = second.next();

        first.set(secondValue);
        second.set(firstValue);
    }

    static void main() {
        List<String> arrayList = new ArrayList<>(List.of("a", "b", "c", "d"));
        swap(arrayList, 0, 3);
        System.out.println("ArrayList:  " + arrayList);

        List<String> linkedList = new LinkedList<>(List.of("a", "b", "c", "d"));
        swap(linkedList, 0, 3);
        System.out.println("LinkedList: " + linkedList);
    }
}

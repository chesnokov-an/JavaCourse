package org.example.chapter07.extra_task01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class InsertMiddle {
    public static <E> void insertInMiddle(List<E> list, E element) {
        ListIterator<E> iterator = list.listIterator();
        for (int i = 0; i < list.size() / 2; i++) {
            iterator.next();
        }
        iterator.add(element); // add вставляет элемент между previous() и next()
    }

    static void main() {
        List<String> arrayList = new ArrayList<>(List.of("A", "B", "C", "D"));
        List<String> linkedList = new LinkedList<>(List.of("A", "B", "C", "D", "E"));

        insertInMiddle(arrayList, "middle");
        insertInMiddle(linkedList, "middle");

        System.out.println(arrayList);
        System.out.println(linkedList);

        List<String> empty = new ArrayList<>();
        insertInMiddle(empty, "only");
        System.out.println(empty);
    }
}

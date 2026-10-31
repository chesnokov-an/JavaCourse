package org.example.chapter07.task02;

import java.util.Arrays;
import java.util.ListIterator;

public class Uppercase {
    public static void withIterator(String[] strings) {
        ListIterator<String> iterator = Arrays.asList(strings).listIterator();
        while (iterator.hasNext()) {
            iterator.set(iterator.next().toUpperCase());
        }
    }

    public static void withIndex(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].toUpperCase();
        }
    }

    public static void withReplaceAll(String[] strings) {
        // List.replaceAll() из каркаса коллекций, а не String.replaceAll()
        Arrays.asList(strings).replaceAll(String::toUpperCase);
    }

    static void main() {
        String[] words = {"коллекции", "java", "iterator", "replaceAll"};

        String[] byIterator = words.clone();
        withIterator(byIterator);
        System.out.println("Итератор:    " + Arrays.toString(byIterator));

        String[] byIndex = words.clone();
        withIndex(byIndex);
        System.out.println("Индексный цикл: " + Arrays.toString(byIndex));

        String[] byReplaceAll = words.clone();
        withReplaceAll(byReplaceAll);
        System.out.println("replaceAll(): " + Arrays.toString(byReplaceAll));
    }
}

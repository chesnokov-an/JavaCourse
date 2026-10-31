package org.example.chapter07.task04;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModification {
    static void main() {
        List<String> words = new ArrayList<>(List.of("один", "два", "три"));

        // Удаление во время перебора for-each
        try {
            for (String word : words) {
                if (word.equals("один")) {
                    words.remove(word);
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Поймано: " + e.getClass().getSimpleName());
        }

        // 1. Удаление через итератор
        words = new ArrayList<>(List.of("один", "два", "три"));
        Iterator<String> iterator = words.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals("один")) {
                iterator.remove();
            }
        }
        System.out.println("iterator.remove(): " + words);

        // 2. Удаление через removeIf()
        words = new ArrayList<>(List.of("один", "два", "три"));
        words.removeIf(word -> word.equals("один"));
        System.out.println("removeIf():       " + words);

        // 3. Сначала собрать элементы, а удалить после окончания перебора
        words = new ArrayList<>(List.of("один", "два", "три"));
        List<String> toRemove = new ArrayList<>();
        for (String word : words) {
            if (word.equals("один")) {
                toRemove.add(word);
            }
        }
        words.removeAll(toRemove);
        System.out.println("removeAll():      " + words);
    }
}

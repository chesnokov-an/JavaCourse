package org.example.chapter03.task07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LuckySort {
    public static void luckySort(ArrayList<String> strings, Comparator<String> comp) {
        if (strings == null || strings.size() <= 1) {
            return;
        }

        while (true) {
            boolean sorted = true;
            for (int i = 0; i < strings.size() - 1; i++) {
                if (comp.compare(strings.get(i), strings.get(i + 1)) > 0) {
                    sorted = false;
                    break;
                }
            }
            if (sorted) {
                break;
            }
            Collections.shuffle(strings);
        }
    }

    static void main() {
        ArrayList<String> list = new ArrayList<>();
        list.add("banana");
        list.add("apple");
        list.add("cherry");
        list.add("date");

        System.out.println("До luckySort: " + list);
        luckySort(list, String::compareTo);
        System.out.println("После luckySort: " + list);
    }
}

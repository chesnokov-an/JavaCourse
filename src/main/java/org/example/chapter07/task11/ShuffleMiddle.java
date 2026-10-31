package org.example.chapter07.task11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleMiddle {
    public static void shuffleMiddle(List<String> words) {
        if (words.size() <= 2) {
            return;
        }
        // subList() — представление исходного списка, поэтому копирование не нужно
        Collections.shuffle(words.subList(1, words.size() - 1));
    }

    static void main() {
        List<String> words = new ArrayList<>(
                List.of("сегодня", "мы", "изучаем", "коллекции", "в", "java"));

        System.out.println("До:    " + words);
        shuffleMiddle(words);
        System.out.println("После: " + words);
    }
}

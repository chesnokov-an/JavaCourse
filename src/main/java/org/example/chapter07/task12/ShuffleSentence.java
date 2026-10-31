package org.example.chapter07.task12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleSentence {
    public static String shuffleSentence(String sentence) {
        List<String> words = new ArrayList<>(List.of(sentence.split("\\s+")));
        if (words.size() <= 2) {
            return sentence;
        }

        boolean hasPeriod = words.getLast().endsWith(".");
        if (hasPeriod) {
            words.set(words.size() - 1, words.getLast().substring(0, words.getLast().length() - 1));
        }

        String first = words.getFirst();
        words.set(0, Character.toLowerCase(first.charAt(0)) + first.substring(1));

        // Первое и последнее слова не перетасовываем
        Collections.shuffle(words.subList(1, words.size() - 1));

        String newFirst = words.getFirst();
        words.set(0, Character.toUpperCase(newFirst.charAt(0)) + newFirst.substring(1));

        if (hasPeriod) {
            words.set(words.size() - 1, words.getLast() + ".");
        }

        return String.join(" ", words);
    }

    static void main() {
        String sentence = "Сегодня мы изучаем коллекции в языке Java.";

        System.out.println("До:    " + sentence);
        System.out.println("После: " + shuffleSentence(sentence));
    }
}

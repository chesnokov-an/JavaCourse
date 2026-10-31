package org.example.chapter07.task06;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class DocumentRepresentation {
    // Интерфейс Map нельзя создать: new Map<>() не компилируется.
    // Кроме того, для каждого слова пришлось бы отдельно создавать внутреннее
    // множество, поэтому одного объявления типа недостаточно.
    // Решение: объявить переменную интерфейсного типа, а создать HashMap,
    // а внутренние множества добавлять через computeIfAbsent().
    public static Map<String, Set<Integer>> indexWords(List<String> lines) {
        Map<String, Set<Integer>> index = new TreeMap<>();
        for (int lineNumber = 0; lineNumber < lines.size(); lineNumber++) {
            for (String word : lines.get(lineNumber).split("\\s+")) {
                String key = word.toLowerCase();
                index.computeIfAbsent(key, k -> new HashSet<>()).add(lineNumber + 1);
            }
        }
        return index;
    }

    // Альтернатива без вложенных множеств: список множеств слов по строкам
    public static List<Set<String>> linesAsSets(List<String> lines) {
        List<Set<String>> result = new ArrayList<>();
        for (String line : lines) {
            result.add(new HashSet<>(List.of(line.toLowerCase().split("\\s+"))));
        }
        return result;
    }

    static void main() {
        List<String> document = List.of(
                "Коллекции хранят элементы",
                "Списки и множества являются коллекциями"
        );

        Map<String, Set<Integer>> index = indexWords(document);
        index.forEach((word, lines) -> System.out.println(word + " -> строки " + lines));

        System.out.println();
        System.out.println("Строки как множества слов:");
        for (Set<String> words : linesAsSets(document)) {
            System.out.println(words);
        }
    }
}

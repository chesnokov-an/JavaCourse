package org.example.chapter07.task06;

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
            for (String word : lines.get(lineNumber).split(" ")) {
                String key = word.toLowerCase();
                index.computeIfAbsent(key, k -> new HashSet<>()).add(lineNumber + 1);
            }
        }
        return index;
    }

    static void main() {
        List<String> document = List.of(
                "Коллекции хранят элементы",
                "Списки и множества являются коллекциями"
        );

        Map<String, Set<Integer>> index = indexWords(document);
        index.forEach((word, lines) -> System.out.println(word + " -> строки " + lines));
    }
}

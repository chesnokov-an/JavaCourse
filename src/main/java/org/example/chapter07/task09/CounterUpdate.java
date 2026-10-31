package org.example.chapter07.task09;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CounterUpdate {
    public static void updateWithContainsKey(Map<String, Integer> counts, String word) {
        if (counts.containsKey(word)) {
            counts.put(word, counts.get(word) + 1);
        } else {
            counts.put(word, 1);
        }
    }

    public static void updateWithGet(Map<String, Integer> counts, String word) {
        Integer count = counts.get(word);
        counts.put(word, count == null ? 1 : count + 1);
    }

    public static void updateWithGetOrDefault(Map<String, Integer> counts, String word) {
        counts.put(word, counts.getOrDefault(word, 0) + 1);
    }

    public static void updateWithPutIfAbsent(Map<String, Integer> counts, String word) {
        counts.putIfAbsent(word, 0);
        counts.put(word, counts.get(word) + 1);
    }

    static void main() {
        String[] words = {"java", "map", "java", "set", "java", "map"};

        Map<String, Integer> byContains = new HashMap<>();
        Map<String, Integer> byGet = new HashMap<>();
        Map<String, Integer> byGetOrDefault = new HashMap<>();
        Map<String, Integer> byPutIfAbsent = new HashMap<>();

        for (String word : words) {
            updateWithContainsKey(byContains, word);
            updateWithGet(byGet, word);
            updateWithGetOrDefault(byGetOrDefault, word);
            updateWithPutIfAbsent(byPutIfAbsent, word);
        }

        System.out.println("containsKey():  " + new TreeMap<>(byContains));
        System.out.println("get():          " + new TreeMap<>(byGet));
        System.out.println("getOrDefault(): " + new TreeMap<>(byGetOrDefault));
        System.out.println("putIfAbsent():  " + new TreeMap<>(byPutIfAbsent));
    }
}

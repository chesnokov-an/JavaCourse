package org.example.chapter07.task13;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cache<K, V> extends LinkedHashMap<K, V> {
    private final int maxSize;

    public Cache(int maxSize) {
        // accessOrder = true: порядок определяется обращениями, а не вставкой
        super(16, 0.75f, true);
        this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxSize;
    }

    static void main() {
        Cache<String, Integer> cache = new Cache<>(3);
        cache.put("один", 1);
        cache.put("два", 2);
        cache.put("три", 3);
        System.out.println("После трёх элементов: " + cache);

        cache.get("один"); // "один" становится самым свежим
        cache.put("четыре", 4); // вытесняется "два"
        System.out.println("После четвёртого:     " + cache);
    }
}

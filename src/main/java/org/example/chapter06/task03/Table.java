package org.example.chapter06.task03;

import java.util.ArrayList;

public class Table<K, V> {
    private final ArrayList<Entry<K, V>> entries = new ArrayList<>();

    public void put(K key, V value) {
        for (Entry<K, V> e : entries) {
            if (e.getKey().equals(key)) {
                e.value = value;
                return;
            }
        }
        entries.add(new Entry<>(key, value));
    }

    public V get(K key) {
        for (Entry<K, V> e : entries) {
            if (e.getKey().equals(key)) {
                return e.getValue();
            }
        }
        return null;
    }

    public V remove(K key) {
        for (int i = 0; i < entries.size(); i++) {
            if (entries.get(i).getKey().equals(key)) {
                return entries.remove(i).getValue();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return entries.toString();
    }

    static void main() {
        Table<String, Integer> table = new Table<>();
        table.put("один", 1);
        table.put("два", 2);
        table.put("три", 3);
        System.out.println(table);

        System.out.println(table.get("два"));
        System.out.println(table.get("сто"));
        table.put("два", 22);
        System.out.println(table.get("два"));
        System.out.println(table.remove("один"));
        System.out.println(table);
        System.out.println(table.remove("сто"));
    }
}
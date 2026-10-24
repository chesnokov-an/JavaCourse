package org.example.chapter06.task03;

import lombok.ToString;
import java.util.ArrayList;
import java.util.List;

@ToString
public class TableLombok<K, V> {
    private final List<EntryLombok<K, V>> entries = new ArrayList<>();

    public void put(K key, V value) {
        for (EntryLombok<K, V> e : entries) {
            if (e.getKey().equals(key)) {
                e.setValue(value);
                return;
            }
        }
        entries.add(new EntryLombok<>(key, value));
    }

    public V get(K key) {
        for (EntryLombok<K, V> e : entries) {
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

    static void main() {
        TableLombok<String, Integer> table = new TableLombok<>();
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

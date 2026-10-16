package org.example.chapter06.task04;

import java.util.ArrayList;

public class Table<K, V> {
    public class Entry { // но если static, то надо опять обобщать
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() { return key; }
        public V getValue() { return value; }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }
    private final ArrayList<Entry> entries = new ArrayList<>();

    public void put(K key, V value) {
        for (Entry e : entries) {
            if (e.getKey().equals(key)) {
                e.value = value;
                return;
            }
        }
        entries.add(new Entry(key, value));
    }

    public V get(K key) {
        for (Entry e : entries) {
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
package org.example.chapter06.task03;

public class Entry<K, V> {
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
package org.example.chapter06.task08;

public class Pair<E extends Comparable<E>> {
    private final E first;
    private final E second;

    public Pair(E first, E second) {
        this.first = first;
        this.second = second;
    }

    public E getFirst() {
        return first;
    }

    public E getSecond() {
        return second;
    }

    public E max() {
        return first.compareTo(second) >= 0 ? first : second;
    }

    public E min() {
        return first.compareTo(second) <= 0 ? first : second;
    }

    static void main() {
        Pair<Integer> numbers = new Pair<>(3, 7);
        System.out.println(numbers.max());
        System.out.println(numbers.min());

        Pair<String> words = new Pair<>("banana", "apple");
        System.out.println(words.max());
        System.out.println(words.min());
    }
}
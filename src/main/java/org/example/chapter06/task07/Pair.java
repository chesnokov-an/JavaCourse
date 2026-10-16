package org.example.chapter06.task07;

public class Pair<E> {
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

    static void main() {
        Pair<String> names = new Pair<>("Alice", "Bob");
        System.out.println(names.getFirst());
        System.out.println(names.getSecond());

        Pair<Integer> numbers = new Pair<>(1, 2);
        System.out.println(numbers.getFirst());
        System.out.println(numbers.getSecond());
    }
}
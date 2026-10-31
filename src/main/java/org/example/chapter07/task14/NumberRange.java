package org.example.chapter07.task14;

import java.util.AbstractList;
import java.util.Collections;
import java.util.List;

public class NumberRange {
    public static List<Integer> range(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n должно быть неотрицательным");
        }

        // Элементы не хранятся: get() вычисляет значение по индексу
        AbstractList<Integer> numbers = new AbstractList<>() {
            @Override
            public Integer get(int index) {
                if (index < 0 || index > n) {
                    throw new IndexOutOfBoundsException("index: " + index);
                }
                return index;
            }

            @Override
            public int size() {
                return n + 1;
            }
        };

        return Collections.unmodifiableList(numbers);
    }

    static void main() {
        List<Integer> numbers = range(10);
        System.out.println(numbers);
        System.out.println("size: " + numbers.size());
        System.out.println("get(10): " + numbers.get(10));

        try {
            numbers.add(11);
        } catch (UnsupportedOperationException e) {
            System.out.println("Изменение запрещено: " + e.getClass().getSimpleName());
        }
    }
}

package org.example.chapter07.task15;

import java.util.AbstractList;
import java.util.List;
import java.util.function.IntFunction;

public class FunctionList extends AbstractList<Integer> {
    private final IntFunction<Integer> function;

    public FunctionList(IntFunction<Integer> function) {
        this.function = function;
    }

    @Override
    public Integer get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        return function.apply(index);
    }

    // Коллекция может быть бесконечной, поэтому размер и массив не определены
    @Override
    public int size() {
        throw new UnsupportedOperationException("Бесконечная коллекция: размер не определён");
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Бесконечная коллекция: массив не может быть построен");
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Бесконечная коллекция: массив не может быть построен");
    }

    static void main() {
        List<Integer> squares = new FunctionList(i -> i * i);

        System.out.print("Квадраты первых чисел: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(squares.get(i) + " ");
        }
        System.out.println();

        try {
            squares.size();
        } catch (UnsupportedOperationException e) {
            System.out.println("size(): " + e.getMessage());
        }

        try {
            squares.toArray();
        } catch (UnsupportedOperationException e) {
            System.out.println("toArray(): " + e.getMessage());
        }
    }
}

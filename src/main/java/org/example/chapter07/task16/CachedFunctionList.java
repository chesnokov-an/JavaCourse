package org.example.chapter07.task16;

import org.example.chapter07.task13.Cache;

import java.util.AbstractList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntFunction;

public class CachedFunctionList extends AbstractList<Integer> {
    private static final int CACHE_SIZE = 100;

    private final IntFunction<Integer> function;
    private final Cache<Integer, Integer> cache = new Cache<>(CACHE_SIZE);

    public CachedFunctionList(IntFunction<Integer> function) {
        this.function = function;
    }

    @Override
    public Integer get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("index: " + index);
        }

        Integer value = cache.get(index);
        if (value == null) {
            value = function.apply(index);
            cache.put(index, value);
        }
        return value;
    }

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
        AtomicInteger calls = new AtomicInteger();
        List<Integer> squares = new CachedFunctionList(i -> {
            calls.incrementAndGet();
            return i * i;
        });

        System.out.println(squares.get(5));
        System.out.println(squares.get(5));
        System.out.println(squares.get(5));
        System.out.println("Вычислений для индекса 5: " + calls.get());

        for (int i = 0; i < CACHE_SIZE; i++) {
            squares.get(i);
        }
        System.out.println("Вычислений после индексов 0..99: " + calls.get());

        squares.get(100); // вытесняет самое старое значение (0)
        squares.get(0);   // значение 0 уже вытеснено, поэтому вычисляется снова
        System.out.println("Вычислений после вытеснения: " + calls.get());
    }
}

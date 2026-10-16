package org.example.chapter06.task21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstructTask {

    @SafeVarargs
    public static <T> T[] construct(int n, T... typeHint) {
        return Arrays.copyOf(typeHint, n);
    }

    static void main() {
        List<String>[] lists = ConstructTask.construct(10);
        System.out.println("Тип массива: " + lists.getClass().getSimpleName());
        System.out.println("Длина: " + lists.length);

        lists[0] = new ArrayList<>(List.of("a"));
        System.out.println(lists[0]);
    }
}
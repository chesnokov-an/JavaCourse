package org.example.chapter05.task12;

import java.util.Arrays;

public class Task12 {

    public static int min(int[] values) {
        int min = values[0];
        for (int v : values) {
            if (v < min) min = v;
        }
        assert isMinimum(min, values) : "min is not minimum";
        return min;
    }

    private static boolean isMinimum(int min, int[] values) {
        for (int v : values) {
            if (v < min) return false;
        }
        return true;
    }

    static void main() {
        int[] arr = new int[1_000_000];
        Arrays.fill(arr, 100);
        arr[500_000] = -5;

        long start = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            min(arr);
        }
        long time = System.nanoTime() - start;
        System.out.println("Время: " + time / 1_000_000 + " ms");
    }
}
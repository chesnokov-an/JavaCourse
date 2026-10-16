package org.example.chapter06.task20;

import java.util.Arrays;

public class RepeatTask {

    @SafeVarargs
    public static final <T> T[] repeat(int n, T... objs) {
        // Arrays.copyOf создаёт массив того же runtime-типа, что и objs
        T[] result = Arrays.copyOf(objs, n * objs.length);
        for (int i = objs.length; i < result.length; i++) {
            result[i] = objs[i % objs.length];
        }
        return result;
    }

    static void main() {
        String[] words = repeat(3, "a", "b");
        System.out.println(Arrays.toString(words));

        System.out.println(words.getClass().getSimpleName());
    }
}
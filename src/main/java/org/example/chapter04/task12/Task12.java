package org.example.chapter04.task12;

import java.lang.reflect.Method;

public class Task12 {
    static void main() throws Exception {
        int iterations = 1000000;

        long start = System.nanoTime();
        for (int i = 0; i < iterations; i++){
            Math.sqrt(i);
        }
        long end = System.nanoTime();
        System.out.println("Обычный вызов: " + (end - start) / 1000000 + " мс");

        Method sqrtMethod = Math.class.getMethod("sqrt", double.class);
        start = System.nanoTime();
        for (double i = 0; i < iterations; i++){
            sqrtMethod.invoke(null, i);
        }
        end = System.nanoTime();
        System.out.println("Рефлексия с ссылкой: " + (end - start) / 1000000 + " мс");

        start = System.nanoTime();
        for(double i = 0; i < iterations; i++){
            Math.class.getMethod("sqrt", double.class).invoke(null, i);
        }
        end = System.nanoTime();
        System.out.println("Рефлексия с ссылкой: " + (end - start) / 1000000 + " мс");
    }
}

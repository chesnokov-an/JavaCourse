package org.example.chapter04.task12;

import java.lang.reflect.Method;

public class Task12 {
    static void main() throws Exception {
        int iterations = 1000000;
        double sum = 0;

        // Обычный вызов
        long start = System.nanoTime();
        for (int i = 0; i < iterations; i++){
            sum += Math.sqrt(i);
        }
        long end = System.nanoTime();
        System.out.println("Обычный вызов: " + (end - start) / 1000000 + " мс");

        // Вызов через рефлексию
        Method sqrtMethod = Math.class.getMethod("sqrt", double.class);
        sum = 0;
        start = System.nanoTime();
        for (double i = 0; i < iterations; i++){
            sum += (Double) sqrtMethod.invoke(null, i);
        }
        end = System.nanoTime();
        System.out.println("Рефлексия: " + (end - start) / 1000000 + " мс");
    }
}

package org.example.chapter04.task13;

import java.lang.reflect.Method;
import java.util.function.DoubleFunction;

public class Task13 {
    public static void printTable(Method method, double from, double to, double step) throws Exception {
        System.out.println("Таблица для " + method.getName());
        for(double x = from; x <= to; x += step){
            Object result = method.invoke(null, x);
            System.out.printf("%.2f -> %s%n", x, result);
        }
    }

    public static void printTable(DoubleFunction<Object> func, double from, double to, double step){
        System.out.println("Таблица через DoubleFunction");
        for(double x = from; x <= to; x += step){
            Object result = func.apply(x);
            System.out.printf("%.2f -> %s%n", x, result);
        }
    }

    static void main() throws Exception {
        printTable(Math.class.getMethod("sqrt", double.class), 1, 5, 1);
        printTable(Double.class.getMethod("toHexString", double.class), 1, 5, 1);
        printTable(Math::sqrt, 1, 5, 1);
    }
}

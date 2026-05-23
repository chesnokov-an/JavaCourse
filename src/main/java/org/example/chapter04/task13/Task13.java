package org.example.chapter04.task13;

import java.lang.reflect.Method;
import java.util.function.DoubleFunction;

public class Task13 {
    // Версия с Method — теперь работает с любым возвращаемым типом
    public static void printTable(Method method, double from, double to, double step) throws Exception {
        System.out.println("Таблица для " + method.getName());
        for (double x = from; x <= to; x += step) {
            Object result = method.invoke(null, x);  // не приводим к double
            // Форматируем результат как строку; если это Number, выводим числом, иначе строкой
            String formatted;
            if (result instanceof Number) {
                formatted = String.format("%10.4f", ((Number) result).doubleValue());
            } else {
                formatted = result.toString();
            }
            System.out.printf("%10.4f -> %s%n", x, formatted);
        }
    }

    // Версия с DoubleFunction<Object>
    public static void printTable(DoubleFunction<Object> func, double from, double to, double step) {
        System.out.println("Таблица через DoubleFunction");
        for (double x = from; x <= to; x += step) {
            Object result = func.apply(x);
            String formatted = (result instanceof Number) ?
                    String.format("%10.4f", ((Number) result).doubleValue()) : result.toString();
            System.out.printf("%10.4f -> %s%n", x, formatted);
        }
    }

    static void main() throws Exception {
        // Math.sqrt
        Method sqrtMethod = Math.class.getMethod("sqrt", double.class);
        printTable(sqrtMethod, 1, 5, 1);

        // Double.toHexString
        Method hexMethod = Double.class.getMethod("toHexString", double.class);
        printTable(hexMethod, 1, 5, 1);

        // DoubleFunction<Object>
        DoubleFunction<Object> sqrtFunc = Math::sqrt;
        printTable(sqrtFunc, 1, 5, 1);
    }
}

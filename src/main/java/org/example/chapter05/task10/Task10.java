package org.example.chapter05.task10;

public class Task10 {

    public static int factorial(int n) {
        Throwable t = new Throwable();

        System.out.println("n = " + n);
        for (StackTraceElement frame : t.getStackTrace()) {
            System.out.println("  " + frame);
        }

        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    static void main() {
        int result = factorial(4);
        System.out.println("Результат: " + result);
    }

}

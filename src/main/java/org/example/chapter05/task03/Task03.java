package org.example.chapter05.task03;

import org.example.chapter05.task02.Task02;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;

public class Task03 {
    static void main() {
        try {
            double result = Task02.sumOfValues("src/main/java/org/example/chapter05/task01/numbers.txt");
            System.out.println("Сумма: " + result);
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: файл не найден - " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: в файле есть данные, не являющиеся числами - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Непредвиденная ошибка: " + e.getMessage());
        }
    }
}

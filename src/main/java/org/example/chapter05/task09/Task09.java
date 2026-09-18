package org.example.chapter05.task09;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Task09 {
    static void main() throws FileNotFoundException {
        Scanner in = new Scanner(new File("data.txt"));
        int x = in.nextInt();
        if (in.ioException() != null) {
            System.out.println("Ошибка ввода: " + in.ioException().getMessage());
        }
        // методы чтения (next(), nextInt() и т.д.) не бросают IOException.
        // Вместо этого исключение сохраняется внутри и доступно через метод ioException()

        PrintWriter out = new PrintWriter("out.txt");
        out.println("Hello");
        if (out.checkError()) {
            System.out.println("Ошибка записи!");
        }
        // методы записи (print(), println()) не бросают IOException.
        // Вместо этого внутренний флаг ошибки проверяется методом checkError()

        // Проблемы для новичков:
        // конструкторы всё равно требуют обработки исключений, а ошибки ввода-вывода теперь легко пропустить
    }
}

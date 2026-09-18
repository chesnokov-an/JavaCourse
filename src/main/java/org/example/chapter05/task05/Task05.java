package org.example.chapter05.task05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Task05 {

    public static void copyLowerCase(String inputFile, String outputFile) {
        Scanner in = null;
        PrintWriter out = null;

        try {
            in = new Scanner(inputFile);
            out = new PrintWriter(outputFile);
            while (in.hasNext()) {
                out.println(in.next().toLowerCase());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                    System.err.println("Ошибка при закрытии выходного файла: " + e.getMessage());
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    System.err.println("Ошибка при закрытии входного файла: " + e.getMessage());
                }
            }
        }
    }

    static void main() {
        copyLowerCase("src/main/java/org/example/chapter05/task05/input.txt",
                "src/main/java/org/example/chapter05/task05/output.txt");
        System.out.println("Готово");
    }

}

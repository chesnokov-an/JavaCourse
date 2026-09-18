package org.example.chapter05.task01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task01 {

    public static ArrayList<Double> readValues(String filename) throws FileNotFoundException {
        ArrayList<Double> values = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNext()) {
                if (scanner.hasNextDouble()) {
                    values.add(scanner.nextDouble());
                } else {
                    throw new InputMismatchException("Ожидалось число с плавающей точкой, получено: " + scanner.next());
                }
            }
        }
        return values;
    }

    static void main() throws Exception {
        ArrayList<Double> values = readValues("src/main/java/org/example/chapter05/task01/numbers.txt");
        System.out.println(values);
    }

}
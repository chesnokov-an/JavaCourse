package org.example.chapter05.task04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Task04 {

    public static final int SUCCESS = 0;
    public static final int FILE_NOT_FOUND = 1;
    public static final int INVALID_DATA = 2;

    public static int readValues(String filename, ArrayList<Double> values) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNext()) {
                if (scanner.hasNextDouble()) {
                    values.add(scanner.nextDouble());
                } else {
                    return INVALID_DATA;
                }
            }
            return SUCCESS;
        } catch (FileNotFoundException e) {
            return FILE_NOT_FOUND;
        }
    }

    public static int sumOfValues(String filename, double[] result) {
        ArrayList<Double> values = new ArrayList<>();
        int code = readValues(filename, values);
        if (code != SUCCESS) {
            return code;
        }
        double sum = 0;
        for (double v : values) {
            sum += v;
        }
        result[0] = sum;
        return SUCCESS;
    }

    static void main() {
        double[] result = new double[1];
        int code = sumOfValues("src/main/java/org/example/chapter05/task01/numbers.txt", result);
        switch (code) {
            case SUCCESS:
                System.out.println("Сумма: " + result[0]);
                break;
            case FILE_NOT_FOUND:
                System.out.println("Ошибка: файл не найден.");
                break;
            case INVALID_DATA:
                System.out.println("Ошибка: в файле есть данные, не являющиеся числами.");
                break;
            default:
                System.out.println("Неизвестная ошибка.");
        }
    }

}

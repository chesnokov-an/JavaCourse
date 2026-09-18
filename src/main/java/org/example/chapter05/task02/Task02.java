package org.example.chapter05.task02;

import org.example.chapter05.task01.Task01;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Task02 {

    public static double sumOfValues(String filename) throws FileNotFoundException {
        ArrayList<Double> values = Task01.readValues(filename);
        double sum = 0;
        for (double v : values) {
            sum += v;
        }
        return sum;
    }

    static void main() throws Exception {
        System.out.println(sumOfValues("src/main/java/org/example/chapter05/task01/numbers.txt"));
    }

}
